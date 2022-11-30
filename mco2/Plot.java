/**
 * Class "plot" where it defines the plot whether it has a rock, unplowed, or has been planted a seed.
 * @author Chong, Jordan Chester S.
 * @author Tan, Arvin Teri L.
 */

public class Plot {
    
    private boolean isPlowed = false;
    private boolean hasRock = false;
    private Seeds seed = null;

    /**
     * Returns a boolean value of wether a plot is plowed or not
     * @return boolean
     */
    public boolean isPlowed() {
        return isPlowed;
    }

    /**
     * Returns a boolean value if a plot has a rock or not
     * @return boolean
     */
    public boolean isHasRock() {
        return hasRock;
    }

    /**
     * Returns a seed class object
     * @return Seeds
     */
    public Seeds getSeed() {
        return seed;
    }

    /**
     * @param isPlowed
     * Sets the plot if a plot is plowed or not
     */
    public void setPlowed(boolean isPlowed) {
        this.isPlowed = isPlowed;
    }

    /**
     * @param hasRock
     * Sets the plot if a plot has a rock or not
     */
    public void setHasRock(boolean hasRock) {
        this.hasRock = hasRock;
    }

    /**
     * @param seed
     * Sets the plot if the plot has a seed or not (and what kind of seed is it)
     */
    public void setSeed(Seeds seed) {
        this.seed = seed;
    }
    
    /**
     * Resets the plot to unplowed if the player chooses to harvest it or not.
     * @return void
     */
    public void resetAfterHarvest(){
        setSeed(null);
        setPlowed(false);
    }
}
