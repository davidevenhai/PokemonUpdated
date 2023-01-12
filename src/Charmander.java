import java.util.Random;
import java.util.Scanner;

public class Charmander extends Pokemon{
    private String [] attacks;


    public Charmander(){
        this.setName("Charmander");
        this.setLevel(1);
        this.setMaxHp(80);
        this.setHp(80);
        this.setMaxAttackPoints(40);
        this.setAttackPoints(28);
        Attack scratch=new Attack("Scratch",15,25,30)
        this.addAttacks(scratch);
    }
    public void levelUp(){
            if(this.getLevel()==1){
                this.setName("Charmeleon");
                this.setLevel(2);
                this.setMaxHp(90);
                this.setHp((this.getHp()-20));
                this.setMaxAttackPoints(60);
                this.setAttackPoints((getAttackPoints()-25));
                Attack flame=new Attack("Flame Tail",40,30,50);
                this.addAttacks(flame);
            }else if(this.getLevel()==2){
                this.setName("Charizard");
                this.setLevel(3);
                this.setMaxHp(130);
                this.setHp((this.getHp()-30));
                this.setMaxAttackPoints(80);
                this.setAttackPoints((getAttackPoints()-40));
                Attack fiery=new Attack("Fiery Blast",40,30,50);
                this.addAttacks(fiery);

            }
    }
    public int attack(){
        Random random=new Random();
        Scanner scanner=new Scanner(System.in);
        System.out.print("Your attack list:");
      for (int i=0;i<this.getAttacks().length;i++){
          System.out.print(this.getAttacks()[i]+",");
      }
      boolean checkImput=false;
      Attack attackchoies = null;
      int attack;
      do {
          System.out.print("Insert your attack :");
          String attackUser = scanner.nextLine();
          for (int i=0;i<this.getAttacks().length;i++){
              if (this.getAttacks()[i].mateAttack(attackUser)){
                  checkImput=true;
                  attackchoies=this.getAttacks()[i];
                  break;
              }
          }
      }while (!checkImput);
      if((this.getAttackPoints()-attackchoies.getCost())<0){
          System.out.print("You don't have enough points to attack");
          attack=0;
      }else{
          this.setAttackPoints((this.getAttackPoints()-attackchoies.getCost()));
          attack=random.nextInt(attackchoies.getMinDamage(),attackchoies.getMaxDamage());
          int selfHarm=DownHpAttack();
          if(selfHarm==0){
              System.out.print("You dealt damage to an opponent of: "+ attack+ " point."+ "\n"+ " There was no self-harm");
          }else {
              System.out.print("You dealt damage to an opponent of: "+ attack+ " point."+ "\n"+ " There is self harm of: "+ selfHarm+"to your hp" );
          }
      }
      return attack;
    }
    private int DownHpAttack(){
        Random random=new Random();
        int selfHarm=0;
        int likelihoodHp=random.nextInt(1,100);
        if(likelihoodHp<25){
            selfHarm=random.nextInt(3,10);
            setHp(getHp()-selfHarm);
        }
        return selfHarm;
    }
    public String toString() {

    return "Name pokemon: "+ this.getName()+ "\n"+ "Hp:"+ this.getHp()+ "\n"+ " Attack points: "+ this.getAttackPoints();
    }
}
