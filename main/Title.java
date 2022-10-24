public class Title{
    
    private String TitleName;
    private float xp;
    private int earningsBonus;
    private int seedCostReduction;
    private int waterBonus;
    private int fertilizerBonus;
    private int registrationFee;

    public Title(String TitleName, float xp, int earningsBonus, int seedCostReduction, int waterBonus,int fertilizerBonus, int registrationFee) 
    {
        this.TitleName = TitleName;
        this.xp = xp;
        this.earningsBonus = earningsBonus;
        this.seedCostReduction = seedCostReduction;
        this.waterBonus = waterBonus;
        this.fertilizerBonus = fertilizerBonus;
        this.registrationFee = registrationFee;
    }

    public String getTitleName() {
        return TitleName;
    }
    public float getXp() {
        return xp;
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

}
