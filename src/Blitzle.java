public class Blitzle extends Pokemon {
    public Blitzle(){
        this.setName("Blitzle");
        this.setLevel(1);
        this.setMaxHp(90);
        this.setHp(90);
        this.setMaxAttackPoints(35);
        this.setAttackPoints(26.25);
        Attack flop = new Attack("Flop", 20, 20, 25);
        this.addAttacks(flop);
        this.type = "ELECTRIC";
    }

    public boolean levelUp() {
        boolean evolved = false;
        if (this.getLevel() == 1 && this.getAttackPoints() > 25 && this.getHp() > 20) {
            this.setName("Zebstrika");
            this.setLevel(2);
            this.setMaxHp(100);
            this.setHp((this.getHp() - 20));
            this.setMaxAttackPoints(50);
            this.setAttackPoints((getAttackPoints() - 25));
            Attack electroBall = new Attack("Zap Kick", 30, 30, 35);
            this.addAttacks(electroBall);
            this.type = "ELECTRIC";
            evolved = true;
        }
        if (evolved) {
            System.out.println("Your pokemon evolved");
        } else System.out.println("Your pokemon cant evolve");
        return evolved;
    }
}
