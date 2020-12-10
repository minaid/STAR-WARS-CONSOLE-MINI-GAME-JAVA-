/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

public class BattleDroid extends Droid implements Combatant {
    
    int condition;
    
    
    BattleDroid(){
        super();
        this.condition=10;
    }
    
    BattleDroid(Humanoid master){
        super(master);
        this.condition=10;
    }
    
    @Override
    public int getCondition(){
        return this.condition;
    }
    
    @Override
   public  void setCondition(int condition){
        this.condition=condition;
    }
    
    
    @Override
  public  String getCallSign(){
        return this.name;
    }
    
    
      @Override
      /**
     *  postcondition:
     * adversary health is reduced (still >=0)
     */
    public void attack(Humanoid adversary)throws Exception{
        //checking preconditions
        if (this.isDefeated()) {
            throw new Exception("Not alive attacker droid");
        }
        if (adversary.isDefeated()) {
            throw new Exception("Not alive defender");
        }
               
            adversary.health -= 1;
        
        if (adversary.isDefeated()) {
            adversary.setHealth(0); //in case it becomes < 0
        }
        System.out.println(this.name + " attacked " + adversary.firstName);
        System.out.println(adversary.firstName + "'s health is : " + adversary.getCondition());
  
    }
      
    @Override
      public boolean isDefeated(){
        return condition==0;
    }
    
      void protectMasterFrom(Humanoid adversary) throws Exception{
          if(this.master.isDefeated()){
              System.out.println("Master not alive");
              return;
          }
          this.attack(adversary);
      }
      
      
    
}
