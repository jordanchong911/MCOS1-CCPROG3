import java.util.Random;

/**
 * Class "seed" where ti defines the different kinds of seeds and its description
 * @author Chong, Jordan Chester S.
 * @author Tan, Arvin Teri L.
 */
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
    private String cropType;

    /**
     * @param seedName
     * @param cropType
     * @param harvestTime
     * @param waterNeeds
     * @param waterBonusLimit
     * @param fertilizerNeeds
     * @param fertilizerBonusLimit
     * @param productsMin
     * @param productsMax
     * @param seedCost
     * @param basePrice
     * @param xpYield
     * 
     * Sets the seed according to their seed name, crop type, harvest time, water needs, water bonus limit, fertilizer needs, fertilizer bonus limit, 
     * minimun amount of products, maximum amount of products, seed cost, base price, and xp yield.
     */
    public Seeds(String seedName,String cropType, int harvestTime, int waterNeeds, int waterBonusLimit,int fertilizerNeeds, int fertilizerBonusLimit, int productsMin, int productsMax, float seedCost, float basePrice,float xpYield){
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
    }

    /**
     * Returns the seed name of a seed.
     * @return String
     */
    public String getSeedName() {
        return seedName;
    }

    /**
     * Returns the crop type of a seed
     * @return String
     */
    public String getCropType() {
        return cropType;
    }

    /**
     * Returns the harvest time of a seed
     * @return int
     */
    public int getHarvestTime() {
        return harvestTime;
    }

    /**
     * Returns the amount of water needed of a seed
     * @return int
     */
    public int getWaterNeeds() {
        return waterNeeds;
    }

    /**
     * Returns the amount of fertilizer needed of a seed
     * @return int
     */
    public int getFertilizerNeeds() {
        return fertilizerNeeds;
    }

    /**
     * Returns the seed cost of a seed
     * @return float
     */
    public float getSeedCost() {
        return seedCost;
    }

    /**
     * Returns the base price of a product produced by the seed
     * @return float
     */
    public float getBasePrice() {
        return basePrice;
    }

    /**
     * Returns the xp yield of a product produced by the seed
     * @return float
     */
    public float getXpYield() {
        return xpYield;
    }

    /**
     * Returns the boolean value if the plant withered or not
     * @return boolean
     */
    public boolean isWithered() {
        return isWithered;
    }

    /**
     * Returns the amount of water received to the plant
     * @return int
     */
    public int getWaterNo() {
        return waterNo;
    }

    /**
     * Returns the amount of fertilizer received to the plant
     * @return int
     */
    public int getFertilizerNo() {
        return fertilizerNo;
    }

    /**
     * Returns the day when the seed has been planted
     * @return int
     */
    public int getDayPlanted() {
        return dayPlanted;
    }    

    /**
     * Returns the minimum yield of a product produced by the seed
     * @return int
     */
    public int getProductsMin() {
        return productsMin;
    }

    /**
     * Returns the maximum yield of a product produced by the seed
     * @return int
     */
    public int getProductsMax() {
        return productsMax;
    }

    /**
     * Returns the bonus water that a plant can receive
     * @return int
     */
    public int getWaterBonusLimit() {
        return waterBonusLimit;
    }

    /**
     * Returns the bonus fertilizer that a plant can receive
     * @return int
     */
    public int getFertilizerBonusLimit() {
        return FertilizerBonusLimit;
    }
    
    /**
     * Returns a random number that correpsonds to the amount of products produced by the seed
     * @return int
     */
    public int computeProductsProduced(){
        //add math function here
        Random r = new Random();
        return r.nextInt(productsMin,productsMax+1);
    }

    /**
     * Sets the number of days planted
     * @return void
     */
    public void setDayPlanted(int dayPlanted){
        this.dayPlanted = dayPlanted;
    }

    /**
     * Sets the number of water that has been received by the plant
     * @return void
     */
    public void setWaterNo(int waterNo) {
        this.waterNo = waterNo;
    }

    /**
     * Sets the number of fertilizer that has been received by the plant
     * @return void
     */
    public void setFertilizerNo(int fertilizerNo) {
        this.fertilizerNo = fertilizerNo;
    }

    /**
     * Sets a boolean value if a plant id withered or not
     * @return void
     */
    public void setWithered(boolean isWithered) {
        this.isWithered = isWithered;
    }

    /**
     * Sets a day where the seeds can be harvested
     * @return void
     */
    public void setHarvestTime(int harvestTime){
        this.harvestTime = harvestTime;
    }

    /**
     * Sets the number of water that the plant needs to receive
     * @return void
     */
    public boolean MeetsWaterNeeds(){
        return waterNo >= waterNeeds;
    }

    /**
     * Sets the number of fertilizer that the plant needs to receive
     * @return void
     */
    public boolean MeetsFertilizerNeeds(){
        return fertilizerNo >= fertilizerNeeds;
    }

    /**
     * Sets a boolean value if the plant is harvestable or not.
     * @return void
     */
    public boolean isHarvestable(){
        return isWithered() == false && getHarvestTime() == 0;
    }

}
