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
            int index = r.nextInt(0,2+1);
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
            System.out.println("No rock files! No rocks will be used.");
        }
    }

    public static void main(String[] args) {
        Farmer farmer = new Farmer();
        generateRocks(farmer);
        farmer.RenderPlot();
        farmer.displayStats();
    }
}
