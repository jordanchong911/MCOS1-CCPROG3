import java.util.ArrayList;
import java.util.Arrays;

public class Farmer {
    final private ArrayList<Title> titles;
    final private ArrayList<Tools> tools;
    final private ArrayList<Seeds> seed;
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

        titles = new ArrayList<Title>(Arrays.asList(new Title("Farmer", 0, 0, 0, 0, 0, 0),
                new Title("Registered Farmer", 5, 1, 1, 0, 0, 200),
                new Title("Distinguished Farmer", 10, 2, 2, 1, 0, 300),
                new Title("Legendary Farmer", 15, 4, 3, 2, 1, 400)));

        tools = new ArrayList<Tools>(Arrays.asList(new Tools("Plow", 0, 0.5f,"Converts an unplowed tile to a plowed tile. Can only be performed on an unplowed tile."),
                new Tools("Watering Can", 0, 0.5f, "Adds to the total number of tiles a tile/crop has been watered. Can only be performed on a plowed tile with a crop."),
                new Tools("Fertilizer", 10, 4, "Adds to the total number of tiles a tile/crop has been applied with fertilizer. Can only be performed on a plowed tile with a crop."),
                new Tools("Pickaxe", 50, 15, "Removes a rock from a tile. Can only be applied to tiles with a rock."),
                new Tools("Shovel", 7, 2.0f, "Removes a withered plant from a tile. Can be used on any tile/crop with varying effects, as described above.")));

        seed = new ArrayList<Seeds>(Arrays.asList(new Seeds(2, 1, 1, 2, 0, 2, 1, 5, 6, 5, "Turnip", "Root crop", "TNP"),
                new Seeds(3, 1, 1, 2, 0, 2, 1, 10, 9, 7.5f, "Carrot", "Root crop", "CRT"),
                new Seeds(5, 3, 1, 10, 1, 4, 2, 20, 3, 12.5f, "Potato", "Root crop", "PTO"),
                new Seeds(1, 1, 1, 1, 0, 2, 1, 5, 5, 2.5f, "Rose", "Flower", "RSE"),
                new Seeds(2, 2, 1, 1, 0, 3, 1, 10, 9, 5f, "Turnips", "Flower", "TPS"),
                new Seeds(3, 2, 1, 1, 1, 3, 2, 20, 19, 7.5f, "Sunflower", "Flower", "SNF"),
                new Seeds(10, 7, 5, 15, 4, 7, 4, 100, 8, 25f, "Mango", "Fruit tree", "MGO"),
                new Seeds(10, 7, 10, 15, 5, 7, 5, 200, 5, 25f, "Apple", "Fruit tree", "APL")));

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

    public ArrayList<Seeds> getSeedList() {
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

    // error messages
    public boolean enoughMoney(float objecticoins, float cost) {
        if (objecticoins >= cost)
            return true;
        return false;
    }

    public void rockError(int type) {
        if (type == 1)
            System.out.println("This plot has a rock");
        else if (type == 2)
            System.out.println("There is no rock here");
    }

    public void moneyError() {
        System.out.println("You don't have enough objectcoins");
    }

    public void plotError(int type) {
        if (type == 1)
            System.out.println("The plot is not plowed");
        else if (type == 2)
            System.out.println("The plot is plowed");
        else if(type == 3)
            System.out.println("The plot is occupied");
    }

    public void plantError(int type) {
        if (type == 1)
            System.out.println("The plot has no plant");
        else if (type == 2)
            System.out.println("The plant is withered");
        else if (type == 3)
            System.out.println("The plant is not ready for harvest");
    }
    // error messages up to here
    
    //made this since if we use the indices from the array it will make all instances the same
    public Seeds generateSeedType(int type){
        Seeds seed = null;
        switch(type){
            case 1:
                seed = new Seeds(2, 1, 1, 2, 0, 2, 1, 5, 6, 5, "Turnip", "Root crop", "TNP");
                break;
            case 2:
                seed = new Seeds(3, 1, 1, 2, 0, 2, 1, 10, 9, 7.5f, "Carrot", "Root crop", "CRT");
                break;
            case 3:
                seed = new Seeds(5, 3, 1, 10, 1, 4, 2, 20, 3, 12.5f, "Potato", "Root crop", "PTO");
                break;
            case 4:
                seed = new Seeds(1, 1, 1, 1, 0, 2, 1, 5, 5, 2.5f, "Rose", "Flower", "RSE");
                break;
            case 5:
                seed = new Seeds(2, 2, 1, 1, 0, 3, 1, 10, 9, 5f, "Turnips", "Flower", "TPS");
                break;
            case 6:
                seed = new Seeds(3, 2, 1, 1, 1, 3, 2, 20, 19, 7.5f, "Sunflower", "Flower", "SNF");
                break;
            case 7:
                seed = new Seeds(10, 7, 5, 15, 4, 7, 4, 100, 8, 25f, "Mango", "Fruit tree", "MGO");
                break;
            case 8:
                seed = new Seeds(10, 7, 10, 15, 5, 7, 5, 200, 5, 25f, "Apple", "Fruit tree", "APL");
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

    public void PlantSeed(int seedType, int x, int y) {   
        Plot plot = land[x][y];
        Title title = titles.get(titleIndex);
        
        if (plot.isHasRock()) {
            rockError(1);
            return;
        }
        if (plot.isPlowed() == false){
            plotError(1);
            return;
        }
        
        if(plot.getSeed() != null){
            plotError(3);
            return;
        }

        Seeds seedPlaced = generateSeedType(seedType);
        //the new price including the discount
        float cost = seedPlaced.getSeedCost() - title.getSeedCostReduction();

        // always check if enough money including the title deduction
        if (enoughMoney(Objectcoins, cost)){
            // for fruit trees use checking functions
            if (seedPlaced.getCropType().equals("Fruit tree"))
                if (BesideTree(x, y) == false) {
                    System.out.println("Invalid location for fruit tree");
                    return;
                }
            // set seed from array as the planted
            plot.setSeed(seedPlaced);
            Seeds plotSeed = plot.getSeed();
            plotSeed.setDayPlanted(currentDay);
            // deduct player coins including title bonus
            Objectcoins -= cost;
            // inform user
            System.out.println("Successfully planted " + seedPlaced.getSeedName());
        } 
        else
            moneyError();
    }

    public void RemoveRock(Plot plot) {
        // remove rock and deduct from player
        Tools Pickaxe = tools.get(3);
        if (plot.isHasRock()) {
            if (enoughMoney(Objectcoins, Pickaxe.getCost())) {
                plot.setHasRock(false);
                Objectcoins -= Pickaxe.getCost();
                xp += Pickaxe.getXpGain();
                // inform user
                System.out.println("Successfully removed rock");
            } else
                moneyError();
        } else
            rockError(2);
    }

    // doesnt cost anything so no need subtraction
    public void Plow(Plot plot) {
        Tools Plow = tools.get(0);
        // cant plow land with rock
        if (plot.isHasRock()) {
            rockError(1);
            return;
        }
        if (plot.isPlowed() == false) {
            plot.setPlowed(true);
            xp += Plow.getXpGain();
            // inform user
            System.out.println("Successfully plowed plot");
        } else
            plotError(2);

    }

    // doesnt cost anything so no need subtraction
    public void WaterPlant(Plot plot) {
        Tools waterCan = tools.get(1);
        Seeds plant = plot.getSeed();
        if (plant != null) {
            // this doesnt allow watering of withered crops
            if (plant.isWithered() == false) {
                plant.setWaterNo(plant.getWaterNo() + 1);
                xp += waterCan.getXpGain();
                System.out.println("Successfully watered crop");
            } else
                plantError(2);
        } else
            plantError(1);
    }

    public void FertilizePlant(Plot plot) {
        Tools fertilizer = tools.get(2);
        Seeds plant = plot.getSeed();
        if (plant != null) {
            // this doesnt allow fertilizing withered crops
            if (plant.isWithered() == false) {
                plant.setFertilizerNo(plant.getFertilizerNo() + 1);
                Objectcoins -= fertilizer.getCost();
                xp += fertilizer.getXpGain();
                System.out.println("Successfully fertilized crop");
            } else
                plantError(2);
        } else
            plantError(1);
    }

    public void ShovelPlot(Plot plot) {
        Tools shovel = tools.get(4);
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
            System.out.println("Successfully shoveled plot");
        } else
            moneyError();
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

    public void HarvestPlant(Plot plot) {
        Seeds plant = plot.getSeed();
        Title title = titles.get(titleIndex);

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
        System.out.println("\nThe plant " + plant.getSeedName() + " was successfully harvested\nQuantity: "
                + productsProduced + "\nTotal Coins: " + finalHarvestPrice);
    }

    public void nextLevel() {
        // no more titles available
        if (titleIndex >= titles.size() - 1) {
            System.out.println("You are already at max level");
            return;
        }
        Title nextTitle = titles.get(titleIndex + 1);
        // sufficient funds
        if (enoughMoney(Objectcoins, nextTitle.getRegistrationFee()))
            // enought level deduct money and increment rank
            if (xp / 100 >= nextTitle.getlevelRequired()) {
                titleIndex += 1;
                Objectcoins -= nextTitle.getRegistrationFee();
                System.out.println("Successfully leveled up to " + nextTitle.getTitleName());
            } 
            else
                System.out.println("Failed to level up to " + nextTitle.getTitleName() + " since you dont have enough xp");
        else
            moneyError();
    }

    public boolean isLose(){
        
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
        if(witherCount == totalTiles){
            System.out.println("You lost due to all tiles are occupied by withered plants. Better luck next time!");
            return false;
        }

        // no active plants and enough money to buy new seed including the deduction bonus
        if(Objectcoins < cheapestPlantCost && activePlants == 0){
            System.out.println("You lost due to not having any money to buy new plants and no plants growing. Better luck next time!");
            return false;
        }

        //if all tiles are occupied by rock or wither
        if(rockCount + witherCount == totalTiles)
            //since the cheapest way to escape this is that player has a shovel and turnip seed
            if(Objectcoins < cheapestPlantCost + shovelPrice){
                System.out.println("You lost due to not having coins to use a shovel and buy the cheapest plant. Better luck next time!");
                return false;
            }
        
        return true;
    }
    
    //only check if the player lost during transition to next day
    public void NextDay() {
        System.out.println("Moving onto next day");
        // loop through every piece of plot
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Seeds plant = land[i][j].getSeed();
                if (plant != null) {
                    // if the plant is not yet withered
                    if (plant.isWithered() == false) {
                        boolean meetNeeds = plant.MeetsWaterNeeds() && plant.MeetsFertilizerNeeds();
                        plant.setHarvestTime(plant.getHarvestTime() - 1);
                        if ((plant.getHarvestTime() == 0 && meetNeeds == false) || plant.getHarvestTime() < 0) {
                            plant.setWithered(true);
                            System.out.println("The plant at plot (" + (i + 1) + "," + (j + 1) + ") has withered");
                        }
                    }
                }
            }
        }
        //increment day
        setCurrentDay(currentDay+1);
        if(isLose() == false)
            gameOver = true;
    }

    // print the plot
    public void RenderPlot() {
        for (int i = 0; i < rows; i++) {
            System.out.print("| ");
            for (int j = 0; j < columns; j++) {
                if (land[i][j].getSeed() != null)
                    if(land[i][j].getSeed().isWithered() == false)
                        System.out.print(land[i][j].getSeed().getSymbol() + " ");
                    else
                        System.out.print("W" + land[i][j].getSeed().getSymbol().charAt(0) + land[i][j].getSeed().getSymbol().charAt(1) + " ");
                else if(land[i][j].isHasRock())
                    System.out.print("RCK ");
                else if(land[i][j].getSeed() == null && land[i][j].isPlowed())
                    System.out.print("PLW ");
                else if(land[i][j].getSeed() == null && land[i][j].isPlowed() == false)
                    System.out.print("UPW ");
            }
            System.out.println("|");
        }
    }

    // print player stats
    public void displayStats() {
        System.out.println("\nStats\nCurrent Day " + getCurrentDay() + "\nTitle " + titles.get(titleIndex).getTitleName()
                + "\nObjectcoins " + String.format("%.2f", getObjectcoins()) + "\nLevel " + (int) Math.floor(getXp() / 100));
    }

}