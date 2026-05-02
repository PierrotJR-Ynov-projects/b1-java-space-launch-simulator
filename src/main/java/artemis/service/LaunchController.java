package artemis.service;

import artemis.model.Rocket;
import artemis.model.booster.Booster;
import artemis.model.mission.Mission;

public class LaunchController {

    // total cost of a rocket build -> base price + capsule price
    public double calculateTotalPrice(Rocket rocket){
        double totalCost = rocket.getLauncher().getPrice() + rocket.getCapsule().getPrice();

        for (Booster b : rocket.getBoosters()){
            totalCost += b.getPrice();
        }
        return totalCost;
    }

    // idk the launcher mass -> calculate capsule mass + boosters mass
    public double calculateTotalMass (Rocket rocket){
        double totalMass = rocket.getCapsule().getMass();

        for (Booster b : rocket.getBoosters()){
            totalMass += b.getMass();
        }
        return totalMass;
    }

    public double requiredFuel(Rocket rocket, Mission mission){
        double totalMass = calculateTotalMass(rocket);
        // formula given in the pdf
        return totalMass * mission.getDistance() * mission.getFuelCoefficient() / 1000;
    }

    public boolean checkCompability(Rocket rocket, Mission mission){
        if ( mission.getManned() && !rocket.getCapsule().isManned() ){
            return false;
        }
        return true;
    }



}
