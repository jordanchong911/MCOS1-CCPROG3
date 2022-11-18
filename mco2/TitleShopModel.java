import java.util.ArrayList;
import java.util.Arrays;

public class TitleShopModel{

    private int currentTitle = 0;

    private ArrayList<Title> titles = new ArrayList<Title>(Arrays.asList(new Title("Farmer", 0, 0, 0, 0, 0, 0),
                new Title("Registered Farmer", 5, 1, 1, 0, 0, 200),
                new Title("Distinguished Farmer", 10, 2, 2, 1, 0, 300),
                new Title("Legendary Farmer", 15, 4, 3, 2, 1, 400)));

    public void nextTitle(){
        if(currentTitle == titles.size()-1)
            currentTitle = 0;
        else
            currentTitle++;
    }

    public void previousTitle(){
        if(currentTitle == 0)
            currentTitle = titles.size()-1;
        else
            currentTitle--;
    }

    public Title getCurrentTitles(){
        return titles.get(currentTitle);
    }

    public ArrayList<Title> getTitles() {
        return titles;
    }
    
}