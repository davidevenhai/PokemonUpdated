import java.util.Random;
import java.util.Scanner;

public class Moltres extends Pokemon {
    private String[] attacks;
    private final String TYPE = "FIRE";


    public Moltres() {
        this.setName("Moltres");
        this.setLevel(1);
        this.setMaxHp(120);
        this.setHp(120);
        this.setMaxAttackPoints(60);
        this.setAttackPoints(45);
        Attack assistingHeater = new Attack("Assisting Heater", 30, 10, 60);
        this.addAttacks(assistingHeater);
    }

    public boolean levelUp() {
        System.out.println("Moltres cant evolve");
        return false;
    }

    public int attack() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your attack list:");
        for (int i = 0; i < this.getAttacks().length; i++) {
            System.out.println(this.getAttacks()[i] + "");
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
            int selfHarm = DownHpAttack();
            if (selfHarm == 0) {
                System.out.print("You dealt damage to an opponent of: " + attack + " point." + "\n" + " There was no self-harm");
            } else {
                System.out.print("You dealt damage to an opponent of: " + attack + " point." + "\n" + " There is self harm of: " + selfHarm + "to your hp");
            }
        }
        return attack;
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

    public String toString() {

        return "Name pokemon: " + this.getName() + "\n" +"Hp:" + this.getHp() + "\n" + "Attack points: " + this.getAttackPoints();
    }
    public String getType(){
        return TYPE;
    }
}
