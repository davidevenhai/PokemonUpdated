import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public abstract class Pokemon {
    private String name;
    private int level;
    private int hp;
    private int maxHp;
    private int maxAttackPoints;
    private double attackPoints;
    private int turn = 0;

    private Attack kick = new Attack("Kick", 0, 2, 2);
    private Attack[] attacks = {kick};
    protected String type;
    protected int countTurnElectric;

    public void addAttacks(Attack attack) {
        Attack[] arrayAttacks = new Attack[this.attacks.length + 1];
        for (int i = 0; i < this.attacks.length; i++) {
            arrayAttacks[i] = this.attacks[i];
        }
        arrayAttacks[arrayAttacks.length - 1] = attack;
        this.attacks = arrayAttacks;
    }

    public void newTurn() {
        Random random = new Random();
        this.hp += random.nextInt(0, 5);
        if(this.getHp()>this.getMaxHp()){
            this.setHp(this.getMaxHp());
        }
        this.attackPoints += random.nextInt(0, 5);
        if(this.getAttackPoints()>this.getMaxAttackPoints()){
            this.setAttackPoints(this.getMaxAttackPoints());
        }
        this.turn++;
    }

    public int getTurn() {
        return turn;
    }

    public void waiting() {
        Random random = new Random();
        int choiceRandom = random.nextInt(1, 5);
        switch (choiceRandom) {
            case 1 -> {
                int extraHp = random.nextInt(5, 31);
                this.hp += extraHp;
                if(this.hp>this.maxHp){
                    this.hp = this.maxHp;
                }
                System.out.println("You got an extra hp and your new hp is " + getHp());
            }
            case 2 -> {
                int extraAttack = random.nextInt(0, 41);
                this.attackPoints += extraAttack;
                if(this.getAttackPoints()>this.maxAttackPoints){
                    setAttackPoints(getMaxAttackPoints());
                }
                System.out.println("You got an extra attack point and your new attack point is "+getAttackPoints());
            }
            case 3 -> {
                 this.turnAttackWaiting=this.turn;
                System.out.println("You got triple attack power");
            }
        }
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Pokemon " +
                "name='" + name + '\'' + "\n" +
                "level=" + level +
                ", hp=" + hp +
                ", Max Hp=" + maxHp + "\n" +
                "Attack Points=" + attackPoints +
                ", Max Attack Points=" + maxAttackPoints + " \n"
//                +
//                "Attacks = " + Arrays.toString(attacks)
                ;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public Attack getKick() {
        return kick;
    }

    public Attack[] getAttacks() {
        return attacks;
    }

    public int getMaxAttackPoints() {
        return maxAttackPoints;
    }


    public void setLevel(int level) {
        this.level = level;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setMaxAttackPoints(int maxAttackPoints) {
        this.maxAttackPoints = maxAttackPoints;
    }

    public int attack() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your attack list:");
        for (int i = 0; i < this.getAttacks().length; i++) {
            System.out.println(this.getAttacks()[i]);
        }
        boolean checkInput = false;
        Attack attackChoice = null;
        int attack;
        do {
            System.out.println("Insert your attack :");
            String attackUser = scanner.nextLine();
            for (int i = 0; i < this.getAttacks().length; i++) {
                if (this.getAttacks()[i].mateAttack(attackUser)) {
                    checkInput = true;
                    attackChoice = this.getAttacks()[i];
                    break;
                }
            }
        } while (!checkInput);
        if ((this.getAttackPoints() - attackChoice.getCost()) < 0) {
            System.out.println("You don't have enough points to attack");
            attack = -1;
        } else {
            this.setAttackPoints((this.getAttackPoints() - attackChoice.getCost()));
            attack = attackChoice.getRandomDamage();
            if(this.turnAttackWaiting+1==this.turn){
                attack *= 3;
                System.out.println("You got EXTRA power, your damage multiplied by 3 for one turn");
            }
            if (Objects.equals(this.getType(), "ELECTRIC")) {
                attack = attack + (attack * (electricPoint() / 100));
                System.out.println("You dealt damage to an opponent of: " + attack + " point.");
            } else if (Objects.equals(this.getType(), "FIRE")) {
                int selfHarm = DownHpAttack();
                if (selfHarm == 0) {
                    System.out.println("You dealt damage to an opponent of: " + attack + " point." + "\n" + "There was no self-harm");
                } else {
                    System.out.println("You dealt damage to an opponent of: " + attack + " point." + "\n" + "There is self harm of: " + selfHarm + " damage to your hp");
                }
            }

        }
        return attack;
    }

    private int electricPoint() {
        int tempBonus;
        if (this.getHp() < ((this.getMaxHp() * 20) / 100)) { //במידה ונקודות החיים פחות מ 20 אחוז מהמקסימום השמל מתאפס
            tempBonus = 0;
            this.countTurnElectric = getTurn();
        } else {
            this.countTurnElectric = getTurn() - this.countTurnElectric;
            tempBonus = this.countTurnElectric * 5;
        }
        return tempBonus;
    }

    private int DownHpAttack() {
        Random random = new Random();
        int selfHarm = 0;
        int likelihoodHp = random.nextInt(1, 100);
        if (likelihoodHp < 25) {
            selfHarm = random.nextInt(3, 10);
            setHp(getHp() - selfHarm);
        }
        return selfHarm;
    }


    // public abstract int attack() ;
    public abstract boolean levelUp();

    public void downHp(int numDown) {
        this.hp -= numDown;
    }

    private int countSpecialAction = 0;

    public boolean specialAction(Pokemon pokemon) {
        Random random = new Random();
        boolean check = false;
        if (getType().equals("FIRE")) {
            System.out.println("You choosed your special attack, You will strike Twice\n" +
                    "and you will lose 50% of your Hp and all of your attack points");
            int randomAttack = random.nextInt(0, this.getAttacks().length);
            System.out.println("First drawn attack: " + this.getAttacks()[randomAttack]);
            int attackPoint1 = this.getAttacks()[randomAttack].getRandomDamage();
            randomAttack = random.nextInt(0, this.getAttacks().length);
            System.out.println("Second drawn attack: " + this.getAttacks()[randomAttack]);
            int attackPoint2 = this.getAttacks()[randomAttack].getRandomDamage();
            pokemon.downHp(attackPoint1 + attackPoint2);
            this.setAttackPoints(0);
            this.setHp((getHp() * 50) / 100);
            System.out.println("Your hp: "+this.hp+"Your attack points :"+this.attackPoints);


        } else if (getType().equals("ELECTRIC")) {
            if (this.countSpecialAction == 0) {
                this.setHp(this.getMaxHp());
                this.setAttackPoints(this.getMaxAttackPoints());
                System.out.println("You have filled your pokemon with all the hp and attack points");
                countSpecialAction++;
                check = true;
            } else {
                System.out.println("You have used this option already");
            }
        }
        return check;
    }

}
