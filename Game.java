public class Game {
    public static void main(String[] args) {
        Farmer farmer = new Farmer();
        farmer.Plow(farmer.getLand()[2][2]);
        farmer.plantSeed(1,2,2);
        farmer.waterPlant(farmer.getLand()[2][2]);
        farmer.waterPlant(farmer.getLand()[2][2]);
        farmer.waterPlant(farmer.getLand()[2][2]);
        farmer.RenderPlot();
        //farmer.shovelPlot(farmer.getLand()[2][2]);
        System.out.println(farmer.toString());
    }
}
