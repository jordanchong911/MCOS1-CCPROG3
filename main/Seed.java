public class Seed {
    protected int HarvestTime;
    protected String SeedName;
    protected Boolean isHarvestable;
    protected Boolean isWithered;
    protected int WaterNeeds;
    protected int WaterBonusLimit;
    protected int FertilizerNeeds;
    protected int fertilizerBonusLimit;
    protected int ProducedProduct;
    protected float Cost;
    protected float SellingPrice;
    protected float ExperienceYield;
    protected String CropType;
    protected int dayPlanted;

    public int getHarvestTime() {
        return HarvestTime;
    }
    public String getSeedName() {
        return SeedName;
    }
    public Boolean getIsHarvestable() {
        return isHarvestable;
    }
    public Boolean getIsWithered() {
        return isWithered;
    }
    public int getWaterNeeds() {
        return WaterNeeds;
    }
    public int getWaterBonusLimit() {
        return WaterBonusLimit;
    }
    public int getFertilizerNeeds() {
        return FertilizerNeeds;
    }
    public int getFertilizerBonusLimit() {
        return fertilizerBonusLimit;
    }
    public int getProducedProduct() {
        return ProducedProduct;
    }
    public float getCost() {
        return Cost;
    }
    public float getSellingPrice() {
        return SellingPrice;
    }
    public float getExperienceYield() {
        return ExperienceYield;
    }
    public String getCropType() {
        return CropType;
    }
    public int getDayPlanted() {
        return dayPlanted;
    }
    public void setIsHarvestable(Boolean isHarvestable) {
        this.isHarvestable = isHarvestable;
    }
    public void setIsWithered(Boolean isWithered) {
        this.isWithered = isWithered;
    }
    public void setWaterBonusLimit(int waterBonusLimit) {
        WaterBonusLimit = waterBonusLimit;
    }
    public void setFertilizerBonusLimit(int fertilizerBonusLimit) {
        this.fertilizerBonusLimit = fertilizerBonusLimit;
    }
    public void setProducedProduct(int producedProduct) {
        ProducedProduct = producedProduct;
    }
    public void setDayPlanted(int dayPlanted) {
        this.dayPlanted = dayPlanted;
    }
    
}
