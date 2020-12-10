/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

import java.util.Random;

public class Starwars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Jedi obiwan = new Jedi("Obiwan", "Kenobi");
        obiwan.setWeapon(new Lightsaber());
        System.out.println(obiwan);

        Sith vader = new Sith("Vader");
        vader.setWeapon(new Lightsaber());
        System.out.println(vader);
        MedicalDroid docDroid = new MedicalDroid();
        docDroid.setMaster(vader);
        System.out.println(docDroid);
        BattleDroid battleDroid = new BattleDroid();
        battleDroid.setMaster(obiwan);
        System.out.println(battleDroid);
//battle between jedi and sith
        try {
            while (!obiwan.isDefeated() && !vader.isDefeated()) {
                if (new Random().nextBoolean()) { //random turn
                    obiwan.attack(vader);
                    if (!vader.isDefeated()) {
                        vader.attack(obiwan);
                    }
                } else {
                    vader.attack(obiwan);
                    if (!obiwan.isDefeated()) {
                        obiwan.attack(vader);
                    }
                }
                if (!docDroid.isFree()) {
                    docDroid.healMaster();
                }
                if (!battleDroid.isFree() && !vader.isDefeated()) {
                    battleDroid.protectMasterFrom(vader);
                }
                System.out.println(); //print a new line for a new round
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            System.out.print(obiwan.isDefeated() ? vader.getCallSign() : obiwan.getCallSign());
            System.out.println(" won!");
        }
    }
}
