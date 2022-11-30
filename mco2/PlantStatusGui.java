import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/** 
 * Represents the gui for the plant status menu which inherents the JFrame class
 * @author Jordan Chong
 * @author Arvin Tan
*/
public class PlantStatusGui extends JFrame {
    
    //attributes being presented
    String[] plantProperties = {"Times Watered(Needs)",
                               "Times Fertilized(Needs)",
                               "Water Bonus Limit",
                               "Fertilizer Bonus Limit",
                               "Harvest Time",
                               "Withered"};

    //default values of the attributes
    private String[] defaultValues = {"0",
                                      "0",
                                      "0",
                                      "0",
                                      "0",
                                      "0"};

    private JButton exitButton = new JButton("Exit");

    //array for information label
    private ArrayList<JTextField> InfoLabels = new ArrayList<JTextField>(); 

    private JLabel plantImage = new JLabel(new ImageIcon("images/takinaScaled.jpg"));

    /**
     * This method is the constructor for the gui
     */
    public PlantStatusGui() {
        super("Plant");
        setIconImage(new ImageIcon("images/farmer.jpg").getImage());
        setLayout(new BorderLayout());
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        init();
    }

    /**
     * This method creates the gui elements that is inside the plant status gui
     */
    public void init(){
        //Center
        JPanel plantInfoPanel = new JPanel(new GridLayout(9, 2, 2, 3));
        JPanel plantMainPanel = new JPanel();
        plantMainPanel.setLayout(new BoxLayout(plantMainPanel, BoxLayout.PAGE_AXIS));
        
        plantImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        plantImage.setBorder(new EmptyBorder(0,0,10,0));

        for (int i = 0; i < plantProperties.length; i++) {
            JLabel plantStat = new JLabel();
            JTextField plantStatInfo = new JTextField();

            plantStat.setText(plantProperties[i]);
            plantStatInfo.setText(defaultValues[i]);
            plantStatInfo.setHorizontalAlignment(JTextField.CENTER);
            
            InfoLabels.add(plantStatInfo);

            plantInfoPanel.add(plantStat);
            plantInfoPanel.add(plantStatInfo);
            
            plantStatInfo.setEditable(false);
        }
        
        plantMainPanel.add(plantImage);
        plantMainPanel.add(plantInfoPanel);
        plantMainPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        
        add(plantMainPanel, BorderLayout.CENTER);

        //west 
        JPanel westPanel = new JPanel(new GridBagLayout());
        westPanel.setBorder(new EmptyBorder(0, 20, 0, 10));
        add(westPanel,BorderLayout.WEST);

        // east 
        JPanel eastPanel = new JPanel(new GridBagLayout());
        eastPanel.setBorder(new EmptyBorder(0, 20, 0, 10));
        add(eastPanel,BorderLayout.EAST);

        //South 
        JPanel southPanel = new JPanel();

        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setName("PlantStatExit");
        exitButton.setFocusPainted(false);

        southPanel.setBorder(new EmptyBorder(20, 50, 10, 50));
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.PAGE_AXIS));
        southPanel.add(exitButton);

        add(southPanel,BorderLayout.SOUTH);
    }

    /**
     * This method gets the exit button for this gui
     * @return the exitbutton for the gui
     */
    public JButton getExitButton() {
        return exitButton;
    }

    /**
     * This method changes what the gui is displaying
     * @param Title the current title of the farmer
     * @param seed the current seed that is displayed
     */
    public void UpdatePlantInfo(Title Title, Seeds seed){
        if(seed != null){
            String File = "images/" + seed.getSeedName() + ".jpg";
            if(seed.isWithered() == true)
                File = "images/witherplant.jpg";
            plantImage.setIcon(new ImageIcon(File));
            
            for(int i = 0; i < plantProperties.length; i++){
                switch(i){
                    case 0:
                        InfoLabels.get(i).setText(seed.getWaterNo()+"("+seed.getWaterNeeds()+")");
                        break;
                    case 1:
                        InfoLabels.get(i).setText(seed.getFertilizerNo()+"("+seed.getFertilizerNeeds()+")");
                        break;
                    case 2:
                        InfoLabels.get(i).setText(Integer.toString(seed.getWaterBonusLimit() + Title.getWaterBonus()));
                        break;
                    case 3:
                        InfoLabels.get(i).setText(Integer.toString(seed.getFertilizerBonusLimit() + Title.getFertilizerBonus()));
                        break;
                    case 4:
                        InfoLabels.get(i).setText(Integer.toString(seed.getHarvestTime()));
                        break;
                    case 5:
                        String result = (seed.isWithered() == true) ? "Yes" : "No";
                        InfoLabels.get(i).setText(result);
                        break;
                }
            }
        }
    }
}
