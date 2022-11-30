import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/** 
 * Represents the gui for the plot menu which inherents the JFrame class
 * @author Jordan Chong
 * @author Arvin Tan
*/
public class PlotMenuGui extends JFrame {

    //messages to inform user
    final private String sentence = "Do you want to ",
                         moneySentence = "You don't have enough money",
                         rockSentence = "No rock is this plot",
                         rockSentence2 = "There is a rock in this plot",
                         landSentence = "The plot is already plowed",
                         landSentence2 = "The plot doesn't have a plant",
                         landSentence3 = "The plot already has a plant",
                         landSentence4 = "The plot is not plowed", 
                         plantSentece = "The plant is withered",
                         plantSentence2 = "Invalid location for a fruit tree";

    //button names
    private String[] optionNames = {"Remove Rock", 
                                    "Plow Plot",
                                    "Plant Seed",
                                    "Water Plant",
                                    "Fertilize Plant",
                                    "Shovel Plot",
                                    "View Plant Status",
                                    "Harvest Plant"};

    //possible seeds to be planted
    private String[] seedChoices = {"Turnip",
                                    "Carrot",
                                    "Potato",
                                    "Rose",
                                    "Turnips",
                                    "Sunflower",
                                    "Mango",
                                    "Apple"};

    private JButton exitButton = new JButton("Exit");

    //arraylist of the buttons
    private ArrayList<JButton> plotButton = new ArrayList<JButton>();

    //option panel to allow user selection
    private JPanel optionPanel;

    /**
     * This method is the constructor for the gui
     */
    public PlotMenuGui() {
        super("Plot options");
        setIconImage(new ImageIcon("images/farmer.jpg").getImage());
        setLayout(new BorderLayout());
        setSize(300, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        init();
    }
    
    /**
     * This method creates the gui elements that is inside the plot menu gui
     */
    public void init(){

        //center 
        optionPanel = new JPanel(new GridLayout(8, 1, 2, 5));

        for (int i = 0; i < optionNames.length; i++) {
            JButton button = new JButton();
            button.setName(optionNames[i]);
            button.setText(optionNames[i]);
            button.setFocusPainted(false);
            plotButton.add(button);
            optionPanel.add(button);
        }

        add(optionPanel,BorderLayout.CENTER);
        optionPanel.setBorder(new EmptyBorder(20, 10, 0, 10));

        //South 
        JPanel southPanel = new JPanel();

        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setName("PlotExit");
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
     * This method gets the array list for the options available
     * @return the array list for the options available
     */
    public ArrayList<JButton> getPlotButton() {
        return plotButton;
    }

    /**
     * This method gets the option panel that this class contains
     * @return the option panel
     */
    public JPanel getOptionPanel() {
        return optionPanel;
    }
    
    /**
     * This methods ask the user if they want to do the specific plot action
     * @param butName the name of the button/action being made
     * @return an int if they want to do the action or not
     */
    public int dialogueAnswer(String butName){
        return JOptionPane.showConfirmDialog(null, sentence + butName + "?", butName, JOptionPane.YES_NO_OPTION);
    }

    /**
     * This method notifys the user that an action is made successfully
     * @param operation the name of the action made
     */
    public void SuccessMessage(String operation){
        JOptionPane.showConfirmDialog(null, "Successfully " + operation, "Success", JOptionPane.CLOSED_OPTION);
    }

    /**
     * This method notify a user that they dont have enough money to do a certain action
     */
    public void moneyError(){
        JOptionPane.showConfirmDialog(null, moneySentence, "Money Error",JOptionPane.CLOSED_OPTION);
    }

    /**
     * This method notify a user that there is something wrong related to the plot
     * @param type the error type
     */
    public void landError(int type){
        String message = "";
        if(type == 1)
            message = landSentence;
        else if(type == 2)
            message = landSentence2;
        else if(type == 3)
            message = landSentence3;
        else if(type == 4)
            message = landSentence4;
        JOptionPane.showConfirmDialog(null, message, "Land Error",JOptionPane.CLOSED_OPTION);
    }

    /**
     * This method notify a user that there is something wrong related to the rock of the plot
     * @param type the error type
     */
    public void rockError(int type){
        String message = "";

        if(type == 1)
            message = rockSentence;
        else if(type == 2)
            message = rockSentence2;

        JOptionPane.showConfirmDialog(null, message, "Rock Error",JOptionPane.CLOSED_OPTION);
    }

    /**
     * This method notify a user that the plant is withered
     */
    public void witherError(){
        JOptionPane.showConfirmDialog(null, plantSentece, "Wither Error",JOptionPane.CLOSED_OPTION);
    }

    /**
     * This method notify a user that the tree cant be planted
     */
    public void treeError(){
        JOptionPane.showConfirmDialog(null, plantSentence2, "Tree Error",JOptionPane.CLOSED_OPTION);
    }

    /**
     * This method notify a user of a successful haverst
     * @param name the name of the plant harvested
     * @param quantity how many products of the plant harvested
     * @param total the total coins of the harvest
     */
    public void Harvest(String name, String quantity, String total){
        JOptionPane.showConfirmDialog(null, quantity + " " + name + " has been successfully harvested\nfor a total of " + total + " objectcoins", "Harves Success",JOptionPane.CLOSED_OPTION);
    }

    /**
     * This method asks what seed does the player want to plant
     * @return the seed selected by the user to plant
     */
    public String seedSelection(){
        Object val = JOptionPane.showInputDialog(null,"Choose seed to be planted?", "Seed Choice",JOptionPane.INFORMATION_MESSAGE, null, seedChoices, seedChoices[0]);
        if(val == null)
            return "None";
        return val.toString();
    }

    /**
     * This method changes the image of the button in the main gui
     * @param image the name of the image that is going to be used
     * @param Button the button that is going to be changed
     */
    public void changePlotImage(String image,JButton Button){
        String File = "images/plant/" + image + ".jpg";
        Button.setIcon(new ImageIcon(File));
    }

}
