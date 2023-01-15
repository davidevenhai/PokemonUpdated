public class Electabuzz extends Pokemon {

    public Electabuzz() {
        this.setName("Electabuzz");
        this.setLevel(1);
        this.setMaxHp(30);
        this.setHp(30);
        this.setMaxAttackPoints(100);
        this.setAttackPoints(75);
        Attack thunder = new Attack("Thunder", 60, 40, 50);
        this.addAttacks(thunder);
        this.type = "ELECTRIC";    }

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
            this.type = "ELECTRIC";
            evolved = true;
        }
        if (evolved) {
            System.out.println("Your pokemon evolved");
        } else {
            System.out.println("Your pokemon cant evolve");
        }
        return evolved;
    }
}
