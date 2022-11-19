import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;

public class ToolShopGui extends JFrame {

    String[] toolProperties = {"Tool Name",
                               "Cost of Usage",
                               "Experience Gain From use"};

    String[] toolDefaultValue = {"Plow",
                                 "0",
                                 "0.5",
                                 "<html>Converts an unplowed tile to a plowed tile.<br>Can only be performed on an unplowed tile.</html>",};

    private JButton exitButton = new JButton("Exit");
    private JButton prevButton = new JButton("<");
    private JButton nextButton = new JButton(">");
    private ArrayList<JTextField> InfoLabels = new ArrayList<JTextField>(); 
    private toolShopModel ToolShopModel =  new toolShopModel();    
    private JLabel functionText = new JLabel(toolDefaultValue[3]);
    private JLabel toolImage = new JLabel(new ImageIcon("images/plow.jpg"));
    
    public ToolShopGui() {
        super("Tools");
        setLayout(new BorderLayout());
        setSize(500, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        init();
    }
    
    public void init() {
        
        //Center
        JPanel toolInfoPanel = new JPanel(new GridLayout(3, 2, 2, 3));
        JPanel toolMainPanel = new JPanel();
        JPanel textFuntionPanel = new JPanel(new FlowLayout());
        toolMainPanel.setLayout(new BoxLayout(toolMainPanel, BoxLayout.PAGE_AXIS));
        
        toolImage.setBorder(new EmptyBorder(50, 0, 10, 0));
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
        toolMainPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        
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

    public JButton getExitButton() {
        return exitButton;
    }
    public JButton getPrevButton() {
        return prevButton;
    }
    public JButton getNextButton() {
        return nextButton;
    }
    public toolShopModel getToolShopModel() {
        return ToolShopModel;
    }

    public void UpdateToolInfo(Tools tool){
        
        //change image here
        String File = "images/" + tool.getName() + ".jpg";
        toolImage.setIcon(new ImageIcon(File));

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
