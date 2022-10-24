public class Seeds {
    private int havestTime;
    private int waterNeeds;
    private int productsProduced;
    private int fertilizerNeeds;
    private int waterNo = 0;
    private int fertilizerNo = 0;
    private int dayPlanted = -1;
    private float seedCost;
    private float basePrice;
    private float xpYield;
    private boolean isWithered = false;
    private String seedName;
    private String cropType;

    public Seeds(String seedName, String cropType, int havestTime, int waterNeeds, int fertilizerNeeds, float seedCost,
            float basePrice, int productsProduced, float xpYield) {
        this.seedName = seedName;
        this.cropType = cropType;
        this.havestTime = havestTime;
        this.waterNeeds = waterNeeds;
        this.fertilizerNeeds = fertilizerNeeds;
        this.seedCost = seedCost;
        this.basePrice = basePrice;
        this.productsProduced = productsProduced;
        this.xpYield = xpYield;
    }

    public String getSeedName() {
        return seedName;
    }

    public String getCropType() {
        return cropType;
    }

    public int getHavestTime() {
        return havestTime;
    }

    public int getWaterNeeds() {
        return waterNeeds;
    }

    public int getFertilizerNeeds() {
        return fertilizerNeeds;
    }

    public float getSeedCost() {
        return seedCost;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public int getProductsProduced() {
        return productsProduced;
    }

    public float getXpYield() {
        return xpYield;
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

    public int getDayPlanted() {
        return dayPlanted;
    }    

    public void setProductsProduced(){
        //add math function here
    }
}
