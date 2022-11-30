import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/** 
 * Represents the controller for the shop buttons
 * @author Jordan Chong
 * @author Arvin Tan
*/
public class ShopController implements ActionListener{

    private gameGui gui;

    /**
     * This method is the constructor for the controller
     */
    public ShopController(gameGui gui) {
        this.gui = gui;
        gui.setShopActionListener(this);
    }
    
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton but = (JButton) e.getSource();
        String butName = but.getName();

        seedShopModel seedShopModel = gui.getSeedShop().getSeedShopModel();
        toolShopModel ToolShopModel = gui.getToolShop().getToolShopModel();
        TitleShopModel titleShopModel = gui.getTitleShop().getTitleShopModel();
        
        Farmer farmer = gui.getFarmer();

        //seed shop buttons
        if (butName.equals("seedbutton")) {
            gui.setVisible(false);
            gui.getSeedShop().setVisible(true);
        }
       
        else if(butName.equals("SeedExit")){
            gui.getSeedShop().setVisible(false);
            gui.setVisible(true);
        }

        else if (butName.equals("nextSeed")){
            seedShopModel.nextSeed();
            gui.getSeedShop().UpdateSeedInfo(seedShopModel.getCurrentSeeds());
        }
        
        else if (butName.equals("prevSeed")){
            gui.getSeedShop().getSeedShopModel().previousSeed();
            gui.getSeedShop().UpdateSeedInfo(seedShopModel.getCurrentSeeds());
        }

        //tool shop buttons
        else if(butName.equals("toolbutton")){
            gui.setVisible(false);
            gui.getToolShop().setVisible(true);
        }

        else if (butName.equals("ToolExit")){
            gui.getToolShop().setVisible(false);
            gui.setVisible(true);
        }

        else if (butName.equals("nextTool")){
            gui.getToolShop().getToolShopModel().nextTool();
            gui.getToolShop().UpdateToolInfo(ToolShopModel.getCurrentTools());
        }

        else if (butName.equals("prevTool")){
            gui.getToolShop().getToolShopModel().previousTool();
            gui.getToolShop().UpdateToolInfo(ToolShopModel.getCurrentTools());
        }

        //tool shop buttons
        else if(butName.equals("titlebutton")){
            gui.setVisible(false);
            gui.getTitleShop().setVisible(true);
        }

        else if(butName.equals("TitleExit")){
            gui.getTitleShop().setVisible(false);
            gui.setVisible(true);
        }

        else if (butName.equals("nextTitle")){
            gui.getTitleShop().getTitleShopModel().nextTitle();
            gui.getTitleShop().UpdateTitleInfo(titleShopModel.getCurrentTitles());
        }

        else if (butName.equals("prevTool")){
            gui.getTitleShop().getTitleShopModel().previousTitle();
            gui.getTitleShop().UpdateTitleInfo(titleShopModel.getCurrentTitles());
        }

        // level up 
        else if (butName.equals("Level up")){
            
            String result = farmer.nextLevel(titleShopModel.getTitles());
            int ans = JOptionPane.showConfirmDialog(null, "Do you want to level up to the next title?", butName, JOptionPane.YES_NO_OPTION);
            if(ans == 0){
                if(result.equals("Money"))
                    gui.getPlotGui().moneyError();

                else if(result.equals("No xp"))
                    gui.xpError();

                else{
                    gui.xpSuccess(result);
                    //change gui here
                    gui.changeTitle(titleShopModel.getTitles().get(farmer.getTitleIndex()).getTitleName());
                    gui.changeCoins(farmer.getObjectcoins());
                    gui.changelvl(farmer.getXp());
                }    
            }        
        }

        // next day
        else if (butName.equals("next day")){

            int ans = gui.changeDayDialog();

            if(ans == 0){
                farmer.NextDay(titleShopModel.getTitles(), seedShopModel.getSeed(), ToolShopModel.getTools());
                //change gui here
                gui.changeMatrix();
                gui.changeDayText();
                gui.moveDayDialog(gui.getFarmer().getCurrentDay());
                if(farmer.isGameOver() == true){
                    gui.gameOverMessage();
                    int answer = gui.gameOverDialog();
                    if(answer == 0){
                        gui.dispose();
                        new gameGui();
                    } 
                    else
                        System.exit(0);
                }
            }
        }
    }
}
