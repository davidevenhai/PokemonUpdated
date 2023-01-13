import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Pichu extends Pokemon {
    private  String[] attacks;
    private final String TYPE = "ELECTRIC";


    public Pichu() {
        this.setName("Pikachu");
        this.setLevel(1);
        this.setMaxHp(40);
        this.setHp(40);
        this.setMaxAttackPoints(30);
        this.setAttackPoints(22.5);
        Attack quickAttack = new Attack("Quick Attack", 5, 10, 10);
        this.addAttacks(quickAttack);
    }

    public boolean levelUp() {
        boolean evolved = false;
        if (this.getLevel() == 1) {
            this.setName("Pikachu");
            this.setLevel(2);
            this.setMaxHp(50);
            this.setHp((this.getHp() - 20));
            this.setMaxAttackPoints(40);
            this.setAttackPoints((getAttackPoints() - 25));
            Attack electroBall = new Attack("Electro Ball", 10, 30, 40);
            this.addAttacks(electroBall);
            evolved = true;
        } else if (this.getLevel() == 2) {
            this.setName("Raichu");
            this.setLevel(3);
            this.setMaxHp(160);
            this.setHp((this.getHp() - 20));
            this.setMaxAttackPoints(80);
            this.setAttackPoints((getAttackPoints() - 25));
            Attack electricSurfer = new Attack("Electric Surfer", 60, 20, 120);
            this.addAttacks(electricSurfer);
            evolved = true;
        }
        if (evolved) {
            System.out.println("Your pokemon evolved");
        } else System.out.println("Your pokemon cant evolve");
        return evolved;

    }

    public int attack(int turnCounter) {
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
            attack = 0;
        } else {
            this.setAttackPoints((this.getAttackPoints() - attackChoice.getCost()));
            attack = random.nextInt(attackChoice.getMinDamage(), attackChoice.getMaxDamage());
            if (Objects.equals(this.getType(), "ELECTRIC")) {
                attack = attack + (attack * (turnCounter / 100));
            }
            System.out.print("You dealt damage to an opponent of: " + attack + " point.");

        }
        return attack;

    }


    public String toString() {

        return "Name pokemon: " + this.getName() + "\n" +"Hp:" + this.getHp() + "\n" + "Attack points: " + this.getAttackPoints();
    }

    public String getType() {
        return TYPE;
    }
}

