/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

import java.util.Random;

public abstract class Droid {
    
    //char[] name=new char[4];
    Humanoid master;
    String name;
    
     Droid(){
        
     Random r = new Random();
    // for(int i=0; i<4;i++){
    //  this.name[i] = (char) (r.nextInt(26) + 'A');
    // }
     this.name=((char) (r.nextInt(26) + 'A'))+String.valueOf(((char) (r.nextInt(26) + 'A'))+((char) (r.nextInt(26) + 'A'))+((char) (r.nextInt(26) + 'A')));
    }
    
    Droid(Humanoid master){
        Random r = new Random();
     //for(int i=0; i<4;i++){
     // this.name[i] = (char) (r.nextInt(26) + 'A');
    // }
        this.name=((char) (r.nextInt(26) + 'A'))+String.valueOf(((char) (r.nextInt(26) + 'A'))+((char) (r.nextInt(26) + 'A'))+((char) (r.nextInt(26) + 'A')));
    
     this.master=master;
        
    }

   void setMaster(Humanoid master){
       this.master= master;
   }

    Humanoid getMaster(){
        return this.master;
    }
    
    String getName(){
        return this.name;
    }
    
    boolean isFree(){
        return ((this.master==null)||(this.master.isDefeated()));
    }
    
    @Override
    public String toString() {
        String result = "";
       result += ("Droid name: "+this.name+", ");   
        result += ("Master: "+this.master.firstName +"\n");               
        return result;
    }
}
