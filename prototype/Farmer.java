import java.util.ArrayList;
import java.util.Arrays;

public class Farmer{
    private Float Objecticoins;
    private ArrayList<Title> titles;
    private ArrayList<Tools> tools;
    private ArrayList<Seeds> seeds;
    private Float xp;
    private boolean gameOver;
    private int currentDay;

    public Farmer() {
        Objecticoins = 100f;

        titles = new ArrayList<Title>(Arrays.asList(new Title("Farmer", 0, 0, 0, 0, 0,0),
                                                    new Title("Registered Farmer", 5, 1, 1, 0, 0,200),
                                                    new Title("Distinguished Farmer", 10, 2, 2, 1, 0, 300),
                                                    new Title("Legendary Farmer", 15, 4, 3, 2, 1, 400)));

        tools = new ArrayList<Tools>(Arrays.asList(new Tools("Plow", 0,0.5f),
                                                   new Tools("Watering Can", 0,0.5f),
                                                   new Tools("Fertilizer", 10,4),
                                                   new Tools("Watering Can", 0,0.5f),
                                                   new Tools("Shovel", 7, 2.0f)));
        
        seeds = new ArrayList<Seeds>(Arrays.asList(new Seeds("Turnips", 1, "Root Crop", 2, 1, 0, 5, 6, 5)));
        
        xp = 0f;
        gameOver = false;
        currentDay = 1;
    }

    public Float getObjecticoins() {
        return Objecticoins;
    }
    public ArrayList<Title> getTitles() {
        return titles;
    }
    public ArrayList<Tools> getTools() {
        return tools;
    }
    public Float getXp() {
        return xp;
    }
    public boolean isGameOver() {
        return gameOver;
    }
    public int getCurrentDay() {
        return currentDay;
    }
    
    public void setObjecticoins(Float objecticoins) {
        Objecticoins = objecticoins;
    }

    public void setXp(Float xp) {
        this.xp = xp;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public ArrayList<Seeds> getSeeds() {
        return seeds;
    }

}