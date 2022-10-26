import java.util.ArrayList;
import java.util.Arrays;

public class Farmer {
    private ArrayList<Title> titles;
    private ArrayList<Tools> tools;
    private ArrayList<Seeds> seed;
    private boolean gameOver;
    private int currentDay;
    private int titleIndex = 0;
    private int rows = 10;
    private int columns = 5;
    private Float Objectcoins = 100f;
    private Float xp;
    private Plot[][] land = new Plot[rows][columns];

    public Farmer() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                land[i][j] = new Plot();

        titles = new ArrayList<Title>(Arrays.asList(new Title("Farmer", 0, 0, 0, 0, 0, 0),
                new Title("Registered Farmer", 5, 1, 1, 0, 0, 200),
                new Title("Distinguished Farmer", 10, 2, 2, 1, 0, 300),
                new Title("Legendary Farmer", 15, 4, 3, 2, 1, 400)));

        tools = new ArrayList<Tools>(Arrays.asList(new Tools("Plow", 0, 0.5f),
                new Tools("Watering Can", 0, 0.5f),
                new Tools("Fertilizer", 10, 4),
                new Tools("Pickaxe", 50, 15),
                new Tools("Shovel", 7, 2.0f)));

        seed = new ArrayList<Seeds>(Arrays.asList(new Seeds(2, 1, 1, 2, 0, 2, 1, 5, 6, 5, "Turnip", "Root crop", "TNP"),
                new Seeds(3, 1, 1, 2, 0, 2, 1, 10, 9, 7.5f, "Carrot", "Root crop", "CRT"),
                new Seeds(5, 3, 1, 10, 1, 4, 2, 20, 3, 12.5f, "Potato", "Root crop", "PTO"),
                new Seeds(1, 1, 1, 1, 0, 2, 1, 5, 5, 2.5f, "Rose", "Flower", "RSE"),
                new Seeds(2, 2, 1, 1, 0, 3, 1, 10, 9, 5f, "Turnips", "Flower", "TPS"),
                new Seeds(3, 2, 1, 1, 1, 3, 2, 20, 19, 7.5f, "Sunflower", "Flower", "SNF"),
                new Seeds(10, 7, 5, 15, 4, 7, 4, 100, 8, 25f, "Mango", "Fruit tree", "MGO"),
                new Seeds(10, 7, 10, 15, 5, 7, 5, 200, 5, 25f, "Apple", "Fruit tree", "APL")));

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

    // error messages
    public boolean enoughMoney(float objecticoins, float cost) {
        if (objecticoins >= cost)
            return true;
        return false;
    }

    public void rockError(int type) {
        if (type == 1)
            System.out.println("This plot has a rock unable to plant seed");
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

        Seeds seedPlaced = seed.get(seedType - 1);
        // always check if enough money
        if (enoughMoney(Objectcoins, seedPlaced.getSeedCost())){
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
            // deduct player coins
            Objectcoins -= plotSeed.getSeedCost();
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

        // no plant
        if (plant == null) {
            plantError(1);
            return;
        }

        // check if plant is withered
        if (plant.isWithered()) {
            plantError(2);
            return;
        }

        // not ready
        if (plant.getHarvestTime() != 0) {
            plantError(3);
            return;
        }

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
        System.out.println("The plant " + plant.getSeedName() + " was successfully harvested\nQuantity: "
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
            } else
                moneyError();
    }

    // dont forget to add game over conditions
    // havent complete this yet
    public void NextDay() {
        // loop through every piece of plot
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Seeds plant = land[i][j].getSeed();
                if (plant != null) {
                    // decrement harvest time by 1
                    plant.setHarvestTime(plant.getHarvestTime() - 1);
                    // if the plant is not yet withered
                    if (plant.isWithered() == false) {
                        boolean meetNeeds = plant.MeetsWaterNeeds() && plant.MeetsFertilizerNeeds();
                        if ((plant.getHarvestTime() == 0 && meetNeeds == false) || plant.getHarvestTime() < 0) {
                            plant.witherPlant();
                            System.out.println("The plant at plot (" + (i + 1) + "," + (j + 1) + ") has withered");
                        }
                    }
                }
            }
        }
    }

    // print the plot
    public void RenderPlot() {
        for (int i = 0; i < rows; i++) {
            System.out.print("| ");
            for (int j = 0; j < columns; j++) {
                if (land[i][j].getSeed() != null)
                    System.out.print(land[i][j].getSeed().getSymbol() + " ");
                else if(land[i][j].isHasRock())
                    System.out.print("RCK ");
                else if(land[i][j].getSeed() == null)
                    System.out.print("EMP ");
            }
            System.out.println("|");
        }
    }

    // print player stats
    public void displayStats() {
        System.out.println("Stats\ncurrentDay " + getCurrentDay() + "\ntitle " + titles.get(titleIndex).getTitleName()
                + "\nObjectcoins " + getObjectcoins() + "\nLevel " + (int) Math.floor(getXp() / 100));
    }

}