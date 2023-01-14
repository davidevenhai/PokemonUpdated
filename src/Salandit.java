import java.util.Random;
import java.util.Scanner;

public class Salandit extends Charmander{
    //private String[] attacks;
   // private final String TYPE = "FIRE";


    public Salandit() {
        this.setName("Salandit");
        this.setLevel(1);
        this.setMaxHp(100);
        this.setHp(100);
        this.setMaxAttackPoints(60);
        this.setAttackPoints(45);
        Attack liveCoal = new Attack("Live Coal", 10, 0, 25);
        this.addAttacks(liveCoal);
    }

    public boolean levelUp() {
        boolean evolved = false;
        if (this.getLevel() == 1 && this.getAttackPoints()>25 && this.getHp()>20) {
            this.setName("Salazzle");
            this.setLevel(2);
            this.setMaxHp(160);
            this.setHp((this.getHp() - 20));
            this.setMaxAttackPoints(80);
            this.setAttackPoints((getAttackPoints() - 25));
            Attack fireClaws = new Attack("Fire Claws", 25, 0, 50);
            this.addAttacks(fireClaws);
            evolved = true;
        }
        if (evolved) {
            System.out.println("Your pokemon evolved");
        }else System.out.println("Your pokemon cant evolve");
        return evolved;

    }

    //public int attack() {
     //   Random random = new Random();
    //    Scanner scanner = new Scanner(System.in);
      //  System.out.println("Your attack list:");
     //   for (int i = 0; i < this.getAttacks().length; i++) {
     //       System.out.println(this.getAttacks()[i]);
     //   }
     //   boolean checkInput = false;
     //   Attack attackChoice = null;
     //   int attack;
     //   do {
        //    System.out.println("Insert your attack :");
       //     String attackUser = scanner.nextLine();
        //    for (int i = 0; i < this.getAttacks().length; i++) {
         //       if (this.getAttacks()[i].mateAttack(attackUser)) {
         //           checkInput = true;
        //            attackChoice = this.getAttacks()[i];
         //           break;
        //        }
       //     }
       // } while (!checkInput);
    //    if ((this.getAttackPoints() - attackChoice.getCost()) < 0) {
      //      System.out.print("You don't have enough points to attack");
      //      attack = 0;
      //  } else {
      //      this.setAttackPoints((this.getAttackPoints() - attackChoice.getCost()));
       //     attack = random.nextInt(attackChoice.getMinDamage(), attackChoice.getMaxDamage());
       //     int selfHarm = DownHpAttack();
        //    if (selfHarm == 0) {
      //          System.out.print("You dealt damage to an opponent of: " + attack + " point." + "\n" + " There was no self-harm");
      //      } else {
       //         System.out.print("You dealt damage to an opponent of: " + attack + " point." + "\n" + " There is self harm of: " + selfHarm + "to your hp");
       //     }
      //  }
     //   return attack;
  //  }

   // private int DownHpAttack() {
     //   Random random = new Random();
    //    int selfHarm = 0;
    //    int likelihoodHp = random.nextInt(1, 100);
    //    if (likelihoodHp < 25) {
    //        selfHarm = random.nextInt(3, 10);
     //       setHp(getHp() - selfHarm);
    //    }
    //    return selfHarm;
   // }

   // public String toString() {

    //    return "Name pokemon: " + this.getName() + "\n" + "Hp:" + this.getHp() + "\n" + "Attack points: " + this.getAttackPoints();
   // }
   // public String getTYPE(){
   //     return TYPE;
   // }
}
