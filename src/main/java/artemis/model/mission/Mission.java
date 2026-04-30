package artemis.model.mission;

public abstract class Mission {

    private String name;
    private boolean manned;
    private double distance;
    private double timeMax; // in days
    private double timeMin;
    private double fuelCoefficient;

    public Mission(String name, boolean manned, double distance, double timeMax,double timeMin, double fuelCoefficient){
        this.name = name;
        this.manned = manned;
        this.distance = distance;
        this.timeMax = timeMax;
        this.timeMin = timeMin;
        this.fuelCoefficient = fuelCoefficient;
    }

    public abstract String showDescription(); // explain what is the mission's goal

    public String getName(){return name;}
    public boolean getManned(){return manned;}
    public double getDistance(){return distance;}
    public double getTimeMax(){return timeMax;}
    public double getTimeMin(){return timeMin;}
    public double getFuelCoefficient(){return fuelCoefficient;}

}
