/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

import java.util.Random;

public class Jedi extends Humanoid implements Combatant {

    public enum RANK {

        YOUNGLING, PADAWAN, KNIGHT, MASTER, GRAND_MASTER
    };
    RANK rank;
    int force_level;

    Jedi(String firstName, String lastName) {
        super(firstName, lastName);
        Random rand = new Random();
        this.force_level = rand.nextInt(100) + 1;
        if ((this.force_level >= 1) && (this.force_level < 10)) {
            this.rank = RANK.YOUNGLING;
        } else if ((this.force_level >= 10) && (this.force_level < 30)) {
            this.rank = RANK.PADAWAN;
        } else if ((this.force_level >= 30) && (this.force_level < 70)) {
            this.rank = RANK.KNIGHT;
        } else if ((this.force_level >= 70) && (this.force_level < 90)) {
            this.rank = RANK.MASTER;
        } else {
            this.rank = RANK.GRAND_MASTER;
        }
    }

    public RANK getRank() {
        return this.rank;
    }

    public int getForceLevel() {
        return this.force_level;
    }

    
    @Override
    /**
     * preconditions: both are alive! Adversary is not Jedi postcondition:
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
        if (adversary instanceof Jedi) {
            throw new Exception("Not an enemy");
        }

        if (this.hasWeapon()) {
            if (this.rank == RANK.YOUNGLING) {
                adversary.health -= this.getWeapon().getPower();
            } else if (this.rank == RANK.PADAWAN) {
                adversary.health -= this.getWeapon().getPower() + 1;
            } else if (this.rank == RANK.KNIGHT) {
                adversary.health -= this.getWeapon().getPower() + 2;
            } else if (this.rank == RANK.MASTER) {
                adversary.health -= this.getWeapon().getPower() + 3;
            } else {
                adversary.health -= this.getWeapon().getPower() + 4;
            }
        } else {
            if (this.rank == RANK.YOUNGLING) {
                adversary.health -= 1;
            } else if (this.rank == RANK.PADAWAN) {
                adversary.health -= 2;
            } else if (this.rank == RANK.KNIGHT) {
                adversary.health -= 3;
            } else if (this.rank == RANK.MASTER) {
                adversary.health -= 4;
            } else {
                adversary.health -= 5;
            }
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
        result += ("Jedi: " + "\n");
        result += ("firstName: " + this.firstName + "\n");
        result += ("lastName: " + this.lastName + "\n");
        result += ("Rank: " + this.rank + "\n");
        if (this.getWeapon() != null) {
            result += ("Weapon: " + this.getWeapon().toString() + "\n");
        } else {
            result += ("No weapon\n");
        }
        return result;
    }
}
