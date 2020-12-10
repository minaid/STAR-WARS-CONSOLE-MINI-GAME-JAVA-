/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

import java.util.Random;

public class MedicalDroid extends Droid {
    
    int medicalSkills;
    
    
    MedicalDroid(){
        super();
        Random rand = new Random();        
        this.medicalSkills=rand.nextInt(3) + 1;
        
    }
    
    MedicalDroid(Humanoid master){
        
        super(master);
        Random rand = new Random();        
        this.medicalSkills=rand.nextInt(3) + 1;
    }
    
    int getMedicalSkills(){
        return this.medicalSkills;
    }
    
    @Override
    String getName(){
        return this.name;
    }
    
    
    void healMaster(){
        if (this.master.isDefeated()) {
            System.out.println("Not alive master");
            return;
        }
       
        master.health=master.health + this.medicalSkills;
        System.out.println(this.name + " healed " + this.master.firstName + this.medicalSkills);
        System.out.println(this.master.firstName + " health is: " + this.master.health);
    }
    
    
}
