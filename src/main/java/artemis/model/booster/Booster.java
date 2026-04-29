package artemis.model.booster;

public abstract class Booster {

    private String name;
    private double extraBoost; // in kN
    private double mass; // in tons
    private double price; // in millions of €

    public Booster(String name, double extraBoost, double mass, double price){
        this.name = name;
        this.extraBoost = extraBoost;
        this.mass = mass;
        this.price = price;
    }
}
