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

    public void simulateLaunch(Rocket rocket, Mission mission){
        System.out.println("▮▮▮ Lancement de la fusée ▮▮▮");
        System.out.println("Fusée selectionnée : " + rocket.getName());
        System.out.println(mission.showDescription());
        System.out.println("Coût total de la mission : " + calculateTotalPrice(rocket) + " M€");

        // check persons
        if (!checkCompability(rocket,mission)){
            System.out.println("Erreur : Il n'est pas possible d'envoyer des personnes dans la capsule choisie ( " + rocket.getCapsule().getName() + " )");
        }

        // check fuel
        double requiredFuel = requiredFuel(rocket, mission);
        System.out.println("Carburant requis : " + requiredFuel + " tonnes.");

        if (requiredFuel > rocket.getLauncher().getMaxFuel()) {
            System.out.println("Erreur: Le lanceur " + rocket.getLauncher().getName() + " n'a pas la capacité de carburant suffisante (" + rocket.getLauncher().getMaxFuel() + " max)");
            return;
        }

        // events
        double riskAlea = 0.05;
        double realRisk = riskAlea - rocket.getLauncher().getBonusFiabilitie();
        double randomRoll = Math.random();

        if (randomRoll > realRisk){
            System.out.println("Echec : La fusée a subi une explosion lors de son décollage. La mission n'a pas pu être réalisée.");
        } else {
            System.out.println("La fusée a atteint son objectif !");
        }
        System.out.println("▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮");
    }
}
