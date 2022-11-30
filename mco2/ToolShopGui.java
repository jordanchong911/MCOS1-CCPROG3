import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
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
 * Represents the gui for the tool shop gui which inherents the JFrame class
 * @author Jordan Chong
 * @author Arvin Tan
*/
public class ToolShopGui extends JFrame {

    //attributes that the gui will show
    String[] toolProperties = {"Tool Name",
                               "Cost of Usage",
                               "Experience Gain From use"};

    //the defualt values of each attribute
    String[] toolDefaultValue = {"Plow",
                                 "0",
                                 "0.5",
                                 "<html>Converts an unplowed tile to a plowed tile.<br>Can only be performed on an unplowed tile.</html>",};

    //gui option buttons
    private JButton exitButton = new JButton("Exit");
    private JButton prevButton = new JButton("<");
    private JButton nextButton = new JButton(">");

    //text fields that will store information
    private ArrayList<JTextField> InfoLabels = new ArrayList<JTextField>(); 

    //the model that the gui will use
    private toolShopModel ToolShopModel =  new toolShopModel();    

    //the description of the tool or its function 
    private JLabel functionText = new JLabel(toolDefaultValue[3]);
    
    private JLabel toolImage = new JLabel(new ImageIcon("images/plow.jpg"));
    
    /**
     * This method is the constructor for the gui
    */
    public ToolShopGui() {
        super("Tools");
        setIconImage(new ImageIcon("images/farmer.jpg").getImage());
        setLayout(new BorderLayout());
        setSize(500, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        init();
    }
    
    /**
     * This method creates the gui elements that is inside the tool shop gui
    */
    public void init() {
        
        //Center
        JPanel toolInfoPanel = new JPanel(new GridLayout(3, 2, 2, 3));
        JPanel toolMainPanel = new JPanel();
        JPanel textFuntionPanel = new JPanel(new FlowLayout());
        toolMainPanel.setLayout(new BoxLayout(toolMainPanel, BoxLayout.PAGE_AXIS));
        
        toolImage.setBorder(new EmptyBorder(40, 0, 20, 0));
        toolImage.setAlignmentX(Component.CENTER_ALIGNMENT);

        textFuntionPanel.add(functionText);

        for (int i = 0; i < toolProperties.length; i++) {
            JLabel toolStat = new JLabel();
            JTextField toolStatInfo = new JTextField();

            toolStat.setText(toolProperties[i]);
            toolStatInfo.setText(toolDefaultValue[i]);
            toolStatInfo.setHorizontalAlignment(JTextField.CENTER);

            InfoLabels.add(toolStatInfo);

            toolInfoPanel.add(toolStat);
            toolInfoPanel.add(toolStatInfo);
            
            toolStatInfo.setEditable(false);
        }

        toolMainPanel.add(toolImage);
        toolMainPanel.add(textFuntionPanel);
        toolMainPanel.add(toolInfoPanel);
        toolMainPanel.setBorder(new EmptyBorder(10, 0, 20, 0));
        
        add(toolMainPanel, BorderLayout.CENTER);

        //west 
        JPanel westPanel = new JPanel(new GridBagLayout());
        prevButton.setName("prevTool");
        prevButton.setFocusPainted(false);
        westPanel.add(prevButton);
        westPanel.setBorder(new EmptyBorder(0, 20, 0, 10));
        add(westPanel,BorderLayout.WEST);

        // east 
        JPanel eastPanel = new JPanel(new GridBagLayout());
        nextButton.setName("nextTool");
        nextButton.setFocusPainted(false);
        eastPanel.add(nextButton);
        eastPanel.setBorder(new EmptyBorder(0, 20, 0, 10));
        add(eastPanel,BorderLayout.EAST);

         //South 
         JPanel southPanel = new JPanel();

         exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
         exitButton.setName("ToolExit");
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
    public toolShopModel getToolShopModel() {
        return ToolShopModel;
    }

    /**
     * This method changes the gui displayed with the tool info
     * @param tool the tool object which holds the information
     */
    public void UpdateToolInfo(Tools tool){
        
        //change image here
        String File = "images/" + tool.getName() + ".jpg";
        toolImage.setIcon(new ImageIcon(File));

        functionText.setText(tool.getfunction());

        for(int i = 0;i < InfoLabels.size(); i++){
            switch(i){
                case 0:
                    InfoLabels.get(i).setText(tool.getName());
                    break;
                case 1:
                    InfoLabels.get(i).setText(Float.toString(tool.getCost()));
                    break;
                case 2:
                    InfoLabels.get(i).setText(Float.toString(tool.getXpGain()));
                    break;
            }
        }
    }

}
