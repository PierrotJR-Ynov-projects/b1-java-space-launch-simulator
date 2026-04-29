package artemis.model.booster;

public abstract class Booster {

    private String name;
    private double extraBoost;
    private double mass;
    private double price;

    public Booster(String name, double extraBoost, double mass, double price){
        this.name = name;
        this.extraBoost = extraBoost;
        this.mass = mass;
        this.price = price;
    }
}
