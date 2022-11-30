import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/** 
 * Represents the farmer or the player of the game
 * @author Jordan Chong
 * @author Arvin Tan
*/
public class Farmer {

    private boolean gameOver = false;
    private int currentDay = 1;
    private int titleIndex = 0;
    private int rows = 10;
    private int columns = 5;
    private Float Objectcoins = 100f;
    private Float xp = 0f;
    private Plot[][] land = new Plot[rows][columns];
    private int pieceHarvested = 0;

    /**
     * creates an instance of the farmer and generate the 2d matrix of plots
    */
    public Farmer() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                land[i][j] = new Plot();
        generateRocks();

    }

    /**
     * This method gets the coins that the farmers posses
     * @return the coin count of the farmer
    */
    public Float getObjectcoins() {
        return Objectcoins;
    }

    /**
     * This method gets the current xp of the famer
     * @return the xp count of the farmer
    */
    public Float getXp() {
        return xp;
    }

    /**
     * This method gets the game status of the current instance of the farmer
     * @return if the farmer lost already or not
    */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * This method gets the current day which the farmer is on
     * @return the day of the farmer
    */
    public int getCurrentDay() {
        return currentDay;
    }

    /**
     * This method gets the current title index of the farmer
     * @return the title index of the farmer
    */
    public int getTitleIndex() {
        return titleIndex;
    }

    /**
     * This method gets how many rows of land does the farmer owns 
     * @return the rows of land the farmer owns
    */
    public int getRows() {
        return rows;
    }

    /**
     * This method gets how many columns of land does the farmer owns 
     * @return the columns of land the farmer owns
    */
    public int getColumns() {
        return columns;
    }

    /**
     * This method gets the 2d land the farmer owns
     * @return the 2d land the farmer owns
    */
    public Plot[][] getLand() {
        return land;
    }

    /**
     * This method sets the coins of the farmer to the given value
     * @param objecticoins the new coin count the farmer will own
    */
    public void setObjecticoins(Float objecticoins) {
        Objectcoins = objecticoins;
    }

    /**
     * This method sets the xp of the farmer to the given value
     * @param xp the new xp count the farmer will own
    */
    public void setXp(Float xp) {
        this.xp = xp;
    }

    /**
     * This method sets the game status of the farmer to the given value
     * @param gameOver the game status of the farmer 
    */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * This method sets the current day of the farmer to the given value
     * @param currentDay the day of the farmer 
    */
    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    /**
     * This method sets the current title of the farmer to the given value
     * @param titleIndex the title of the farmer
    */
    public void setTitleIndex(int titleIndex) {
        this.titleIndex = titleIndex;
    }

    /**
     * This method checks if the famrer has enough money to do a certain action
     * @param objecticoins the coins that the farmer currently owns
     * @param cost the cost of the action/item
     * @return a boolean that signifies if user has enough money
    */
    public boolean enoughMoney(float objecticoins, float cost) {
        if (objecticoins >= cost)
            return true;
        return false;
    }

    /**
     * This method allows the farmer to remove a rock from the plot
     * @param x the x-coordinate of the plot
     * @param y the y-coordinate of the plot
     * @param Pickaxe the tool object that will be used to perform the action
     * @return a string that signifies the status of the action
    */
    public String RemoveRock(int x, int y, Tools Pickaxe) {
        // remove rock and deduct from player
        Plot plot = land[x][y];
        if (plot.isHasRock()) {
            if (enoughMoney(Objectcoins, Pickaxe.getCost())) {
                plot.setHasRock(false);
                Objectcoins -= Pickaxe.getCost();
                xp += Pickaxe.getXpGain();
                return "Success";
            } else
                return "Money";
        } else
            return "Rock";
    }

    /**
     * This method allows the farmer to plow a plot
     * @param x the x-coordinate of the plot
     * @param y the y-coordinate of the plot
     * @param Plow the tool object that will be used to perform the action
     * @return a string that signifies the status of the action
    */
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
        } else
            return "Plowed";
    }

    /**
     * This method allows the farmer to water a plant
     * @param x the x-coordinate of the plot
     * @param y the y-coordinate of the plot
     * @param waterCan the tool object that will be used to perform the action
     * @return a string that signifies the status of the action
    */
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
            } else
                return "Withered";
        } else
            return "No plant";
    }

    /**
     * This method allows the farmer to fertilize a plant
     * @param x the x-coordinate of the plot
     * @param y the y-coordinate of the plot
     * @param waterCan the tool object that will be used to perform the action
     * @return a string that signifies the status of the action
    */
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
            } else
                return "Withered";
        } else
            return "No plant";
    }

    /**
     * This methods allows the farmer to shovel a plot
     * @param x the x-coordinate of the plot
     * @param y the y-coordinate of the plot
     * @param shovel the tool object that will be used to perform the action
     * @return a string that signifies the status of the action
    */
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
        } else
            return "Money";
    }

    /**
     * This methods generates a plant to be planted 
     * @param type the type of seed that will be generated
     * @return an instance of the seed object to be planted
    */
    public Seeds generateSeedType(String type) {
        Seeds seed = null;
        switch (type) {
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
    /**
     * This method checks if a tree is planted on the outskirts of the plot
     * @param x the x-coordinate of the plot
     * @param y the y-coordinate of the plot
     * @return a boolean that signifies the is planted on the outskirts of the plot
    */
    public boolean Inbound(int x, int y) {
        // if first or last row/column
        if (x == 0 || x == rows - 1 || y == 0 || y == columns - 1)
            return false;
        return true;
    }

    /**
     * This method checks if the tree that is going to be planted has objects beside it
     * @param x the x-coordinate of the plot
     * @param y the y-coordinate of the plot
     * @return a boolean that signifies if the tree that is going to be planted has objects beside it
    */
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

    /**
     * This method allows the farmer to plant a seed
     * @param seedType the seed that is going to be planted
     * @param x the x-coordinate of the plot
     * @param y the y-coordinate of the plot
     * @param title the current title of the farmer
     * @return a string that signifies the status of the action
    */
    public String PlantSeed(String seedType, int x, int y, Title title) {
        Plot plot = land[x][y];

        if (plot.isHasRock()) {
            return "Rock";
        }
        if (plot.isPlowed() == false) {
            return "Not plowed";
        }

        if (plot.getSeed() != null) {
            return "Occupied";
        }

        Seeds seedPlaced = generateSeedType(seedType);
        // the new price including the discount
        float cost = seedPlaced.getSeedCost() - title.getSeedCostReduction();

        // always check if enough money including the title deduction
        if (enoughMoney(Objectcoins, cost)) {
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
        } else
            return "Money";
    }

    // bonuses for total
    /**
     * This method computes the water bonus for the final harvest time
     * @param harvestTotal the base harvest total
     * @param plant the plant that is going to be harvested
     * @param limit the max water limit of the plant
     * @return the water bonus of the harvest
    */
    public float WaterBonus(float harvestTotal, Seeds plant, int limit) {
        int timesWater = (plant.getWaterNo() > limit) ? limit : plant.getWaterNo();
        return (float) (harvestTotal * 0.2 * (timesWater - 1));
    }

    /**
     * This method computes the fertilizer bonus for the final harvest time
     * @param harvestTotal the base harvest total
     * @param plant the plant that is going to be harvested
     * @param limit the max fertilizer limit of the plant
     * @return the fertilizer bonus of the harvest
    */
    public float FertilizerBonus(float harvestTotal, Seeds plant, int limit) {
        int timesFertilize = (plant.getFertilizerNo() > limit) ? limit : plant.getFertilizerNo();
        return (float) (harvestTotal * 0.5 * timesFertilize);
    }

    /**
     * This method allows the farmer to harvest a plant
     * @param x the x-coordinate of the plot
     * @param y the y-coordinate of the plot
     * @param title the current title of the farmer
     * @return a string that signifies the status of the action
    */
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

        // store pieces harvested
        pieceHarvested += productsProduced;

        // reset plot with reinitialization
        plot.resetAfterHarvest();

        // print the player harvest
        result[0] = plant.getSeedName();
        result[1] = Integer.toString(productsProduced);
        result[2] = String.format("%.2f", finalHarvestPrice);

        return result;
    }

    /**
     * This method allows the farmer to be promoted to the next titles
     * @param titles a list of the available titles 
     * @return a string that signifies the status of the action
    */
    public String nextLevel(ArrayList<Title> titles) {
        Title nextTitle = titles.get(titleIndex + 1);
        // sufficient funds
        if (enoughMoney(Objectcoins, nextTitle.getRegistrationFee()))
            // enought level deduct money and increment rank
            if (xp / 100 >= nextTitle.getlevelRequired()) {
                titleIndex += 1;
                Objectcoins -= nextTitle.getRegistrationFee();
                // max level
                if (titleIndex == titles.size() - 1)
                    return "Legendary Farmer";
                return nextTitle.getTitleName();
            } else
                return "No xp";
        else
            return "Money";
    }

    /**
     * This method checks if the player has not lose the game
     * @param titles a list of the available titles
     * @param seed a list of the available seeds
     * @param tools a list of the available tools
     * @return a boolean that checks if a player lost or not
    */
    public boolean continueGame(ArrayList<Title> titles, ArrayList<Seeds> seed, ArrayList<Tools> tools) {

        int witherCount = 0;
        int rockCount = 0;
        int activePlants = 0;
        int totalTiles = columns * rows;
        Title title = titles.get(titleIndex);
        // dont forget about the discount for seeds
        float cheapestPlantCost = seed.get(0).getSeedCost() - title.getSeedCostReduction();
        float shovelPrice = tools.get(4).getCost();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Plot tile = land[i][j];
                Seeds plant = tile.getSeed();
                if (plant != null) {
                    if (plant.isWithered())
                        witherCount += 1;
                    else
                        activePlants += 1;
                }
                if (tile.isHasRock())
                    rockCount += 1;
            }
        }
        // if all tiles have withered plants
        if (witherCount == totalTiles)
            return false;

        // no active plants and enough money to buy new seed including the deduction
        // bonus
        if (Objectcoins < cheapestPlantCost && activePlants == 0)
            return false;

        // if all tiles are occupied by rock or wither
        if (rockCount + witherCount == totalTiles)
            // since the cheapest way to escape this is that player has a shovel and turnip
            // seed
            if (Objectcoins < cheapestPlantCost + shovelPrice)
                return false;

        return true;
    }

    // only check if the player lost during transition to next day
    /**
     * This method allows the player to move to another day
     * @param titles a list of the available titles
     * @param seed a list of the available seeds
     * @param tools a list of the available tools
    */
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
        // increment day
        setCurrentDay(currentDay + 1);
        if (continueGame(titles, seed, tools) == false)
            gameOver = true;
    }

    /**
     * This method modifies the starting plot to include rocks
    */
    public void generateRocks() {
        try {
            // files that are possible
            String[] possibleRockFormation = { "Rocks.txt", "Rocks2.txt", "Rocks3.txt" };
            // since 3 possible
            Random r = new Random();
            int index = r.nextInt(0, possibleRockFormation.length);
            String filename = "rocks/" + possibleRockFormation[index];

            File myObj = new File(filename);
            Scanner scan = new Scanner(myObj);
            // loop through every number in file with accordance to the matrix size
            while (scan.hasNextLine()) {
                for (int i = 0; i < rows; i++) {
                    String[] line = scan.nextLine().trim().split(" ");
                    for (int j = 0; j < line.length; j++)
                        // 1 just means make it a rock
                        if (Integer.parseInt(line[j]) == 1)
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


    /**
     * This allows the farmer to water all plants in the land
     * @param waterCan the tool that will be used to make the action
    */
    public void waterAll(Tools waterCan) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                WaterPlant(i, j, waterCan);
    }

    /**
     * This allows the farmer to plow all plots of land
     * @param plow the tool that will be used to make the action
    */
    public void plowAll(Tools plow) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                Plow(i, j, plow);
    }

    /**
     * This allows the farmer to harvest all plants in the land
     * @param title the current title of the farmer
     * @return the result of the harvest
    */
    public String[] harvestAll(Title title) {
        // reset values to zero
        float currentCoins = Objectcoins;
        String[] result = new String[2];
        pieceHarvested = 0;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                Seeds seed = land[i][j].getSeed();
                if (seed != null) {
                    if (seed.getHarvestTime() == 0 && seed.isWithered() == false)
                        HarvestPlant(i, j, title);
                }
            }

        result[0] = Integer.toString(pieceHarvested);
        result[1] = String.format("%.2f", Objectcoins - currentCoins);

        return result;
    }
}