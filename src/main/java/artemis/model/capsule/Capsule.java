package artemis.model.capsule;

public abstract class Capsule {

    private String name;
    private boolean manned;
    private int maxPerson;
    private int currentPerson;
    private double mass; // in tons
    private double price; // in millions

    public Capsule (String name, boolean manned,int currentPerson, int maxPerson, double mass, double price) {
        this.name = name;
        this.manned = manned;
        this.maxPerson = maxPerson;
        this.currentPerson = currentPerson;
        this.mass = mass;
        this.price = price;
    }

    public void canAddPerson(int nbPerson){
        if (!this.manned){
            System.out.println("Erreur : Cette capsule ne peut accueillir de personne.");
        } if (nbPerson > this.maxPerson ){
            System.out.println("Erreur : la capacité max ( " + this.maxPerson + " personnes ) a été atteinte");
        } else {
            this.currentPerson = nbPerson;
            System.out.println(this.currentPerson + " personnes sont présentes dans la capsule");
        }
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getMass() {
        return mass;
    }

    public boolean isManned() {
        return manned;
    }

    public int getCurrentPerson() {
        return currentPerson;
    }

    public int getMaxPerson() {
        return maxPerson;
    }
}
