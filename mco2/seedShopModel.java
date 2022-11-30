import java.util.ArrayList;
import java.util.Arrays;

/** 
 * Represents the model for the seed shop
 * @author Jordan Chong
 * @author Arvin Tan
*/
public class seedShopModel {
    
    private int currentSeed = 0;

    final private ArrayList<Seeds> seed = new ArrayList<Seeds>(
      Arrays.asList(new Seeds("Turnip", "Root crop", 2, 1, 2, 0, 1, 1, 2, 5, 6, 5),
                    new Seeds("Carrot", "Root crop", 3, 1, 2, 0, 1, 1, 2, 10, 9, 7.5f),
                    new Seeds("Potato", "Root crop", 5, 3, 4, 1, 2, 1, 10, 20, 3, 12.5f),
                    new Seeds("Rose", "Flower", 1, 1, 2, 0, 1, 1, 1, 5, 5, 2.5f),
                    new Seeds("Turnips", "Flower", 2, 2, 3, 0, 1, 1, 1, 10, 9, 5),
                    new Seeds("Sunflower", "Flower", 3, 2, 3, 1, 2, 1, 1, 20, 19, 7.5f),
                    new Seeds("Mango", "Fruit tree", 10, 7, 7, 4, 4, 5, 15, 100, 8, 25),
                    new Seeds("Apple", "Fruit tree", 10, 7, 7, 5, 5, 10, 15, 200, 5, 25)));
    
    /**
     * This method increments the current option by 1
     */
    public void nextSeed(){
        if(currentSeed == seed.size()-1)
            currentSeed = 0;
        else
            currentSeed++;
    }

    /**
     * This method decrements the current option by 1
     */
    public void previousSeed(){
        if(currentSeed == 0)
            currentSeed = seed.size()-1;
        else
            currentSeed--;
    }

    /**
     * This method gets the current seed of the model
     * @return the current seed of the model
     */
    public Seeds getCurrentSeeds(){
        return seed.get(currentSeed);
    }

    /**
     * This method gets the array list that conatins seed information
     * @return array list that conatins seed information
     */
    public ArrayList<Seeds> getSeed() {
        return seed;
    }

    
}
