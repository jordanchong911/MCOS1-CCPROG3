import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;

public class PlotMenuGui extends JFrame {

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

    private String[] optionNames = {"Remove Rock", 
                                    "Plow Plot",
                                    "Plant Seed",
                                    "Water Plant",
                                    "Fertilize Plant",
                                    "Shovel Plot",
                                    "View Plant Status",
                                    "Harvest Plant"};

    private String[] seedChoices = {"Turnip",
                                    "Carrot",
                                    "Potato",
                                    "Rose",
                                    "Turnips",
                                    "Sunflower",
                                    "Mango",
                                    "Apple"};

    private JButton exitButton = new JButton("Exit");
    private ArrayList<JButton> plotButton = new ArrayList<JButton>();
    private JPanel optionPanel;

    public PlotMenuGui() {
        super("Plot options");
        setLayout(new BorderLayout());
        setSize(300, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        init();
    }
    
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

    public JButton getExitButton() {
        return exitButton;
    }

    public ArrayList<JButton> getPlotButton() {
        return plotButton;
    }

    public JPanel getOptionPanel() {
        return optionPanel;
    }
    
    public int dialogueAnswer(String butName){
        return JOptionPane.showConfirmDialog(null, sentence + butName + "?", butName, JOptionPane.YES_NO_OPTION);
    }

    public void SuccessMessage(String operation){
        JOptionPane.showConfirmDialog(null, "Successfully " + operation, "Success", JOptionPane.CLOSED_OPTION);
    }

    public void moneyError(){
        JOptionPane.showConfirmDialog(null, moneySentence, "Money Error",JOptionPane.CLOSED_OPTION);
    }

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

    public void rockError(int type){
        String message = "";

        if(type == 1)
            message = rockSentence;
        else if(type == 2)
            message = rockSentence2;

        JOptionPane.showConfirmDialog(null, message, "Rock Error",JOptionPane.CLOSED_OPTION);
    }

    public void witherError(){
        JOptionPane.showConfirmDialog(null, plantSentece, "Wither Error",JOptionPane.CLOSED_OPTION);
    }

    public void treeError(){
        JOptionPane.showConfirmDialog(null, plantSentence2, "Tree Error",JOptionPane.CLOSED_OPTION);
    }

    public void Harvest(String name, String quantity, String total){
        String roundedTotal = String.format("%.2f", total);
        JOptionPane.showConfirmDialog(null, quantity + " " + name + " has been successfully harvested\nfor a total of " + roundedTotal + " objectcoins", "Harves Success",JOptionPane.CLOSED_OPTION);
    }

    public String seedSelection(){
        Object val = JOptionPane.showInputDialog(null,"Choose seed to be planted", "Seed Choice",JOptionPane.INFORMATION_MESSAGE, null, seedChoices, seedChoices[0]);
        if(val == null)
            return "None";
        return val.toString();
    }

    public void changePlotImage(String image,JButton Button){
        String File = "images/" + image + ".jpg";
        Button.setIcon(new ImageIcon(File));
    }

}
