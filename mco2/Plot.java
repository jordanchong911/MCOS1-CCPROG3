public class Plot {
    private boolean isPlowed = false;
    private boolean hasRock = false;
    private Seeds seed = null;

    public boolean isPlowed() {
        return isPlowed;
    }

    public boolean isHasRock() {
        return hasRock;
    }

    public Seeds getSeed() {
        return seed;
    }

    public void setPlowed(boolean isPlowed) {
        this.isPlowed = isPlowed;
    }

    public void setHasRock(boolean hasRock) {
        this.hasRock = hasRock;
    }

    public void setSeed(Seeds seed) {
        this.seed = seed;
    }
    
    public void resetAfterHarvest(){
        setSeed(null);
        setPlowed(false);
    }
}
