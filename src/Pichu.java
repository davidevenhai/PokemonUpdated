import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Pichu extends Pokemon {
    private int electric;
    private int countTurn;


    public Pichu() {
        this.setName("Pichu");
        this.setLevel(1);
        this.setMaxHp(40);
        this.setHp(40);
        this.setMaxAttackPoints(30);
        this.setAttackPoints(22.5);
        Attack quickAttack = new Attack("Quick Attack", 5, 10, 10);
        this.addAttacks(quickAttack);
        this.type = "ELECTRIC";
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
            this.type = "ELECTRIC";
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
            this.type = "ELECTRIC";
            evolved = true;
        }
        if (evolved) {
            System.out.println("Your pokemon evolved");
        } else System.out.println("Your pokemon cant evolve");
        return evolved;

    }


//    public boolean specialAction(Pokemon pokemon){
//        boolean check=false;
//        if(this.countSpecialAction==0) {
//            this.setHp(this.getMaxHp());
//            this.setAttackPoints(this.getMaxAttackPoints());
//            System.out.print("You have filled your pokemon with all the hp and attack points");
//            check=true;
//        }else {
//            System.out.print("You have used this option already");
//            check=false;
//        }
//        return check;
//    }

}

