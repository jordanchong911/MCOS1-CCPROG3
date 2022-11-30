/**
 * Class "tools" where it defines the different tools available for the player.
 * @author Chong, Jordan Chester S.
 * @author Tan, Arvin Teri L.
 */

public class Tools {
    
    private String name;
    private float cost;
    private float xpGain;
    private String function;

    /**
     * @param name
     * @param cost
     * @param xpGain
     * @param function
     * 
     * Sets the name,. cost, xp gain, and function of a tool.
     */
    public Tools(String name, float cost, float xpGain, String function) {
        this.name = name;
        this.cost = cost;
        this.xpGain = xpGain;
        this.function = function;
    }

    /**
     * Returns the name of a tool
     * @return String
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the cost of a tool
     * @return float
     */
    public float getCost() {
        return cost;
    }

    /**
     * Returns the xp gain of a tool
     * @return float
     */
    public float getXpGain() {
        return xpGain;
    }

    /**
     * Returns the function of a tool
     * @return String
     */
    public String getfunction() {
        return function;
    }

}

