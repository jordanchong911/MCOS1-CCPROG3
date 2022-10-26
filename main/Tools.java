public class Tools {
    private String name;
    private float cost;
    private float xpGain;
    private String function;

    public Tools(String name, float cost, float xpGain, String function) {
        this.name = name;
        this.cost = cost;
        this.xpGain = xpGain;
        this.function = function;
    }

    public String getName() {
        return name;
    }
    
    public float getCost() {
        return cost;
    }

    public float getXpGain() {
        return xpGain;
    }

    public String getfunction() {
        return function;
    }

    @Override
    public String toString() {
        return "Tool Name " + name + "\nCost " + cost + "\nXp gain " + xpGain + "\nfunction\n" + function + "\n";
    }

}

