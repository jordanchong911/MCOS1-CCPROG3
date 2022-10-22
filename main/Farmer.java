import java.util.ArrayList;
import java.util.Arrays;

public class Farmer{
    private Float Objecticoins;
    private Level level;
    private ArrayList<Tools> tools;
    private Float xp;
    private boolean gameOver;
    private int currentDay;

    public Farmer() {
        Objecticoins = 100f;
        level = new DefaultFarmer();
        tools = new ArrayList<>(Arrays.asList(new Plow(),new WateringCan(), new Fertilizer(), new Pickaxe(), new Shovel()));
        xp = 0f;
        gameOver = false;
        currentDay = 1;
    }

    public Float getObjecticoins() {
        return Objecticoins;
    }
    public Level getLevel() {
        return level;
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

    public Tools getPlow(){
        return tools.get(0);
    }

    public Tools getWateringCan(){
        return tools.get(1);
    }

    public Tools Fertilizer(){
        return tools.get(2);
    }
    
    public Tools Pickaxe(){
        return tools.get(3);
    }
    
    public Tools Shovel(){
        return tools.get(4);
    }

    public void setObjecticoins(Float objecticoins) {
        Objecticoins = objecticoins;
    }

    public void setLevel(Level level) {
        this.level = level;
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

}
