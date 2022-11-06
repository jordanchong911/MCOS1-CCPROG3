import java.util.Random;

public class Seeds {
    private int harvestTime;
    private int waterNeeds;
    private int productsMin;
    private int productsMax;
    private int fertilizerNeeds;
    private int waterNo = 0;
    private int fertilizerNo = 0;
    private int dayPlanted = -1;
    private int waterBonusLimit;
    private int FertilizerBonusLimit;
    private float seedCost;
    private float basePrice;
    private float xpYield;
    private boolean isWithered = false;
    private String seedName;
    private String symbol;
    private String cropType;

    public Seeds(int harvestTime, int waterNeeds, int productsMin, int productsMax,
            int fertilizerNeeds, int waterBonusLimit, int fertilizerBonusLimit, float seedCost, float basePrice,
            float xpYield, String seedName, String cropType, String symbol) {
        this.harvestTime = harvestTime;
        this.waterNeeds = waterNeeds;
        this.productsMin = productsMin;
        this.productsMax = productsMax;
        this.fertilizerNeeds = fertilizerNeeds;
        this.waterBonusLimit = waterBonusLimit;
        this.FertilizerBonusLimit = fertilizerBonusLimit;
        this.seedCost = seedCost;
        this.basePrice = basePrice;
        this.xpYield = xpYield;
        this.seedName = seedName;
        this.cropType = cropType;
        this.symbol = symbol;
    }

    public String getSeedName() {
        return seedName;
    }

    public String getCropType() {
        return cropType;
    }

    public int getHarvestTime() {
        return harvestTime;
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

    public int getProductsMin() {
        return productsMin;
    }

    public int getProductsMax() {
        return productsMax;
    }

    public int getWaterBonusLimit() {
        return waterBonusLimit;
    }

    public int getFertilizerBonusLimit() {
        return FertilizerBonusLimit;
    }
    
    public String getSymbol() {
        return symbol;
    }

    public int computeProductsProduced(){
        //add math function here
        Random r = new Random();
        return r.nextInt(productsMin,productsMax+1);
    }

    public void setDayPlanted(int dayPlanted){
        this.dayPlanted = dayPlanted;
    }

    public void setWaterNo(int waterNo) {
        this.waterNo = waterNo;
    }

    public void setFertilizerNo(int fertilizerNo) {
        this.fertilizerNo = fertilizerNo;
    }

    public void setWithered(boolean isWithered) {
        this.isWithered = isWithered;
    }

    public void setHarvestTime(int harvestTime){
        this.harvestTime = harvestTime;
    }

    public boolean MeetsWaterNeeds(){
        return waterNo >= waterNeeds;
    }

    public boolean MeetsFertilizerNeeds(){
        return fertilizerNo >= fertilizerNeeds;
    }

    public boolean isHarvestable(){
        return isWithered() == false && getHarvestTime() == 0;
    }

    @Override
    public String toString() {
        return "Seed Name " + seedName + "\nCrop Type " + cropType + "\nHarvest Time in days " + harvestTime + "\nWater needs " + waterNeeds
                +"\nDefault Water Bonus Limit " + waterBonusLimit + "\nFertilizer Needs " + fertilizerNeeds + "\nDefault Fertilizer Bonus Limit " + FertilizerBonusLimit
                + "\nProducts Produced " + productsMin + "-" + productsMax + "\nSeed Cost " + seedCost + "\nBase selling price per piece " + basePrice +"\nExperience Yield " + xpYield + "\n";

    }
    
    public void plantInfo(Farmer farmer){

        Title title = farmer.getTitles().get(farmer.getTitleIndex());
        int maxFertilizerLimit = getWaterBonusLimit() + title.getFertilizerBonus();
        int maxWaterLimit = getWaterBonusLimit() + title.getWaterBonus();

        System.out.println("Plant in this plot:\nName " + seedName + "\nTimes Watered " + waterNo + "\nWater Needs " + waterNeeds);
        System.out.println("Times Fertilized " + fertilizerNo + "\nFertilizer Needs " + fertilizerNeeds + "\nWater Bonus Limit " + maxWaterLimit);
        System.out.println("Fertilizer Bonus Limit " + maxFertilizerLimit + "\nWithered " + isWithered + "\nHarvest Time remaining " + harvestTime + "\n" );
    }
    

}
