package artemis.model;
import artemis.model.launcher.Launcher;
import artemis.model.capsule.Capsule;
import artemis.model.booster.Booster;
import java.util.ArrayList;
import java.util.List;

public class Rocket{

    private String name;
    private Launcher launcher;
    private Capsule capsule;
    private List<Booster> boosters;

    public Rocket(String name, Launcher launcher, Capsule capsule){
        this.name = name;
        this.launcher = launcher;
        this.capsule = capsule;
        this.boosters = new ArrayList<>();
    }

    public void addBooster(Booster newBooster){
        if ( this.boosters.size() < this.launcher.getMaxBooster()){
            this.boosters.add(newBooster);
            System.out.println("New booster added, total of booster : " + this.boosters.size());
        } else {
            System.out.println("Error on " + this.launcher.getName() + " launcher. It can't accept a new booster. Total of booster : " + this.boosters.size());
        }
    }

    public Launcher getLauncher(){ return launcher; }
    public Capsule getCapsule(){ return capsule; }
    public List<Booster> getBooster(){ return boosters; }


}