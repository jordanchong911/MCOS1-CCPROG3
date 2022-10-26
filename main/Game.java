public class Game {
    public static void main(String[] args) {
        Farmer farmer = new Farmer();
        farmer.Plow(farmer.getLand()[1][1]);
        farmer.PlantSeed(1,1,1);
        farmer.RenderPlot();
        farmer.NextDay();
        farmer.WaterPlant(farmer.getLand()[1][1]);
        farmer.WaterPlant(farmer.getLand()[1][1]);
        farmer.NextDay();
        farmer.HarvestPlant(farmer.getLand()[1][1]);
        farmer.RenderPlot();
        farmer.Plow(farmer.getLand()[1][1]);
        farmer.PlantSeed(1,1,1);
        farmer.PlantSeed(1,1,1);
        farmer.RenderPlot();
        farmer.Plow(farmer.getLand()[3][3]);
        farmer.PlantSeed(7, 3, 3);
        farmer.RenderPlot();
        farmer.displayStats();
    }
}
