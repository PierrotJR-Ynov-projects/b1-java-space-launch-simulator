package artemis.main;

import artemis.model.Rocket;
import artemis.model.booster.*;
import artemis.model.capsule.*;
import artemis.model.launcher.*;
import artemis.model.mission.*;
import artemis.service.LaunchController;
import artemis.service.SaveManager;

import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LaunchController launchController = new LaunchController();
        SaveManager saveManager = new SaveManager();

        boolean running = true;

        while (running) {
            System.out.println("\n▮▮▮ ▮▮▮ ▮▮▮ Menu Principal ▮▮▮ ▮▮▮ ▮▮▮");
            System.out.println("1. Création d'un nouveau lancement");
            System.out.println("2. Historique des missions");
            System.out.println("3. Quitter");
            System.out.print("Choix : ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createNewLaunch(scanner, launchController, saveManager);
                    break;
                case "2":
                    saveManager.readSave();
                    break;
                case "3":
                    System.out.println("Fermeture du simulateur...");
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
        scanner.close();
    }

    private static void createNewLaunch(Scanner scanner, LaunchController launchController, SaveManager saveManager) {
        System.out.println("\n▮▮▮ ▮▮ Création d'un nouveau lancement ▮▮ ▮▮▮");

        // Choose the mission
        System.out.println("\nChoisissez une mission :");
        System.out.println("1. ISS - " + new ISS().showDescription());
        System.out.println("2. Lune - " + new Lune().showDescription());
        System.out.println("3. Mars - " + new Mars().showDescription());
        System.out.println("4. Orbite - " + new Orbite().showDescription());
        System.out.println("5. Pluton - " + new Pluton().showDescription());
        System.out.print("Choix : ");
        String missionChoice = scanner.nextLine();
        Mission mission = null;
        switch (missionChoice) {
            case "1": mission = new ISS(); break;
            case "2": mission = new Lune(); break;
            case "3": mission = new Mars(); break;
            case "4": mission = new Orbite(); break;
            case "5": mission = new Pluton(); break;
            default: 
                System.out.println("Choix invalide. ISS sélectionnée par défaut."); 
                mission = new ISS(); 
                break;
        }

        System.out.println("\n▮▮▮ Requis de la mission sélectionnée ▮▮▮");
        System.out.println("Distance : " + mission.getDistance() + " km");
        System.out.println("Vol habité requis : " + (mission.getManned() ? "Oui" : "Non"));
        System.out.println("Coefficient de carburant : " + mission.getFuelCoefficient());
        System.out.println("▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮");

        System.out.print("\nEntrez le nom de votre fusée : ");
        String rocketName = scanner.nextLine();

        // Choose a launcher
        System.out.println("\nChoisissez un lanceur :");
        System.out.println("1. Ariane 5 (Vol habité : " + (new Ariane5().isManned() ? "Oui" : "Non") + ")");
        System.out.println("2. Falcon 9 (Vol habité : " + (new Falcon9().isManned() ? "Oui" : "Non") + ")");
        System.out.println("3. SLS (Vol habité : " + (new SLS().isManned() ? "Oui" : "Non") + ")");
        System.out.println("4. Saturne V (Vol habité : " + (new SaturneV().isManned() ? "Oui" : "Non") + ")");
        System.out.print("Choix : ");
        String launcherChoice = scanner.nextLine();
        Launcher launcher = null;
        switch (launcherChoice) {
            case "1": launcher = new Ariane5(); break;
            case "2": launcher = new Falcon9(); break;
            case "3": launcher = new SLS(); break;
            case "4": launcher = new SaturneV(); break;
            default: 
                System.out.println("Choix invalide. Ariane 5 sélectionné par défaut."); 
                launcher = new Ariane5(); 
                break;
        }

        System.out.println("\n▮▮▮ Paramètres du lanceur sélectionné (" + launcher.getName() + ") ▮▮▮");
        System.out.println("Charge utile max : " + launcher.getPayLoad() + " t");
        System.out.println("Carburant max : " + launcher.getMaxFuel() + " t");
        System.out.println("Boosters max autorisés : " + launcher.getMaxBooster());
        System.out.println("Prix : " + launcher.getPrice() + " M€");
        System.out.println("Vol habité autorisé : " + (launcher.isManned() ? "Oui" : "Non"));
        System.out.println("▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮");

        // Choose the capsule
        System.out.println("\nChoisissez une capsule :");
        System.out.println("1. Apollo (Vol habité : " + (new Apollo().isManned() ? "Oui" : "Non") + ", Masse : " + new Apollo().getMass() + " t)");
        System.out.println("2. Cargo Dragon (Vol habité : " + (new CargoDragon().isManned() ? "Oui" : "Non") + ", Masse : " + new CargoDragon().getMass() + " t)");
        System.out.println("3. Crew Dragon (Vol habité : " + (new CrewDragon().isManned() ? "Oui" : "Non") + ", Masse : " + new CrewDragon().getMass() + " t)");
        System.out.println("4. Orion (Vol habité : " + (new Orion().isManned() ? "Oui" : "Non") + ", Masse : " + new Orion().getMass() + " t)");
        System.out.print("Choix : ");
        String capsuleChoice = scanner.nextLine();
        Capsule capsule = null;
        switch (capsuleChoice) {
            case "1": capsule = new Apollo(); break;
            case "2": capsule = new CargoDragon(); break;
            case "3": capsule = new CrewDragon(); break;
            case "4": capsule = new Orion(); break;
            default: 
                System.out.println("Choix invalide. Apollo sélectionné par défaut."); 
                capsule = new Apollo(); 
                break;
        }

        System.out.println("\n▮▮▮ Paramètres de la capsule sélectionnée (" + capsule.getName() + ") ▮▮▮");
        System.out.println("Masse : " + capsule.getMass() + " t");
        System.out.println("Prix : " + capsule.getPrice() + " M€");
        System.out.println("Vol habité possible : " + (capsule.isManned() ? "Oui" : "Non"));
        if (capsule.isManned()) {
            System.out.println("Capacité maximale : " + capsule.getMaxPerson() + " personnes");
        }
        System.out.println("▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮");

        if (capsule.isManned()) {
            boolean validCrew = false;
            while (!validCrew) {
                System.out.print("\nEntrez le nombre de personnes à envoyer dans la capsule : ");
                try {
                    int nbPerson = Integer.parseInt(scanner.nextLine());
                    capsule.canAddPerson(nbPerson);
                    if (capsule.getCurrentPerson() == nbPerson) {
                        validCrew = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                }
            }
        }

        Rocket rocket = new Rocket(rocketName, launcher, capsule);

        // Add boosters
        boolean addMoreBoosters = true;
        while (addMoreBoosters && rocket.getBoosters().size() < launcher.getMaxBooster()) {
            System.out.println("\nAjouter un booster ? (Boosters actuels : " + rocket.getBoosters().size() + " / " + launcher.getMaxBooster() + ")");
            System.out.println("1. BE-3 (Masse : " + new BE3().getMass() + " t)");
            System.out.println("2. EAP (Masse : " + new EAP().getMass() + " t)");
            System.out.println("3. SRB (Masse : " + new SRB().getMass() + " t)");
            System.out.println("4. Terminer l'ajout de boosters");
            System.out.print("Choix : ");
            String boosterChoice = scanner.nextLine();
            Booster newBooster = null;
            
            switch (boosterChoice) {
                case "1": newBooster = new BE3(); break;
                case "2": newBooster = new EAP(); break;
                case "3": newBooster = new SRB(); break;
                case "4": addMoreBoosters = false; break;
                default: System.out.println("Choix invalide."); break;
            }

            if (newBooster != null) {
                rocket.addBooster(newBooster);
                System.out.println("\n▮▮▮ Paramètres du booster ajouté (" + newBooster.getName() + ") ▮▮▮");
                System.out.println("Masse : " + newBooster.getMass() + " t");
                System.out.println("Prix : " + newBooster.getPrice() + " M€");
                System.out.println("Puissance supplémentaire : " + newBooster.getExtraBoost() + " kN");
                System.out.println("▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮");
            }
        }
        
        if (rocket.getBoosters().size() >= launcher.getMaxBooster()) {
            System.out.println("Limite de boosters atteinte pour ce lanceur.");
        }

        // Launch
        System.out.println("\nPrêt pour le lancement...");
        launchController.simulateLaunch(rocket, mission);
        double totalCost = launchController.calculateTotalPrice(rocket);

        // Save
        saveManager.saveLaunch(rocket, mission, true, totalCost);
    }
}
