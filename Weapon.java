/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

import java.util.Random;

public abstract class Weapon {
    
    int power;
    WeaponCarrier holder;
    
    Weapon(){
        Random rand = new Random();        
        this.power=rand.nextInt(5) + 1;
    }
    
    
    int getPower(){
        return this.power;
    }
    
    
    
    void setHolder(Humanoid holder){
        this.holder=(WeaponCarrier) holder;
    }
    
    WeaponCarrier getHolder(){
        return this.holder;
    }
    
    
    @Override
    public abstract String toString();
    
    
  //  @Override
  //  public String toString() {
  //      String result = "";
   //     result += ("power: "+this.power+", ");   
 //       result += ("holder: "+this.holder+"\n");               
  //      return result;
   // }
    
}
