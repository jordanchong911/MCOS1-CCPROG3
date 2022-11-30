import java.util.ArrayList;
import java.util.Arrays;

/** 
 * Represents the model for the title shop
 * @author Jordan Chong
 * @author Arvin Tan
*/
public class TitleShopModel{

    private int currentTitle = 0;

    private ArrayList<Title> titles = new ArrayList<Title>(Arrays.asList(new Title("Farmer", 0, 0, 0, 0, 0, 0),
                new Title("Registered Farmer", 5, 1, 1, 0, 0, 200),
                new Title("Distinguished Farmer", 10, 2, 2, 1, 0, 300),
                new Title("Legendary Farmer", 15, 4, 3, 2, 1, 400)));

    /**
     * This method increments the current option by 1
     */
    public void nextTitle(){
        if(currentTitle == titles.size()-1)
            currentTitle = 0;
        else
            currentTitle++;
    }

    /**
     * This method decrements the current option by 1
     */
    public void previousTitle(){
        if(currentTitle == 0)
            currentTitle = titles.size()-1;
        else
            currentTitle--;
    }

    /**
     * This method gets the current title of the model
     * @return the current title of the model
     */
    public Title getCurrentTitles(){
        return titles.get(currentTitle);
    }

    /**
     * This method gets the array list that conatins title information
     * @return array list that conatins title information
     */
    public ArrayList<Title> getTitles() {
        return titles;
    }
    
}