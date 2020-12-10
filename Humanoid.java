/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Humanoid extends WeaponCarrier {

    String firstName;
    String lastName;
    int health;

    /**
     * precondition: firstName not null
     *
     * @param firstName the name of the Humanoid (not null)
     */
    /**
     * precondition: lastName not null
     *
     * @param lastName the name of the Humanoid (not null)
     */
    Humanoid(String firstName, String lastName, int health) {
        if (firstName == null) {
            try {
                throw new Exception("Error->First Name null");
            } catch (Exception ex) {
                Logger.getLogger(Humanoid.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        if (lastName == null) {
            try {
                throw new Exception("Error->Last Name null");
            } catch (Exception ex) {
                Logger.getLogger(Humanoid.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        this.firstName = firstName;
        this.lastName = lastName;
        this.health = health;
    }
    
    Humanoid(String firstName, String lastName) {
        if (firstName == null) {
            try {
                throw new Exception("Error->First Name null");
            } catch (Exception ex) {
                Logger.getLogger(Humanoid.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        if (lastName == null) {
            try {
                throw new Exception("Error->Last Name null");
            } catch (Exception ex) {
                Logger.getLogger(Humanoid.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        this.firstName = firstName;
        this.lastName = lastName;
        this.health = 10;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public void setCondition(int cond) {
        this.health = cond;
    }
    
    public int getCondition() {
        return this.health;
    }
    
    public boolean isDefeated() {
        return health <= 0;
    }
    
    public String getCallSign() {
        return ((this.firstName) + (" ") + (this.lastName));
        
    }
    
    @Override
    public abstract String toString();
}
