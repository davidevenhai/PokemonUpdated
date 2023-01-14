public class Electabuzz extends Pichu {
    private String[] attacks;
    private final String TYPE = "ELECTRIC";


    public Electabuzz() {
        this.setName("Electabuzz");
        this.setLevel(1);
        this.setMaxHp(30);
        this.setHp(30);
        this.setMaxAttackPoints(100);
        this.setAttackPoints(75);
        Attack thunder = new Attack("Thunder", 60, 40, 50);
        this.addAttacks(thunder);
    }

    public boolean levelUp() {
        boolean evolved = false;
        if (this.getLevel() == 1 && this.getAttackPoints() > 25 && this.getHp() > 20) {
            this.setName("Electivire");
            this.setLevel(2);
            this.setMaxHp(35);
            this.setHp((this.getHp() - 20));
            this.setMaxAttackPoints(120);
            this.setAttackPoints((getAttackPoints() - 25));
            Attack thunderPunch = new Attack("Thunder Punch", 80, 50, 120);
            this.addAttacks(thunderPunch);
            evolved = true;
        }

        if (evolved) {
            System.out.println("Your pokemon evolved");
        } else {
            System.out.println("Your pokemon cant evolve");
        }

        return evolved;

    }

   // public int attack(int turnCounter) {
     //   Random random = new Random();
     //   Scanner scanner = new Scanner(System.in);
     //   System.out.println("Your attack list:");
     //   for (int i = 0; i < this.getAttacks().length; i++) {
       //     System.out.println(this.getAttacks()[i]);
     //   }
    //    boolean checkInput = false;
     //   Attack attackChoice = null;
     //   int attack;
     //   do {
      //      System.out.println("Insert your attack :");
       //     String attackUser = scanner.nextLine();
         //   for (int i = 0; i < this.getAttacks().length; i++) {
       //         if (this.getAttacks()[i].mateAttack(attackUser)) {
        //            checkInput = true;
           //         attackChoice = this.getAttacks()[i];
          //          break;
          //      }
         //   }
     //   } while (!checkInput);
      //  if ((this.getAttackPoints() - attackChoice.getCost()) < 0) {
      //      System.out.print("You don't have enough points to attack");
       //     attack = 0;
      //  } else {
      //      this.setAttackPoints((this.getAttackPoints() - attackChoice.getCost()));
       //     attack = random.nextInt(attackChoice.getMinDamage(), attackChoice.getMaxDamage());
         //   if (Objects.equals(this.getType(), "ELECTRIC")) {
         //       int tempBonus = turnCounter*5;
          //      attack = attack + (attack * (tempBonus / 100));
        //    }
        //    System.out.print("You dealt damage to an opponent of: " + attack + " point.");

      //  }
      //  return attack;

  //  }


   // public String toString() {

    //    return "Name pokemon: " + this.getName() + "\n" + "Hp:" + this.getHp() + "\n" + "Attack points: " + this.getAttackPoints();
  //  }

   // public String getType() {
    //    return TYPE;
  //  }
}
