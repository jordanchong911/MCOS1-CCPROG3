import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Game {

    //function to generate rocks
    public static void generateRocks(Farmer farmer){
        try {
            //files that are possible
            String[] possibleRockFormation = {"Rocks.txt","Rocks2.txt","Rocks3.txt"};
            // since 3 possible
            Random r = new Random();
            int index = r.nextInt(0,possibleRockFormation.length);
            String filename = possibleRockFormation[index];

            File myObj = new File(filename);
            Scanner scan = new Scanner(myObj);
            //loop through every number in file with accordance to the matrix size
            while (scan.hasNextLine()) {
                for (int i=0; i< farmer.getRows(); i++) {
                    String[] line = scan.nextLine().trim().split(" ");
                    for (int j=0; j< line.length; j++)
                        // 1 just means make it a rock
                        if(Integer.parseInt(line[j]) == 1)
                            farmer.getLand()[i][j].setHasRock(true);
                }
            }
            scan.close();
        } 
        // file not found throw error
        catch (FileNotFoundException e) {
            System.out.println("No rock files! No rocks will be used.\n");
        }
    }
    
    public static void main(String[] args) {
        boolean game = true;
        Scanner scan = new Scanner(System.in);
        while(game){
            Farmer farmer = new Farmer();
            generateRocks(farmer);
            farmer.RenderPlot();
            while(farmer.isGameOver() == false){
                // remember to remove stop playing option when game over function is created
                int mainFeatures = -1;
                System.out.println("\nGame Options\n1.)Take care of a lot\n2.)View Stats\n3.)Level up\n4.)View possible levels\n5.)View Plot\n6.)Next Day\n7.)Stop Playing\n");
                while(!(mainFeatures >=1 && mainFeatures <= 7)){
                    System.out.print("Input choice: ");
                    mainFeatures = scan.nextInt();
                }
                switch(mainFeatures){
                    case 1:
                        int xPlot = -1,
                            yPlot = -1, 
                            rows = farmer.getRows(), 
                            col = farmer.getColumns();

                        while(!(xPlot >= 1 && xPlot <= rows) || !(yPlot >= 1 && yPlot <= col)){
                            System.out.print("Enter x-coordinate from 1 to " + rows + ": ");
                            xPlot = scan.nextInt();
                            System.out.print("Enter y-coordinate from 1 to " + col + ": " );
                            yPlot = scan.nextInt();
                        }
                        //subtract 1 since 1,1 is equivalent to 0,0 in our arr
                        xPlot -= 1;
                        yPlot -= 1;
                        Plot plot = farmer.getLand()[xPlot][yPlot];
                        //do plot operations
                        boolean modifyPlot = true;
                        while(modifyPlot){
                            farmer.RenderPlot();
                            int plotMod = -1;
                            int option = 10;
                            //if harvestable
                            String displayed = "\nPlot Options\n1.)Leave plot\n2.)View tools properties\n3.)Remove rock\n4.)Plow plot\n5.)View seed shop\n6.)Plant seed\n7.)Water plant\n8.)Fertilize plant\n9.)Shovel plot\n10.)Plant status";
                            if(plot.getSeed() != null){
                                if(plot.getSeed().isHarvestable()){
                                    displayed += "\n11.)Harvest Plant";
                                    option = 11;
                                }
                            }
                            System.out.println(displayed);
                            while(!(plotMod >=1 && plotMod <= option)){
                                System.out.print("Input Choice: ");
                                plotMod = scan.nextInt();
                            }
                            switch(plotMod){
                                case 1:
                                    modifyPlot= false;
                                    break;
                                case 2:
                                    System.out.println();
                                    for(Tools i : farmer.getTools())
                                        System.out.println(i.toString());
                                    break;
                                case 3:
                                    farmer.RemoveRock(plot);
                                    break;
                                case 4:
                                    farmer.Plow(plot);
                                    break;
                                case 5:
                                    System.out.println();
                                    for(int i = 0; i < farmer.getSeedList().size(); i++)
                                        System.out.println((i+1) + ".)" + farmer.getSeedList().get(i).toString());
                                    break;
                                case 6:
                                    int seedType = -1;
                                    //print seed descriptions
                                    System.out.println("\nSelect Seed:");
                                    for(int i = 0; i < farmer.getSeedList().size(); i++)
                                        System.out.println((i+1) + ".)" + farmer.getSeedList().get(i).getSeedName());
                                    while(!(seedType>= 1 && seedType <= 8)){
                                        System.out.print("Input Choice: ");
                                        seedType = scan.nextInt();
                                    }
                                    farmer.PlantSeed(seedType, xPlot, yPlot);
                                    break;
                                case 7:
                                    farmer.WaterPlant(plot);
                                    break;
                                case 8:
                                    farmer.FertilizePlant(plot);
                                    break;
                                case 9:
                                    farmer.ShovelPlot(plot);
                                    break;
                                case 10:
                                    if(plot.getSeed() == null)
                                        System.out.println("No plant is present");
                                    else
                                        plot.getSeed().plantInfo(farmer);
                                    break;
                                case 11:
                                    farmer.HarvestPlant(plot);
                                    break;
                            }
                        }
                        break;
                    case 2:
                        farmer.displayStats();
                        break;
                    case 3:
                        farmer.nextLevel();
                        break;
                    case 4:
                        for(Title i: farmer.getTitles())
                            System.out.println(i.toString());
                        break;
                    case 5:
                        farmer.RenderPlot();
                        break;
                    case 6:
                        farmer.NextDay();
                        break;
                    case 7:
                        farmer.setGameOver(true);
                        break;
                }

            }
            //ask user to continue playing
            int choice = -1;
            System.out.println("\nStart a new game?\n1.)YES\n2.)NO\n");
            while(!(choice == 1 || choice == 2)){
                System.out.print("Input choice: ");
                choice =scan.nextInt();
            }
            if(choice == 2)
                game = false;
        }
        scan.close();
    }
}
