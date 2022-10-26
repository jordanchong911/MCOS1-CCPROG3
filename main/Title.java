public class Title{
    
    private String TitleName;
    private float levelRequired;
    private int earningsBonus;
    private int seedCostReduction;
    private int waterBonus;
    private int fertilizerBonus;
    private int registrationFee;

    public Title(String TitleName, float levelRequired, int earningsBonus, int seedCostReduction, int waterBonus,int fertilizerBonus, int registrationFee) 
    {
        this.TitleName = TitleName;
        this.levelRequired = levelRequired;
        this.earningsBonus = earningsBonus;
        this.seedCostReduction = seedCostReduction;
        this.waterBonus = waterBonus;
        this.fertilizerBonus = fertilizerBonus;
        this.registrationFee = registrationFee;
    }

    public String getTitleName() {
        return TitleName;
    }
    public float getlevelRequired() {
        return levelRequired;
    }
    public int getEarningsBonus() {
        return earningsBonus;
    }
    public int getWaterBonus() {
        return waterBonus;
    }
    public int getFertilizerBonus() {
        return fertilizerBonus;
    }
    public int getRegistrationFee() {
        return registrationFee;
    }
    public int getSeedCostReduction() {
        return seedCostReduction;
    }

    @Override
    public String toString() {
        return "Title " + TitleName + "\nLevel Required " + (int)levelRequired + "\nEarning Bonus " + earningsBonus + "\nSeed Cost Reduction "  + seedCostReduction
               + "\nWater Bonus " + waterBonus + "\nFertilizer Bonus " + fertilizerBonus + "\nRegistration Fee " + registrationFee + "\n";
    }

}
