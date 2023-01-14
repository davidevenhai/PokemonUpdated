import java.util.Arrays;
import java.util.Random;

public abstract class Pokemon {
    private String name;
    private int level;
    private int hp;
    private int maxHp;
    private int maxAttackPoints;
    private double attackPoints;
    private int turn=0;

    private Attack kick = new Attack("kick", 0, 2, 2);
    private Attack[] attacks = {kick};

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
        this.hp = random.nextInt(0, 4);
        this.attackPoints = random.nextInt(0, 4);
        this.turn++;
    }

    public int getTurn() {
        return turn;
    }

    public void waiting() {
        Random random = new Random();
        int choiceRandom = random.nextInt(1, 3);
        switch (choiceRandom) {
            case 1 -> {
                int extraHp = random.nextInt(5, 30);
                this.hp += extraHp;
                System.out.println("You got an extra hp of: " + extraHp);
            }
            case 2 -> {
                int extraAttack = random.nextInt(0, 40);
                this.attackPoints += extraAttack;
                System.out.println("You got an extra attack point of: " + extraAttack);
            }
            case 3 -> {
                this.attackPoints *= 3;
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

    @Override
    public String toString() {
        return "Pokemon " +
                "name='" + name + '\'' +"\n"+
                "level=" + level +
                ", hp=" + hp +
                ", Max Hp=" + maxHp + "\n"+
                "Attack Points=" + attackPoints +
                ", Max Attack Points=" + maxAttackPoints +" \n"+
                "Attacks=" + Arrays.toString(attacks)
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


    public abstract int attack() ;
    public abstract boolean levelUp();
    public void downHp(int numDown){
        this.hp-=numDown;
    }
    public abstract boolean specialaction(Pokemon pokemon);
}
