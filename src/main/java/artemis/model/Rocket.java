package artemis.model;

import artemis.model.booster.Booster;
import artemis.model.launcher.Launcher;
import artemis.model.capsule.Capsule;

import java.util.ArrayList;
import java.util.List;

public class Rocket {
    private String name;
    private Launcher launcher;
    private Capsule capsule;
    private List<Booster> booster;

    public Rocket(String name, Launcher launcher, Capsule capsule) {
        this.name = name;
        this.launcher = launcher;
        this.capsule = capsule;
        this.booster = new ArrayList<>();
    }

    public void addBooster(Booster newBooster){
        if ( this.booster.size() < this.launcher.getMaxBooster() ){
            this.booster.add(newBooster);
        } else {
            System.out.println("Erreur : le lanceur" + this.launcher.getName() + " a atteint sa limite de " + this.launcher.getMaxBooster() + " boosters. Total de booster(s) : " + this.booster.size());
        }
    }

    // getters
    public String getName() { return name; }
    public Launcher getLauncher() { return launcher; }
    public Capsule getCapsule() { return capsule; }
    public List<Booster> getBoosters() { return booster; }
}