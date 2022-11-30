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
 * Represents the gui for the title shop which inherents the JFrame class
 * @author Jordan Chong
 * @author Arvin Tan
*/
public class TitleShopGui extends JFrame {

    //attributes that the gui will show
    private String[] titleProperties = {"Type",
                                       "Level Requirement",
                                       "Earning Bonus per Produce",
                                       "Seed Cost Reduction",
                                       "Water Bonus Increase",
                                       "Fertilizer Bonus Increase",
                                       "Registration Fee"};

    //the defualt values of each attribute
    private String[] titleDefaultValue = {"Farmer",
                                          "0",
                                          "0",
                                          "0",
                                          "0",
                                          "0",
                                          "0.0"};

    //gui option buttons
    private JButton exitButton = new JButton("Exit");
    private JButton prevButton = new JButton("<");
    private JButton nextButton = new JButton(">");

    //the model that the gui will use
    private  TitleShopModel TitleShopModel = new TitleShopModel();

    //text fields that will store information
    private ArrayList<JTextField> InfoLabels = new ArrayList<JTextField>(); 
    
    private JLabel titleImage = new JLabel(new ImageIcon("images/farmer.jpg"));

    /**
     * This method is the constructor for the gui
     */
    public TitleShopGui() {
        super("Titles");
        setIconImage(new ImageIcon("images/farmer.jpg").getImage());
        setLayout(new BorderLayout());
        setSize(500, 550);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        init();
    }

    /**
     * This method creates the gui elements that is inside the title shop gui
     */
    public void init() {
        //Center
        JPanel titleInfoPanel = new JPanel(new GridLayout(9, 2, 2, 3));
        JPanel titleMainPanel = new JPanel();
        titleMainPanel.setLayout(new BoxLayout(titleMainPanel, BoxLayout.PAGE_AXIS));
        
        titleImage.setBorder(new EmptyBorder(10, 0, 10, 0));
        titleImage.setAlignmentX(Component.CENTER_ALIGNMENT);

        for (int i = 0; i < titleProperties.length; i++) {
            JLabel titleStat = new JLabel();
            JTextField titleStatInfo = new JTextField();

            titleStat.setText(titleProperties[i]);
            titleStatInfo.setText(titleDefaultValue[i]);

            titleStatInfo.setHorizontalAlignment(JTextField.CENTER);
            InfoLabels.add(titleStatInfo);

            titleInfoPanel.add(titleStat);
            titleInfoPanel.add(titleStatInfo);
            
            titleStatInfo.setEditable(false);
        }

        titleMainPanel.add(titleImage);
        titleMainPanel.add(titleInfoPanel);
        titleMainPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        
        add(titleMainPanel, BorderLayout.CENTER);

        //west 
        JPanel westPanel = new JPanel(new GridBagLayout());
        prevButton.setName("prevTitle");
        prevButton.setFocusPainted(false);
        westPanel.add(prevButton);
        westPanel.setBorder(new EmptyBorder(0, 20, 0, 10));
        add(westPanel,BorderLayout.WEST);

        // east 
        JPanel eastPanel = new JPanel(new GridBagLayout());
        nextButton.setName("nextTitle");
        nextButton.setFocusPainted(false);
        eastPanel.add(nextButton);
        eastPanel.setBorder(new EmptyBorder(0, 20, 0, 10));
        add(eastPanel,BorderLayout.EAST);

        //South 
        JPanel southPanel = new JPanel();

        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setName("TitleExit");
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
    public TitleShopModel getTitleShopModel() {
        return TitleShopModel;
    }

    /**
     * This method changes the gui displayed with the title info
     * @param title the title object which holds the information
     */
    public void UpdateTitleInfo(Title title){
        
        //change image here
        String File = "images/" + title.getTitleName() + ".jpg";
        titleImage.setIcon(new ImageIcon(File));
        
        for(int i = 0;i < InfoLabels.size(); i++){
            switch(i){
                case 0:
                    InfoLabels.get(i).setText(title.getTitleName());
                    break;
                case 1:
                    InfoLabels.get(i).setText(Float.toString(title.getlevelRequired()));
                    break;
                case 2:
                    InfoLabels.get(i).setText(Float.toString(title.getEarningsBonus()));
                    break;
                case 3:
                    InfoLabels.get(i).setText(Float.toString(title.getSeedCostReduction()));
                    break;
                case 4:
                    InfoLabels.get(i).setText(Integer.toString(title.getWaterBonus()));
                    break;
                case 5:
                    InfoLabels.get(i).setText(Integer.toString(title.getFertilizerBonus()));
                    break;
                case 6:
                    InfoLabels.get(i).setText(Float.toString(title.getRegistrationFee()));
                    break;
            }
        }
    }
    

}
