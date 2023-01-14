import java.util.Random;
import java.util.Scanner;

public class Charmander extends Pokemon {
    private String[] attacks;
    private final String TYPE = "FIRE";


    public Charmander() {
        this.setName("Charmander");
        this.setLevel(1);
        this.setMaxHp(80);
        this.setHp(80);
        this.setMaxAttackPoints(40);
        this.setAttackPoints(30);
        Attack scratch = new Attack("Scratch", 15, 25, 30);
        this.addAttacks(scratch);
    }

    public boolean levelUp() {
        boolean evolved = false;
        if (this.getLevel() == 1 && this.getAttackPoints()>25 && this.getHp()>20) {
            this.setName("Charmeleon");
            this.setLevel(2);
            this.setMaxHp(90);
            this.setHp((this.getHp() - 20));
            this.setMaxAttackPoints(60);
            this.setAttackPoints((getAttackPoints() - 25));
            Attack flame = new Attack("Flame Tail", 40, 30, 50);
            this.addAttacks(flame);
            evolved = true;
        } else if (this.getLevel() == 2 && this.getAttackPoints()>40 && this.getHp()>30) {
            this.setName("Charizard");
            this.setLevel(3);
            this.setMaxHp(130);
            this.setHp((this.getHp() - 30));
            this.setMaxAttackPoints(80);
            this.setAttackPoints((getAttackPoints() - 40));
            Attack fiery = new Attack("Fiery Blast", 40, 30, 50);
            this.addAttacks(fiery);
            evolved = true;

        }
        if (evolved) {
            System.out.println("Your pokemon evolved");
        }else System.out.println("Your pokemon cant evolve");
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
            this.setAttackPoints((this.getAttackPoints() - attackChoice.getCost()));
            attack = attackChoice.getRandomDamage();
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
    public boolean specialaction(Pokemon pokemon){
        Random random=new Random();
        int randomAttack=random.nextInt(0,this.getAttacks().length);
        System.out.println("First drawn attack: "+ this.getAttacks()[randomAttack]);
        int attackPoint1=this.getAttacks()[randomAttack].getRandomDamage();
        randomAttack=random.nextInt(0,this.getAttacks().length);
        System.out.println("Second  drawn attack: "+ this.getAttacks()[randomAttack]);
        int attackPoint2=this.getAttacks()[randomAttack].getRandomDamage();
        pokemon.downHp(attackPoint1+attackPoint2);
        this.setAttackPoints(0);
        this.setHp((getHp()*50)/100);
        boolean check=true;

        return check;
    }


    public String getTYPE(){
        return TYPE;
    }
}
