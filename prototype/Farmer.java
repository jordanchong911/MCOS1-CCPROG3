import java.util.ArrayList;
import java.util.Arrays;

public class Farmer{
    private ArrayList<Title> titles;
    private ArrayList<Tools> tools;
    private boolean gameOver;
    private int currentDay;
    private int titleIndex = 0;
    private int rows = 1;
    private int columns = 1;
    private Float Objecticoins;
    private Float xp;
    private Plot[][] land; 

    public Farmer() {
        Objecticoins = 100f;

        titles = new ArrayList<Title>(Arrays.asList(new Title("Farmer", 0, 0, 0, 0, 0,0),
                                                    new Title("Registered Farmer", 5, 1, 1, 0, 0,200),
                                                    new Title("Distinguished Farmer", 10, 2, 2, 1, 0, 300),
                                                    new Title("Legendary Farmer", 15, 4, 3, 2, 1, 400)));

        tools = new ArrayList<Tools>(Arrays.asList(new Tools("Plow", 0,0.5f),
                                                   new Tools("Watering Can", 0,0.5f),
                                                   new Tools("Fertilizer", 10,4),
                                                   new Tools("Pickaxe", 50,15),
                                                   new Tools("Shovel", 7, 2.0f)));
        
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++)
                land[i][j] = new Plot();

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
    
    public int getTitleIndex() {
        return titleIndex;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Plot[][] getLand() {
        return land;
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

    public void setTitleIndex(int titleIndex) {
        this.titleIndex = titleIndex;
    }
    
}