/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

public class Sith extends Humanoid implements Combatant {

    // String firstName="Darth";
    Sith(String lastName) {
        super("Darth", lastName);
    }

    @Override
    /**
     * preconditions: both are alive! Adversary is not Sith postcondition:
     * adversary health is reduced (still >=0)
     */
    public void attack(Humanoid adversary) throws Exception {
        //checking preconditions
        if (this.isDefeated()) {
            throw new Exception("Not alive attacker");
        }
        if (adversary.isDefeated()) {
            throw new Exception("Not alive defender");
        }
        if (adversary instanceof Sith) {
            throw new Exception("Not an enemy");
        }

        if (this.hasWeapon()) {
            adversary.health -= this.getWeapon().getPower();
        } else {
            adversary.health -= 1;
        }
        if (adversary.isDefeated()) {
            adversary.setHealth(0); //in case it becomes < 0
        }
        System.out.println(this.firstName + " attacked " + adversary.firstName);
        System.out.println(adversary.firstName + "'s health is : " + adversary.getCondition());

    }

    @Override
    public String toString() {
        String result = "";
        result += ("Sith: " + "\n");
        result += ("firstName: " + this.firstName + "\n");
        result += ("lastName: " + this.lastName + "\n");
        if (this.getWeapon() != null) {
            result += ("Weapon: " + this.getWeapon().toString() + "\n");
        } else {
            result += ("No weapon\n");
        }
        return result;
    }
}
