import java.util.Random;
import java.util.Scanner;

public class Charmander extends Pokemon {

    public Charmander() {
        this.setName("Charmander");
        this.setLevel(1);
        this.setMaxHp(80);
        this.setHp(80);
        this.setMaxAttackPoints(40);
        this.setAttackPoints(30);
        Attack scratch = new Attack("Scratch", 15, 25, 30);
        this.addAttacks(scratch);
        this.type = "FIRE";

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
            this.type = "FIRE";

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
            this.type = "FIRE";

            evolved = true;

        }
        if (evolved) {
            System.out.println("Your pokemon evolved");
        }else System.out.println("Your pokemon cant evolve");
        return evolved;
    }
}
