package artemis.model.mission;

public abstract class Mission {

    private String name;
    private boolean manned;
    private double distance;
    private String time;
    private double fuelCoefficient;

    public Mission(String name, boolean manned, double distance, String time, double fuelCoefficient){
        this.name = name;
        this.manned = manned;
        this.distance = distance;
        this.time = time;
        this.fuelCoefficient = fuelCoefficient;
    }

    public abstract String showDescription(); // explain what is the mission's goal

    public String getName(){return name;}
    public boolean getManned(){return manned;}
    public double getDistance(){return distance;}
    public String getTime(){return time;}
    public double getFuelCoefficient(){return fuelCoefficient;}

}
