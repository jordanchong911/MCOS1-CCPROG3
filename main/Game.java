public class Game {
    public static void main(String[] args) {
        Farmer farmer = new Farmer();
        farmer.Plow(farmer.getLand()[2][2]);
        farmer.PlantSeed(1,2,2);
        farmer.RenderPlot();
        farmer.WaterPlant(farmer.getLand()[2][2]);
        farmer.WaterPlant(farmer.getLand()[2][2]);
        farmer.getLand()[2][2].getSeed().setHarvestTime(0);
        farmer.HarvestPlant(farmer.getLand()[2][2]);
        farmer.RenderPlot();
        //farmer.shovelPlot(farmer.getLand()[2][2]);
        farmer.displayStats();
    }
}
