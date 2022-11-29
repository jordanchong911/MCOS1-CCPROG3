import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class gameGui extends JFrame {
    //farmer 
    private Farmer farmer = new Farmer();

    //stats
    private String[] stats = { "Level","xp", "Coins", "Title" };
    private String[] statDetails = { "0", "0" , "100.00", "Farmer"};

    //shops
    private SeedShopGui seedShop = new SeedShopGui();
    private ToolShopGui toolShop = new ToolShopGui();
    private TitleShopGui titleShop = new TitleShopGui();
    private PlotMenuGui plotGui = new PlotMenuGui();
    private PlantStatusGui plantStatus = new PlantStatusGui();

    //buttons
    private JButton dayButton = new JButton();
    private JButton seedImage = new JButton(new ImageIcon("images/seed.jpg"));
    private JButton toolImage = new JButton(new ImageIcon("images/tool.jpg"));
    private JButton titleImage = new JButton(new ImageIcon("images/farmer.jpg"));
    private JButton levelupButton =  new JButton("Rank Up");
    private JButton waterAllButton = new JButton("Water all plants");
    private JButton plowAllButton = new JButton("Plow all plots");
    private JButton harvestAllButton = new JButton("Harvest all plants");
    private JButton[][] matrixButtons = new JButton[farmer.getRows()][farmer.getColumns()];

    //controllers 
    private ShopController shopController;
    private PlotController plotController;

    //array of buttons
    private ArrayList<JButton> ButtonShopArray = new ArrayList<JButton> (Arrays.asList(seedImage,
                                                                                       toolImage,
                                                                                       titleImage,
                                                                                       seedShop.getExitButton(),
                                                                                       toolShop.getExitButton(),
                                                                                       titleShop.getExitButton(),
                                                                                       seedShop.getNextButton(), 
                                                                                       seedShop.getPrevButton(),
                                                                                       toolShop.getNextButton(),
                                                                                       toolShop.getPrevButton(),
                                                                                       titleShop.getNextButton(),
                                                                                       titleShop.getPrevButton(),
                                                                                       levelupButton,
                                                                                       dayButton));

    private ArrayList<JButton> PlotButtonArray = new ArrayList<JButton>(Arrays.asList(plotGui.getExitButton(),
                                                                                      plantStatus.getExitButton(),
                                                                                      waterAllButton,
                                                                                      plowAllButton,
                                                                                      harvestAllButton));

    private ArrayList<JTextField> textFieldArray = new ArrayList<JTextField>();
                                                                                        
    public gameGui() {
        super("Farming simulator");
        setLayout(new BorderLayout());
        setIconImage(new ImageIcon("images/farmer.jpg").getImage());
        setSize(1400, 1000);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        shopController = new ShopController(this);
        plotController = new PlotController(this);
        setVisible(true);
    }

    public void init() {

        //day button
        dayButton.setText("Day 1");
        dayButton.setFont(new Font("Arial", Font.PLAIN, (int) getWidth() / 25));
        dayButton.setName("next day");
        dayButton.setForeground(Color.white);
        dayButton.setFocusPainted(false);
        dayButton.setBackground(Color.decode("#1E3F66"));
        add(dayButton, BorderLayout.NORTH);

        // center
        JPanel matrixPanel = new JPanel();
        matrixPanel.setBorder(new EmptyBorder(20, 100, 20, 20));
        matrixPanel.setLayout(new GridLayout(10, 5, 25, 5));

        for (int i = 0; i < farmer.getRows(); i++)
            for (int j = 0; j < farmer.getColumns(); j++) {

                JButton MatrixButton =  new JButton();
                if(farmer.getLand()[i][j].isHasRock() == true)
                    MatrixButton.setIcon( new ImageIcon("images/rock.jpg"));
                else
                    MatrixButton.setIcon( new ImageIcon("images/unplowed.jpg"));
                MatrixButton.putClientProperty("x", i);
                MatrixButton.putClientProperty("y", j);
                matrixButtons[i][j] = MatrixButton;
                MatrixButton.setName("Plot");
                matrixPanel.add(MatrixButton);
            }

        add(matrixPanel);

        // west
        JPanel westPanel = new JPanel();
        add(westPanel, BorderLayout.WEST);

        // East
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.PAGE_AXIS));
        eastPanel.setBorder(new EmptyBorder(20, 50, 10, 50));

        // seed shop
        seedImage.setPreferredSize(new Dimension(250, 150));
        seedImage.setName("seedbutton");
        eastPanel.add(seedImage);
        eastPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        // tool shop
        toolImage.setPreferredSize(new Dimension(250, 150));
        toolImage.setName("toolbutton");
        eastPanel.add(toolImage);
        eastPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        // title shop
        titleImage.setPreferredSize(new Dimension(250, 150));
        titleImage.setName("titlebutton");
        eastPanel.add(titleImage);

        add(eastPanel, BorderLayout.EAST);

        // south
        JPanel southPanel = new JPanel();
        FlowLayout flow = new FlowLayout();
        flow.setVgap(40);
        southPanel.setLayout(flow);

        for (int i = 0; i < stats.length; i++) {
            JLabel playerStat = new JLabel();
            JTextField playerStatInfo = new JTextField();

            playerStat.setText(stats[i]);
            playerStatInfo.setText(statDetails[i]);

            textFieldArray.add(playerStatInfo);

            southPanel.add(playerStat);
            southPanel.add(playerStatInfo);
            southPanel.add(Box.createRigidArea(new Dimension(10, 0)));
            
            playerStatInfo.setPreferredSize(new Dimension(getWidth() / 11, 20));

            playerStatInfo.putClientProperty("Stat", statDetails[i]);

            playerStat.setForeground(Color.white);
            playerStatInfo.setEditable(false);
        }

        //initialize button properties
        waterAllButton.setFocusPainted(false);
        waterAllButton.setName("Water All");
        waterAllButton.setPreferredSize(new Dimension(150, 40));

        plowAllButton.setFocusPainted(false);
        plowAllButton.setName("Plow All");
        plowAllButton.setPreferredSize(new Dimension(150, 40));

        harvestAllButton.setFocusPainted(false);
        harvestAllButton.setName("Harvest All");
        harvestAllButton.setPreferredSize(new Dimension(150, 40));

        levelupButton.setFocusPainted(false);
        levelupButton.setName("Level up");
        levelupButton.setPreferredSize(new Dimension(150, 40));

        //add buttons to panel
        southPanel.setPreferredSize(new Dimension(500, 100));
        southPanel.add(plowAllButton);
        southPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        southPanel.add(waterAllButton);
        southPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        southPanel.add(harvestAllButton);
        southPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        southPanel.add(levelupButton);

        southPanel.setBackground(Color.decode("#1E3F66"));
        add(southPanel, BorderLayout.SOUTH);
    }

    public void setShopActionListener(ActionListener listener) {
        for (int i = 0; i < ButtonShopArray.size(); i++)
            ButtonShopArray.get(i).addActionListener(listener);
    }

    public void setPlotActionListener(ActionListener listener){

        for (int i = 0; i < PlotButtonArray.size(); i++)
            PlotButtonArray.get(i).addActionListener(listener);

        for (int i = 0; i < getPlotGui().getPlotButton().size(); i++)
            getPlotGui().getPlotButton().get(i).addActionListener(listener);

        for (int i = 0; i < farmer.getRows(); i++)
            for(int j =0; j < farmer.getColumns(); j++)
                matrixButtons[i][j].addActionListener(listener);

    }

    public SeedShopGui getSeedShop() {
        return seedShop;
    }

    public ToolShopGui getToolShop() {
        return toolShop;
    }
    
    public TitleShopGui getTitleShop() {
        return titleShop;
    }

    public PlotMenuGui getPlotGui() {
        return plotGui;
    }

    public Farmer getFarmer(){
        return farmer;
    }

    public PlantStatusGui getPlantStatus() {
        return plantStatus;
    }
    
    public ShopController getShopController() {
        return shopController;
    }

    public PlotController getPlotController() {
        return plotController;
    }
    
    public JButton[][] getMatrixButtons() {
        return matrixButtons;
    }
    
    public void xpError(){
        JOptionPane.showConfirmDialog(null, "You don't have enough xp to level up", "Xp Error",JOptionPane.CLOSED_OPTION);
    }

    public void xpSuccess(String title){
        String message = "You successfully level up to " + title;
        if(title == "Legendary Farmer")
            levelupButton.setVisible(false);
            
        JOptionPane.showConfirmDialog(null, message, "Xp Success",JOptionPane.CLOSED_OPTION);
    }

    public int gameOverDialog(){
        return JOptionPane.showConfirmDialog(null, "Do you want to start a new game?", "New game", JOptionPane.YES_NO_OPTION);
    }

    public int gameOverMessage(){
        return JOptionPane.showConfirmDialog(null, "You lost better luck next time!", "Game over", JOptionPane.CLOSED_OPTION);
    }

    public int changeDayDialog(){
        return JOptionPane.showConfirmDialog(null, "Do you want to move to the next day?", "Next day", JOptionPane.YES_NO_OPTION);
    }

    public void moveDayDialog(int day){
        JOptionPane.showConfirmDialog(null, "Successfully moved to day " + day , "Next day",JOptionPane.CLOSED_OPTION);
    }

    public void waterAllDialog(){
        JOptionPane.showConfirmDialog(null, "Successfully watered all possible plants", "Water plant",JOptionPane.CLOSED_OPTION);
    }

    public void plowAllDialog(){
        JOptionPane.showConfirmDialog(null, "Successfully plowed all possible plots", "Plow plot",JOptionPane.CLOSED_OPTION);
    }

    public void harvestAllDialog(String[] text){
        JOptionPane.showConfirmDialog(null, "Successfully harvested " + text[0] + " crops\nfor a total of " + text[1] + " coins", "Harvest plant",JOptionPane.CLOSED_OPTION);
    }

    public void changeCoins(float coins){
        textFieldArray.get(2).setText(String.format("%.2f", coins));
    }

    public void changelvl(float xp){
        int ans = (int)Math.floor(xp / 100);
        String exp = String.format("%.2f", xp);
        textFieldArray.get(0).setText(Integer.toString(ans));
        textFieldArray.get(1).setText(exp);
    }

    public void changeTitle(String title){
        textFieldArray.get(3).setText(title);
    }

    public void changeMatrix(){
        for (int i = 0; i < farmer.getRows(); i++)
            for (int j = 0; j < farmer.getColumns(); j++) {
                Plot plot = farmer.getLand()[i][j];
                Seeds seed = plot.getSeed();
                String file = "default";

                if(seed != null){
                    if(seed.isWithered() == true)
                        file = "images/wither.jpg";
                    else if(seed.isWithered() == false && seed.getHarvestTime() == 0)
                        file = "images/harvestable/" + seed.getSeedName() + ".jpg";
                }

                else{
                    if(plot.isHasRock() == false && plot.isPlowed())
                        file = "images/plowed.jpg";
                    else if(plot.isHasRock() == false && plot.isPlowed() == false)
                        file = "images/unplowed.jpg";
                }

                if(file.equals("default") == false)
                    matrixButtons[i][j].setIcon( new ImageIcon(file));
            }
    }

    public void changeDayText(){
        dayButton.setText("Day " + farmer.getCurrentDay());
    }

}
