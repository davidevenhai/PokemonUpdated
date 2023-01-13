public class Attack {
    private String name;
    private int cost;
    private int minDamage;
    private int maxDamage;

    public int getMinDamage() {
        return minDamage;
    }


    public Attack(String name, int cost, int minDamage, int maxDamage) {
        this.name = name;
        this.cost = cost;
        this.minDamage = minDamage;
        this.maxDamage= maxDamage;
    }
    public boolean mateAttack(String nameAttack){
        return this.name.equals(nameAttack);
    }
    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }
    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public String toString(){
        return getName()+", Damage cost "+getCost()+ ", Min damage is "+getMinDamage()+" ,Max damage is "+getMaxDamage()+".";
    }



}
