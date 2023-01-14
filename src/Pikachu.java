import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Pikachu extends Pokemon {
   // private  String[] attacks;
    private int electric;
    private int countTurn;
    private int countSpecialaction;
    private int countTurnAlaction;
    private final String TYPE = "ELECTRIC";


    public Pikachu() {
        this.setName("Pichu");
        this.setLevel(1);
        this.setMaxHp(40);
        this.setHp(40);
        this.setMaxAttackPoints(30);
        this.setAttackPoints(22.5);
        Attack quickAttack = new Attack("Quick Attack", 5, 10, 10);
        this.addAttacks(quickAttack);
        this.countSpecialaction=0;
    }


    public boolean levelUp() {
        boolean evolved = false;
        if (this.getLevel() == 1 && this.getAttackPoints()>25 && this.getHp()>20) {
            this.setName("Pikachu");
            this.setLevel(2);
            this.setMaxHp(50);
            this.setHp((this.getHp() - 20));
            this.setMaxAttackPoints(40);
            this.setAttackPoints((getAttackPoints() - 25));
            Attack electroBall = new Attack("Electro Ball", 10, 30, 40);
            this.addAttacks(electroBall);
            evolved = true;
        } else if (this.getLevel() == 2 && this.getAttackPoints()>40 && this.getHp()>30) {
            this.setName("Raichu");
            this.setLevel(3);
            this.setMaxHp(160);
            this.setHp((this.getHp() - 30));
            this.setMaxAttackPoints(80);
            this.setAttackPoints((getAttackPoints() - 40));
            Attack electricSurfer = new Attack("Electric Surfer", 60, 20, 120);
            this.addAttacks(electricSurfer);
            evolved = true;
        }
        if (evolved) {
            System.out.println("Your pokemon evolved");
        } else System.out.println("Your pokemon cant evolve");
        return evolved;

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
            System.out.print("You don't have enough points to attack");
            attack = -1;
        } else {
            int tempBonus;
            this.setAttackPoints((this.getAttackPoints() - attackChoice.getCost()));
            attack = attackChoice.getRandomDamage();
            if (Objects.equals(this.getType(), "ELECTRIC")) {// חושב שמיותר צריך לבדוק

                attack = attack + (attack * (electricPoint() / 100));
            }
            System.out.print("You dealt damage to an opponent of: " + attack + " point.");

        }
        return attack;

    }

    private int electricPoint(){
        int tempBonus;
        if(this.getHp()<((this.getMaxHp()*20)/100)){ //במידה ונקודות החיים פחות מ 20 אחוז מהמקסימום השמל מתאפס
            tempBonus = 0;
            this.countSpecialaction=getTurn();
        }else  {
            this.countSpecialaction=getTurn()-this.countSpecialaction;
            tempBonus = this.countSpecialaction*5;
        }

        return tempBonus;
    }
    public boolean specialaction(Pokemon pokemon){
        boolean check=false;
        if(this.countSpecialaction==0) {
            this.setHp(this.getMaxHp());
            this.setAttackPoints(this.getMaxAttackPoints());
            System.out.print("You have filled your pokemon with all the hp and attack points");
            check=true;
        }else {
            System.out.print("You have used this option already");
            check=false;
        }
        return check;
    }


    public String getType() {
        return TYPE;
    }
}

