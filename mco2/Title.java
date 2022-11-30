/**
 * Class "title" where it defines the different stages of a farmer.
 * @author Chong, Jordan Chester S.
 * @author Tan, Arvin Teri L.
 */
public class Title{
    
    private String TitleName;
    private float levelRequired;
    private int earningsBonus;
    private int seedCostReduction;
    private int waterBonus;
    private int fertilizerBonus;
    private int registrationFee;

    /**
     * @param TitleName
     * @param levelRequired
     * @param earningsBonus
     * @param seedCostReduction
     * @param waterBonus
     * @param fertilizerBonus
     * @param registrationFee
     * 
     * Sets the title name, leve; requirements, earning bonus, seed cost reduction, water bonus, fertilizer bonus, and registration fee of a certain title.
     */
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

    /**
     * Returns the title name of a title
     * @return String
     */
    public String getTitleName() {
        return TitleName;
    }

    /**
     * Returns the level requirements of a title
     * @return String
     */
    public float getlevelRequired() {
        return levelRequired;
    }

    /**
     * Returns the earning bonus of a title
     * @return String
     */
    public int getEarningsBonus() {
        return earningsBonus;
    }

    /**
     * Returns the water bonus of a title
     * @return String
     */
    public int getWaterBonus() {
        return waterBonus;
    }

    /**
     * Returns the fertilizer bonus of a title
     * @return String
     */
    public int getFertilizerBonus() {
        return fertilizerBonus;
    }

    /**
     * Returns the registration fee of a title
     * @return String
     */
    public int getRegistrationFee() {
        return registrationFee;
    }
    
    /**
     * Returns the seed cost discount of a title
     * @return String
     */
    public int getSeedCostReduction() {
        return seedCostReduction;
    }

}
