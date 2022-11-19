import java.util.ArrayList;
import java.util.Arrays;

public class toolShopModel {

    private int currentTool = 0;

    final private ArrayList<Tools> tools = new ArrayList<Tools>(
        Arrays.asList(new Tools("Plow", 0, 0.5f,"<html>Converts an unplowed tile to a plowed tile.<br>Can only be performed on an unplowed tile.</html>"),
                      new Tools("Watering Can", 0, 0.5f, "<html>Adds to the total number of tiles a tile/crop has<br> been watered. Can only be performed on a plowed<br> tile with a crop.</html>"),
                      new Tools("Fertilizer", 10, 4, "<html>Adds to the total number of tiles a tile/crop <br>has been applied with fertilizer. Can only<br>be performed on a plowed tile with a crop.</html>"),
                      new Tools("Pickaxe", 50, 15, "<html>Removes a rock from a tile. Can only be<br>applied to tiles with a rock.</html>"),
                      new Tools("Shovel", 7, 2.0f, "<html>Removes a withered plant from a tile. Can be used<br>on any tile/crop with varying effects.</html>")));

    public void nextTool(){
        if(currentTool == tools.size()-1)
            currentTool = 0;
        else
            currentTool++;
    }

    public void previousTool(){
        if(currentTool == 0)
            currentTool = tools.size()-1;
        else
            currentTool--;
    }

    public Tools getCurrentTools(){
        return tools.get(currentTool);
    }

    public ArrayList<Tools> getTools() {
        return tools;
    }

}
