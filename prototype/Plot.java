public class Plot {
    private int x_Coor;
    private int y_Coor;
    private boolean isPlowed = false;
    private boolean hasSeed = false;
    private int seedInt;
    private int dayPlanted = -1;
    private boolean hasRock;
    private boolean isOccupied;
    private boolean isWithered;
    private int waterNo;
    private int fertilizerNo;

    public Plot(int x_Coor, int y_Coor, int seedInt, boolean hasRock,
                boolean isOccupied, boolean isWithered, int waterNo, int fertilizerNo) {
        this.x_Coor = x_Coor;
        this.y_Coor = y_Coor;
        this.seedInt = seedInt;
        this.hasRock = hasRock;
        this.isOccupied = isOccupied;
        this.isWithered = isWithered;
        this.waterNo = waterNo;
        this.fertilizerNo = fertilizerNo;
    }

    public int getX_Coor() {
        return x_Coor;
    }

    public int getY_Coor() {
        return y_Coor;
    }

    public boolean isPlowed() {
        return isPlowed;
    }

    public boolean isHasSeed() {
        return hasSeed;
    }

    public int getSeedInt() {
        return seedInt;
    }

    public int getDayPlanted() {
        return dayPlanted;
    }

    public boolean isHasRock() {
        return hasRock;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isWithered() {
        return isWithered;
    }

    public int getWaterNo() {
        return waterNo;
    }

    public int getFertilizerNo() {
        return fertilizerNo;
    }
        
}
