import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Farmer {
    private boolean gameOver = false;
    private int currentDay = 1;
    private int titleIndex = 0;
    private int rows = 10;
    private int columns = 5;
    private Float Objectcoins = 100f;
    private Float xp = 0f;
    private Plot[][] land = new Plot[rows][columns];

    public Farmer() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                land[i][j] = new Plot();
        generateRocks();

    }

    public Float getObjectcoins() {
        return Objectcoins;
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

    public boolean enoughMoney(float objecticoins, float cost) {
        if (objecticoins >= cost)
            return true;
        return false;
    }

    public String RemoveRock(int x, int y, Tools Pickaxe) {
        // remove rock and deduct from player
        Plot plot = land[x][y];
        if (plot.isHasRock()) {
            if (enoughMoney(Objectcoins, Pickaxe.getCost())) {
                plot.setHasRock(false);
                Objectcoins -= Pickaxe.getCost();
                xp += Pickaxe.getXpGain();
                return "Success";
            } 
            else
                return "Money";
        } 
        else
            return "Rock";
    }

    // doesnt cost anything so no need subtraction
    public String Plow(int x, int y, Tools Plow) {
        Plot plot = land[x][y];
        // cant plow land with rock
        if (plot.isHasRock()) 
            return "Rock";
        if (plot.isPlowed() == false) {
            plot.setPlowed(true);
            xp += Plow.getXpGain();
            return "Success";
        } 
        else
            return "Plowed";
    }

    // doesnt cost anything so no need subtraction
    public String WaterPlant(int x, int y, Tools waterCan) {

        Plot plot = land[x][y];
        Seeds plant = plot.getSeed();

        if (plant != null) {
            // this doesnt allow watering of withered crops
            if (plant.isWithered() == false) {
                plant.setWaterNo(plant.getWaterNo() + 1);
                xp += waterCan.getXpGain();
                return "Success";
            } 
            else
                return "Withered";
        } 
        else
            return "No plant";
    }

    public String FertilizePlant(int x, int y, Tools fertilizer) {
        
        Plot plot = land[x][y];
        Seeds plant = plot.getSeed();

        if (plant != null) {
            // this doesnt allow fertilizing withered crops
            if (plant.isWithered() == false) {
                plant.setFertilizerNo(plant.getFertilizerNo() + 1);
                Objectcoins -= fertilizer.getCost();
                xp += fertilizer.getXpGain();
                return "Success";
            } 
            else
                return "Withered";
        } 
        else
            return "No plant";
    }

    public String ShovelPlot(int x, int y, Tools shovel) {

        Plot plot = land[x][y];
        Seeds plant = plot.getSeed();

        // check first if player has enough coins
        if (enoughMoney(Objectcoins, shovel.getCost())) {
            // make empty if plant occupies space
            if (plant != null)
                plot.setSeed(null);
            // if no plant then nothing happens just deduct player stats
            xp += shovel.getXpGain();
            Objectcoins -= shovel.getCost();
            // make plot unplowed dosent matter if it has rock since the default is false
            plot.setPlowed(false);
            return "Success";
        } 
        else
            return "Money";
    }

    public Seeds generateSeedType(String type){
        Seeds seed = null;
        switch(type){
            case "Turnip":
                seed = new Seeds("Turnip", "Root crop", 2, 1, 2, 0, 1, 1, 2, 5, 6, 5);
                break;
            case "Carrot":
                seed = new Seeds("Carrot", "Root crop", 3, 1, 2, 0, 1, 1, 2, 10, 9, 7.5f);
                break;
            case "Potato":
                seed = new Seeds("Potato", "Root crop", 5, 3, 4, 1, 2, 1, 10, 20, 3, 12.5f);
                break;
            case "Rose":
                seed = new Seeds("Rose", "Flower", 1, 1, 2, 0, 1, 1, 1, 5, 5, 2.5f);
                break;
            case "Turnips":
                seed = new Seeds("Turnips", "Flower", 2, 2, 3, 0, 1, 1, 1, 10, 9, 5);
                break;
            case "Sunflower":
                seed = new Seeds("Sunflower", "Flower", 3, 2, 3, 1, 2, 1, 1, 20, 19, 7.5f);
                break;
            case "Mango":
                seed = new Seeds("Mango", "Fruit tree", 10, 7, 7, 4, 4, 5, 15, 100, 8, 25);
                break;
            case "Apple":
                seed = new Seeds("Apple", "Fruit tree", 10, 7, 7, 5, 5, 10, 15, 200, 5, 25);
                break;
        }
        return seed;
    }

    // check fruit tree conditions
    public boolean Inbound(int x, int y) {
        // if first or last row/column
        if (x == 0 || x == rows - 1 || y == 0 || y == columns - 1)
            return false;
        return true;
    }

    public boolean BesideTree(int x, int y) {
        if (Inbound(x, y) == false)
            return false;
        // right,left,down,up,r down dia, l down dia, l up dia, r up dia
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } };
        // loop all adjacent plots and check if occupied
        for (int[] i : directions) {
            Plot plot = land[x + i[0]][y + i[1]];
            if (plot.isHasRock() || plot.getSeed() != null)
                return false;
        }
        return true;
    }

    public String PlantSeed(String seedType, int x, int y, Title title) {   
        Plot plot = land[x][y];
        
        if (plot.isHasRock()) {
            return "Rock";
        }
        if (plot.isPlowed() == false){
            return "Not plowed";
        }
        
        if(plot.getSeed() != null){
            return "Occupied";
        }

        Seeds seedPlaced = generateSeedType(seedType);
        //the new price including the discount
        float cost = seedPlaced.getSeedCost() - title.getSeedCostReduction();

        // always check if enough money including the title deduction
        if (enoughMoney(Objectcoins, cost)){
            // for fruit trees use checking functions
            if (seedPlaced.getCropType().equals("Fruit tree"))
                if (BesideTree(x, y) == false) {
                    return "Invalid Tree";
                }
            // set seed from array as the planted
            plot.setSeed(seedPlaced);
            Seeds plotSeed = plot.getSeed();
            plotSeed.setDayPlanted(currentDay);
            // deduct player coins including title bonus
            Objectcoins -= cost;
            // inform user
            return "Success";
        } 
        else
            return "Money";
    }

     // bonuses for total
     public float WaterBonus(float harvestTotal, Seeds plant, int limit) {
        int timesWater = (plant.getWaterNo() > limit) ? limit : plant.getWaterNo();
        return (float) (harvestTotal * 0.2 * (timesWater - 1));
    }

    public float FertilizerBonus(float harvestTotal, Seeds plant, int limit) {
        int timesFertilize = (plant.getFertilizerNo() > limit) ? limit : plant.getFertilizerNo();
        return (float) (harvestTotal * 0.5 * timesFertilize);
    }

    public String[] HarvestPlant(int x, int y, Title title) {
        Plot plot = land[x][y];
        Seeds plant = plot.getSeed();
        String[] result = new String[3];

        // limits for water and fert
        int maxFertilizerLimit = plant.getWaterBonusLimit() + title.getFertilizerBonus();
        int maxWaterLimit = plant.getWaterBonusLimit() + title.getWaterBonus();
        int productsProduced = plant.computeProductsProduced();

        // compute for results
        float harvestTotal = productsProduced * (plant.getBasePrice() + title.getEarningsBonus());
        float waterBonus = WaterBonus(harvestTotal, plant, maxWaterLimit);
        float fertilizerBonus = FertilizerBonus(harvestTotal, plant, maxFertilizerLimit);
        float finalHarvestPrice = harvestTotal + waterBonus + fertilizerBonus;
        // flower bonus
        if (plant.getCropType() == "Flower")
            finalHarvestPrice *= 1.1;

        // change player stats
        xp += plant.getXpYield();
        Objectcoins += finalHarvestPrice;

        // reset plot with reinitialization
        plot.resetAfterHarvest();

        // print the player harvest
        result[0] = plant.getSeedName();
        result[1] = Integer.toString(productsProduced);
        result[2] = Float.toString(finalHarvestPrice);
        return result;
    }

    public String nextLevel(ArrayList<Title> titles) {
        Title nextTitle = titles.get(titleIndex + 1);
        // sufficient funds
        if (enoughMoney(Objectcoins, nextTitle.getRegistrationFee()))
            // enought level deduct money and increment rank
            if (xp / 100 >= nextTitle.getlevelRequired()) {
                titleIndex += 1;
                Objectcoins -= nextTitle.getRegistrationFee();
                //max level
                if(titleIndex == titles.size()-1)
                    return "Legendary Farmer";
                return nextTitle.getTitleName();
            } 
            else
                return "No xp";
        else
            return "Money";
    }

    public boolean continueGame(ArrayList<Title> titles, ArrayList<Seeds> seed, ArrayList<Tools> tools){
        
        int witherCount = 0;
        int rockCount = 0;
        int activePlants = 0;
        int totalTiles = columns * rows;
        Title title = titles.get(titleIndex);
        //dont forget about the discount for seeds
        float cheapestPlantCost = seed.get(0).getSeedCost() - title.getSeedCostReduction();
        float shovelPrice =  tools.get(4).getCost();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Plot tile = land[i][j];
                Seeds plant = tile.getSeed();
                if(plant != null){
                    if(plant.isWithered())
                        witherCount += 1;
                    else   
                        activePlants += 1;
                }
                if(tile.isHasRock())
                    rockCount += 1;
            }
        }
        //if all tiles have withered plants
        if(witherCount == totalTiles)
            return false;

        // no active plants and enough money to buy new seed including the deduction bonus
        if(Objectcoins < cheapestPlantCost && activePlants == 0)
            return false;

        //if all tiles are occupied by rock or wither
        if(rockCount + witherCount == totalTiles)
            //since the cheapest way to escape this is that player has a shovel and turnip seed
            if(Objectcoins < cheapestPlantCost + shovelPrice)
                return false;
        
        return true;
    }
    
    //only check if the player lost during transition to next day
    public void NextDay(ArrayList<Title> titles, ArrayList<Seeds> seed, ArrayList<Tools> tools) {
        // loop through every piece of plot
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Seeds plant = land[i][j].getSeed();
                if (plant != null) {
                    // if the plant is not yet withered
                    if (plant.isWithered() == false) {
                        boolean meetNeeds = plant.MeetsWaterNeeds() && plant.MeetsFertilizerNeeds();
                        plant.setHarvestTime(plant.getHarvestTime() - 1);
                        if ((plant.getHarvestTime() == 0 && meetNeeds == false) || plant.getHarvestTime() < 0)
                            plant.setWithered(true);
                    }
                }
            }
        }
        //increment day
        setCurrentDay(currentDay+1);
        if(continueGame(titles,seed,tools) == false)
            gameOver = true;
    }

    public void generateRocks(){
        try {
            //files that are possible
            String[] possibleRockFormation = {"Rocks.txt","Rocks2.txt","Rocks3.txt"};
            // since 3 possible
            Random r = new Random();
            int index = r.nextInt(0,possibleRockFormation.length);
            String filename = "rocks/" + possibleRockFormation[index];

            File myObj = new File(filename);
            Scanner scan = new Scanner(myObj);
            //loop through every number in file with accordance to the matrix size
            while (scan.hasNextLine()) {
                for (int i=0; i< rows; i++) {
                    String[] line = scan.nextLine().trim().split(" ");
                    for (int j=0; j< line.length; j++)
                        // 1 just means make it a rock
                        if(Integer.parseInt(line[j]) == 1)
                            land[i][j].setHasRock(true);
                }
            }
            scan.close();
        } 
        // file not found throw error
        catch (FileNotFoundException e) {
            System.out.println("No rock files! No rocks will be used.\n");
        }
    }
}