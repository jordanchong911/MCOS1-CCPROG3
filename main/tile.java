public class tile {
    private Boolean isPlowed;
    private Boolean isPlowable;
    private Seed seed;
    private Boolean isOccupied;
    private Boolean Rock;

    public tile() {
        isPlowed = false;
        isPlowable = true;
        seed = null;
        isOccupied = false;
        Rock = false;
    }

    public Boolean getIsPlowed() {
        return isPlowed;
    }
    public void setIsPlowed(Boolean isPlowed) {
        this.isPlowed = isPlowed;
    }
    public Boolean getIsPlowable() {
        return isPlowable;
    }
    public void setIsPlowable(Boolean isPlowable) {
        this.isPlowable = isPlowable;
    }
    public Seed getSeed() {
        return seed;
    }
    public void setSeed(Seed seed) {
        this.seed = seed;
    }
    public Boolean getIsOccupied() {
        return isOccupied;
    }
    public void setIsOccupied(Boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
    public Boolean getRock() {
        return Rock;
    }
    public void setRock(Boolean rock) {
        Rock = rock;
    }
    
}
