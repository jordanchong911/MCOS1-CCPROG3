import java.lang.Math;
public class Turnip extends Seed{

    public Turnip(int dayPlanted){
        HarvestTime = 2;
        SeedName = "Turnip";
        isHarvestable = false;
        isWithered = false;
        WaterNeeds = 1;
        WaterBonusLimit = 2;
        FertilizerNeeds = 0;
        fertilizerBonusLimit = 1;
        //formula for random int: (int) (Math.random()*(maximum - minimum))) + minimum
        // the produced product is calculated when the plant is planted
        ProducedProduct = (int) (Math.random()*(2 - 1)) +1;
        Cost = 5;
        SellingPrice = 6;
        ExperienceYield = 5;
        CropType = "Root crop";
        this.dayPlanted = dayPlanted;
    }

    
}
