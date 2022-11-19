import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlotController implements ActionListener{
    private gameGui gui;

    //coordinate of x,y
    private int x,y;

    public PlotController(gameGui gui) {
        this.gui = gui;
        gui.setPlotActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton but = (JButton) e.getSource();
        String butName = but.getName();
        
        Farmer farmer = gui.getFarmer();
        ArrayList<Tools> tools = gui.getToolShop().getToolShopModel().getTools();
        ArrayList<Title> titles = gui.getTitleShop().getTitleShopModel().getTitles();
        PlotMenuGui plotGui = gui.getPlotGui();
        int len = plotGui.getPlotButton().size()-1;         
        JButton harvest = plotGui.getPlotButton().get(len);

        //which option yes or no
        int answer;
        //check what warning
        String result,
               seedType;

        //open plot button
        if (butName.equals("Plot")) {
            gui.setVisible(false);
            gui.getPlotGui().setVisible(true);
            x = (int) but.getClientProperty("x");
            y = (int) but.getClientProperty("y");

            Seeds seed = farmer.getLand()[x][y].getSeed();

            //add harvest if plant is harvestable
            if(seed != null){
                if(seed.getHarvestTime() == 0 && seed.isWithered() == false)
                    harvest.setVisible(true);
                else if(seed.isWithered() == true)
                    harvest.setVisible(false);
            } else {
                harvest.setVisible(false);
            }
            plotGui.setVisible(true);
        }

        else if (butName.equals("PlotExit")){
            gui.getPlotGui().setVisible(false);
            gui.setVisible(true);
        }

        else if (butName.equals("Remove Rock")){
            answer = plotGui.dialogueAnswer(butName);
            if(answer == 0){
                result = farmer.RemoveRock(x, y, tools.get(3));
                if(result.equals("Money"))
                    plotGui.moneyError();
                else if(result.equals("Rock"))
                    plotGui.rockError(1);
                else if(result.equals("Success")){
                    plotGui.SuccessMessage(butName);
                    //changeGui here
                    plotGui.changePlotImage("unplowed",gui.getMatrixButtons()[x][y]);
                    gui.changeCoins(farmer.getObjectcoins());
                    gui.changeXp(farmer.getXp());
                }
            }
        }
 
        else if (butName.equals("Plow Plot")){
            answer = plotGui.dialogueAnswer(butName);
            if(answer == 0){
                result = farmer.Plow(x, y, tools.get(0));
                if(result.equals("Rock"))
                    plotGui.rockError(2);
                else if(result.equals("Plowed"))
                    plotGui.landError(1);
                else if(result.equals("Success")){
                    plotGui.SuccessMessage(butName);
                    //changeGui here
                    plotGui.changePlotImage("plowed",gui.getMatrixButtons()[x][y]);
                    gui.changeCoins(farmer.getObjectcoins());
                    gui.changeXp(farmer.getXp());
                }
            }
        }

        else if (butName.equals("Water Plant")){
            answer = plotGui.dialogueAnswer(butName);
            if(answer == 0){
                result = farmer.WaterPlant(x,y, tools.get(1));
                if(result.equals("Withered"))
                    plotGui.witherError();
                else if(result.equals("No plant"))
                    plotGui.landError(2);
                else if(result.equals("Success")){
                    plotGui.SuccessMessage(butName);
                    gui.changeCoins(farmer.getObjectcoins());
                    gui.changeXp(farmer.getXp());
                }
            }
        }

        else if (butName.equals("Fertilize Plant")){
            answer = plotGui.dialogueAnswer(butName);
            if(answer == 0){
                result = farmer.FertilizePlant(x,y, tools.get(2));
                if(result.equals("Withered"))
                    plotGui.witherError();
                else if(result.equals("No plant"))
                    plotGui.landError(2);
                else if(result.equals("Success")){
                    plotGui.SuccessMessage(butName);
                    gui.changeCoins(farmer.getObjectcoins());
                    gui.changeXp(farmer.getXp());
                }
            }
        }

        else if (butName.equals("Shovel Plot")){
            answer = plotGui.dialogueAnswer(butName);
            if(answer == 0){
                result = farmer.ShovelPlot(x,y, tools.get(4));
                if(result.equals("Money"))
                    plotGui.moneyError();
                else if(result.equals("Success")){
                    plotGui.SuccessMessage(butName);

                    if(farmer.getLand()[x][y].isHasRock() == false)
                        plotGui.changePlotImage("unplowed",gui.getMatrixButtons()[x][y]);

                    gui.changeCoins(farmer.getObjectcoins());
                    gui.changeXp(farmer.getXp());
                }
            }
        }

        else if (butName.equals("Plant Seed")){
            seedType = plotGui.seedSelection();
            if(seedType.equals("None") == false){
                result = farmer.PlantSeed(seedType, x, y, titles.get(farmer.getTitleIndex()));

                if(result.equals("Money"))
                    plotGui.moneyError();

                else if(result.equals("Rock"))
                    plotGui.rockError(2);

                else if(result.equals("Not plowed"))
                    plotGui.landError(4);

                else if(result.equals("Occupied"))
                    plotGui.landError(3);

                else if(result.equals("Invalid Tree"))
                    plotGui.treeError();

                else if(result.equals("Success")){
                    plotGui.SuccessMessage(butName + " " + seedType);
                    //changeGui here
                    plotGui.changePlotImage(seedType,gui.getMatrixButtons()[x][y]);
                    gui.changeCoins(farmer.getObjectcoins());
                    gui.changeXp(farmer.getXp());
                }
            }
            
        }

        else if (butName.equals("View Plant Status")){
            Seeds seed = farmer.getLand()[x][y].getSeed();
            if(seed == null)
                plotGui.landError(2);
            else{
                gui.getPlantStatus().UpdatePlantInfo(titles.get(farmer.getTitleIndex()), seed);
                gui.getPlotGui().setVisible(false);
                gui.getPlantStatus().setVisible(true);
            }
        }

        else if (butName.equals("PlantStatExit")){
            gui.getPlotGui().setVisible(true);
            gui.getPlantStatus().setVisible(false);
        }

        else if (butName.equals("Harvest Plant")){
            harvest.setVisible(false);
            String[] description = farmer.HarvestPlant(x, y, titles.get(farmer.getTitleIndex()));
            gui.getPlotGui().Harvest(description[0], description[1], description[2]);
            //changeGui here
            plotGui.changePlotImage("unplowed",gui.getMatrixButtons()[x][y]);
            gui.changeCoins(farmer.getObjectcoins());
            gui.changeXp(farmer.getXp());
        }

    }
    
}