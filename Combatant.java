/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

public interface Combatant {

    public void attack(Humanoid adversary) throws Exception;

    public boolean isDefeated() throws Exception;

    public int getCondition() throws Exception;

    public void setCondition(int condition) throws Exception;

    public String getCallSign() throws Exception;
}
