public class Seeds {
    private String seedName;
    private int seedInt;
    private String cropType;
    private int havestTime;
    private int waterNeeds;
    private int fertilizerNeeds;
    private float seedCost;
    private float basePrice;
    private int productsProduced;
    private float xpYield;

	public Seeds(String seedName, int seedInt, String cropType, int havestTime, int waterNeeds, int fertilizerNeeds,
                 float seedCost, float basePrice, float xpYield) {
        this.seedName = seedName;
        this.seedInt = seedInt;
        this.cropType = cropType;
        this.havestTime = havestTime;
        this.waterNeeds = waterNeeds;
        this.fertilizerNeeds = fertilizerNeeds;
        this.seedCost = seedCost;
        this.basePrice = basePrice;
        this.xpYield = xpYield;
    }

    public String getSeedName() {
		return seedName;
	}

	public int getSeedInt() {
		return seedInt;
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

	public float getXpYield() {
		return xpYield;
	}

    public int getProductsProduced(){
        return productsProduced;
    }

    public void setProductsProduced(){
        //add math function here
    }
    
}
