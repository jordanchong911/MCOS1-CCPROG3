import java.util.ArrayList;
import java.util.Arrays;

public class Farmer{
    private ArrayList<Title> titles;
    private ArrayList<Tools> tools;
    private ArrayList<Seeds> seed;
    private boolean gameOver;
    private int currentDay;
    private int titleIndex = 0;
    private int rows = 3;
    private int columns = 3;
    private Float Objectcoins= 100f;
    private Float xp;
    private Plot[][] land = new Plot[rows][columns] ; 

    public Farmer() {
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++)
                land[i][j] = new Plot();
        
        titles = new ArrayList<Title>(Arrays.asList(new Title("Farmer", 0, 0, 0, 0, 0,0),
                                                    new Title("Registered Farmer", 5, 1, 1, 0, 0,200),
                                                    new Title("Distinguished Farmer", 10, 2, 2, 1, 0, 300),
                                                    new Title("Legendary Farmer", 15, 4, 3, 2, 1, 400)));

        tools = new ArrayList<Tools>(Arrays.asList(new Tools("Plow", 0,0.5f),
                                                   new Tools("Watering Can", 0,0.5f),
                                                   new Tools("Fertilizer", 10,4),
                                                   new Tools("Pickaxe", 50,15),
                                                   new Tools("Shovel", 7, 2.0f)));

        seed = new ArrayList<Seeds>(Arrays.asList(new Seeds(2,1,1,2,0,2, 1,5,6,5, "Turnips", "Root crop","TNP")));
        
        xp = 0f;
        gameOver = false;
        currentDay = 1;
    }

    public Float getObjectcoins() {
        return Objectcoins;
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
    
    public ArrayList<Seeds> getSeed() {
        return seed;
    }

    public void setObjecticoins(Float objecticoins) {
        Objectcoins = objecticoins;
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

    public boolean enoughMoney(float objecticoins,float cost){
        if(objecticoins>= cost)
            return true;
        return false;
    }

    public void plantSeed(Plot plot,int seedType){
        if(plot.isHasRock())
            return;
        if(plot.isPlowed() == true && plot.getSeed() == null){
            Seeds seedPlaced = seed.get(seedType-1);
            // always check if enough money
            if(enoughMoney(Objectcoins,seedPlaced.getSeedCost())){
                //seet seed from array as the planted
                plot.setSeed(seedPlaced);
                Seeds plotSeed = plot.getSeed(); 
                plotSeed.setDayPlanted(currentDay);
                //deduct player coins
                Objectcoins -= plotSeed.getSeedCost();
            }
        }
    }

    public void RemoveRock(Plot plot){
        // remove rock and deduct from player
        Tools Pickaxe = tools.get(3);
        if(plot.isHasRock()){
            if(enoughMoney(Objectcoins,Pickaxe.getCost())){
                plot.setHasRock(false);
                Objectcoins -= Pickaxe.getCost();
                xp += Pickaxe.getXpGain();
            }
        }
    }

    // doesnt cost anything so no need subtraction
    public void Plow(Plot plot){
        Tools Plow = tools.get(0);
        // cant plow land with rock
        if(plot.isHasRock())
            return;
        if(plot.isPlowed() == false){
            plot.setPlowed(true);
            xp += Plow.getXpGain();
        }
    }

    // doesnt cost anything so no need subtraction
    public void waterPlant(Plot plot){
        Tools waterCan = tools.get(1);
        Seeds plant = plot.getSeed();
        if(plant != null){
            //xp is only awarded if the plant is not max limit and not withered
            int maxLimit = plant.getWaterBonusLimit() + titles.get(titleIndex).getWaterBonus();
            if(plant.isWithered() == false && plant.getWaterNo() < maxLimit){
                // add plant and player attrivbutes
                plant.setWaterNo(plant.getWaterNo()+1);
                xp += waterCan.getXpGain();
            }
        }
    }

    public void fertilizePlant(Plot plot){
        Tools fertilizer = tools.get(2);
        Seeds plant = plot.getSeed();
        if(plant != null){
            //xp is only awarded if the plant is not max limit and not withered
            int maxLimit = plant.getWaterBonusLimit() + titles.get(titleIndex).getFertilizerBonus();
            if(plant.isWithered() == false && plant.getWaterNo() < maxLimit){
                plant.setFertilizerNo(plant.getFertilizerNo()+1);
                Objectcoins -= fertilizer.getCost();
                xp += fertilizer.getXpGain();
            }
        }
    }

    public void shovelPlot(Plot plot){
        Tools shovel = tools.get(4);
        Seeds plant = plot.getSeed();
        //check first if player has enough coins
        if(enoughMoney(Objectcoins, shovel.getCost())){
            //make empty if plant occupies space
            if(plant != null)
                plot.setSeed(null);
            //if no plant then nothing happens just deduct player stats
            xp += shovel.getXpGain();
            Objectcoins -= shovel.getCost();
            // make plot unplowed dosent matter if it has rock since the default is false    
            plot.setPlowed(false);
        }
    }
    
    //finish this function 
    public void harvestPlant(Plot plot){
        Seeds plant = plot.getSeed();
        //in the next day function remember to decrement harvestTime
        // cant harvest withered
        if(plant.isWithered())
            return;
        // if the harvest time is 0 and not withered
        if(plant.getHarvestTime() == 0){
            //if enough water and fertilizer
            if(plant.MeesFertilizerNeeds() && plant.MeetsWaterNeeds()){

            }
        }
    }

    public void nextLevel(){
        // max is 4 no more titles available
        if(titleIndex < 4)
            return;
        Title nextTitle = titles.get(titleIndex+1);
        //sufficient funds
        if(enoughMoney(Objectcoins,nextTitle.getRegistrationFee()))
            // enought level
            if( xp/100 >= nextTitle.getlevelRequired())
                titleIndex += 1;
    }

    public void RenderPlot(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(land[i][j].getSeed() != null)
                    System.out.print(land[i][j].getSeed().getSymbol() + " ");
                else
                    System.out.print("EMP ");
            }
            System.out.println();
        }
    }

    // debugging purposes
    @Override
    public String toString() {
        return "Farmer [Objectcoins=" + Objectcoins + ", xp=" + xp + "]";
    }

}