/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

public abstract class WeaponCarrier  {
    
    Weapon weapon;
    
    Weapon getWeapon(){
        return this.weapon;
    }
    
    public Boolean hasWeapon(){
        return this.weapon!=null;
    }
    
    void setWeapon(Weapon weapon){
        this.weapon=weapon;
        
    }
    
    
    
}
