/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

import java.util.Random;

public class Lightsaber extends Weapon{
    
    public enum COLOR {RED, BLUE};
    
    COLOR color;
    
    Lightsaber(){
        super();
        
        COLOR[] Values = COLOR.values();
        this.color=Values[(int)(Math.random()*Values.length)];       
        //this.color = Random.value < .5 ? COLOR.BLUE : COLOR.RED;
        
    }
    
    
    COLOR getColor(){
        return this.color;
    }
    
    @Override
    void setHolder(Humanoid holder){
        this.holder=(WeaponCarrier) holder;
        if(this.holder instanceof Jedi){
            this.color=COLOR.BLUE;
        }else{
            this.color=COLOR.RED;
        }
    }
    
    @Override
    public String toString() {
        String result = "";
            result += ("Lightsaber  " +", ");   
        result += ("Power: "+this.power +", ");   
        result += ("Color: "+this.color+"\n");               
        return result;
    }
}
