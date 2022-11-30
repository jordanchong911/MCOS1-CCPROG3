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
 * Represents the gui for the seed shop which inherents the JFrame class
 * @author Jordan Chong
 * @author Arvin Tan
*/
public class SeedShopGui extends JFrame {

    //attributes of the seed to be displayed
    String[] seedProperties = {"Seed Name",
                                "Crop Type",
                                "Harvest Time",
                                "Water Needs(Bonus Limit)",
                                "Fertilizer Needs(Bonus Limit)",
                                "Products Produced",
                                "Seed Cost",
                                "Base Price Per Piece",
                                "Experience yield"};

    //default values of the properties
    String[] seedDefaultValue = {"Turnip",
                                  "Root Crop",
                                  "2",
                                  "1(2)",
                                  "0(1)",
                                  "1-2",
                                  "5",
                                  "6",
                                  "5"};

    //gui option buttons
    private JButton exitButton = new JButton("Exit");
    private JButton prevButton = new JButton("<");
    private JButton nextButton = new JButton(">");

    //text fields that will store information
    private ArrayList<JTextField> InfoLabels = new ArrayList<JTextField>(); 

    //the model that the gui will use
    private seedShopModel SeedShopModel =  new seedShopModel();

    private JLabel seedImage = new JLabel(new ImageIcon("images/turnip.jpg"));

    /**
     * This method is the constructor for the gui
     */
    public SeedShopGui() {
        super("Seeds");
        setIconImage(new ImageIcon("images/farmer.jpg").getImage());
        setLayout(new BorderLayout());
        setSize(500, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        init();
    }

    /**
     * This method creates the gui elements that is inside the seed shop gui
     */
    public void init() {
        
        //Center
        JPanel seedInfoPanel = new JPanel(new GridLayout(9, 2, 2, 3));
        JPanel seedMainPanel = new JPanel();
        seedMainPanel.setLayout(new BoxLayout(seedMainPanel, BoxLayout.PAGE_AXIS));
        
        seedImage.setAlignmentX(Component.CENTER_ALIGNMENT);

        for (int i = 0; i < seedProperties.length; i++) {
            JLabel seedStat = new JLabel();
            JTextField seedStatInfo = new JTextField();

            seedStat.setText(seedProperties[i]);
            seedStatInfo.setText(seedDefaultValue[i]);
            seedStatInfo.setHorizontalAlignment(JTextField.CENTER);
            
            InfoLabels.add(seedStatInfo);

            seedInfoPanel.add(seedStat);
            seedInfoPanel.add(seedStatInfo);
            
            seedStatInfo.setEditable(false);
        }

        seedImage.setBorder(new EmptyBorder(0, 0, 10, 0));
        seedMainPanel.add(seedImage);
        seedMainPanel.add(seedInfoPanel);
        seedMainPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        
        add(seedMainPanel, BorderLayout.CENTER);

        //west 
        JPanel westPanel = new JPanel(new GridBagLayout());
        prevButton.setName("prevSeed");
        prevButton.setFocusPainted(false);
        westPanel.add(prevButton);
        westPanel.setBorder(new EmptyBorder(0, 20, 0, 10));
        add(westPanel,BorderLayout.WEST);

        // east 
        JPanel eastPanel = new JPanel(new GridBagLayout());
        nextButton.setName("nextSeed");
        nextButton.setFocusPainted(false);
        eastPanel.add(nextButton);
        eastPanel.setBorder(new EmptyBorder(0, 20, 0, 10));
        add(eastPanel,BorderLayout.EAST);

        //South 
        JPanel southPanel = new JPanel();

        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setName("SeedExit");
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
     * This method gets the previous button for this gui
     * @return the previous button for the gui
     */
    public JButton getPrevButton() {
        return prevButton;
    }

    /**
     * This method gets the next button for this gui
     * @return the next button for the gui
     */
    public JButton getNextButton() {
        return nextButton;
    }

    /**
     * This method returns the model class of this gui
     * @return model class of this gui
     */
    public seedShopModel getSeedShopModel() {
        return SeedShopModel;
    }
    
    /**
     * This method changes the gui displayed with the seed info
     * @param seed the seed object which holds the information
     */
    public void UpdateSeedInfo(Seeds seed){
        
        //change image here
        String File = "images/" + seed.getSeedName() + ".jpg";
        seedImage.setIcon(new ImageIcon(File));

        for(int i = 0;i < InfoLabels.size(); i++){
            switch(i){
                case 0:
                    InfoLabels.get(i).setText(seed.getSeedName());
                    break;
                case 1:
                    InfoLabels.get(i).setText(seed.getCropType());
                    break;
                case 2:
                    InfoLabels.get(i).setText(Integer.toString(seed.getHarvestTime()));
                    break;
                case 3:
                    InfoLabels.get(i).setText(Integer.toString(seed.getWaterNeeds()) + "(" + Integer.toString(seed.getWaterBonusLimit()) + ")");
                    break;
                case 4:
                    InfoLabels.get(i).setText(Integer.toString(seed.getFertilizerNeeds()) + "(" + Integer.toString(seed.getFertilizerBonusLimit()) + ")");
                    break;
                case 5:
                    String mini = Integer.toString(seed.getProductsMin());
                    String maxi = Integer.toString(seed.getProductsMax());
                    if(seed.getProductsMax() == seed.getProductsMin())
                        InfoLabels.get(i).setText(mini);
                    else
                        InfoLabels.get(i).setText(mini + "-" + maxi);
                    break;
                case 6:
                    InfoLabels.get(i).setText(Float.toString(seed.getSeedCost()));
                    break;
                case 7:
                    InfoLabels.get(i).setText(Float.toString(seed.getBasePrice()));
                    break;
                case 8:
                    InfoLabels.get(i).setText(Float.toString(seed.getXpYield()));
                    break;
            }
        }
    }

}
