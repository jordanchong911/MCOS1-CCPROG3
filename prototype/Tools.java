public class Tools {
    private String name;
    private float cost;
    private float xpGain;

    public Tools(String name, float cost, float xpGain) {
        this.name = name;
        this.cost = cost;
        this.xpGain = xpGain;
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

}

