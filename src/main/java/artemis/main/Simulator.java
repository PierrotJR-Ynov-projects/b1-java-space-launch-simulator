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

        // Choose the mission FIRST
        System.out.println("\nChoisissez une mission :");
        System.out.println("1. ISS (Habité : Non) - " + new ISS().showDescription());
        System.out.println("2. Lune (Habité : Oui) - " + new Lune().showDescription());
        System.out.println("3. Mars (Habité : Oui) - " + new Mars().showDescription());
        System.out.println("4. Orbite (Habité : Non) - " + new Orbite().showDescription());
        System.out.println("5. Pluton (Habité : Non) - " + new Pluton().showDescription());
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

        System.out.println("\n--- Configuration de la fusée pour la mission : " + mission.getName() + " ---");
        System.out.print("Entrez le nom de votre fusée : ");
        String rocketName = scanner.nextLine();

        // Choose a launcher
        System.out.println("\nChoisissez un lanceur :");
        System.out.println("1. Ariane 5 (Max boosters : 2, Fuel : 700t)");
        System.out.println("2. Falcon 9 (Max boosters : 0, Fuel : 500t)");
        System.out.println("3. SLS (Max boosters : 4, Fuel : 2500t)");
        System.out.println("4. Saturne V (Max boosters : 0, Fuel : 3000t)");
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

        // Choose the capsule
        System.out.println("\nChoisissez une capsule :");
        System.out.println("1. Apollo (Habité, Capacité : 3 pers, Masse : 5.6t)");
        System.out.println("2. Cargo Dragon (Non-habité, Masse : 4.2t)");
        System.out.println("3. Crew Dragon (Habité, Capacité : 7 pers, Masse : 6.3t)");
        System.out.println("4. Orion (Habité, Capacité : 4 pers, Masse : 10.4t)");
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

        Rocket rocket = new Rocket(rocketName, launcher, capsule);

        // Add boosters
        boolean addMoreBoosters = true;
        while (addMoreBoosters && rocket.getBoosters().size() < launcher.getMaxBooster()) {
            System.out.println("\nAjouter un booster ? (Boosters actuels : " + rocket.getBoosters().size() + " / " + launcher.getMaxBooster() + ")");
            System.out.println("1. BE-3 (Boost : 490kN, Masse : 20t)");
            System.out.println("2. EAP (Boost : 6470kN, Masse : 270t)");
            System.out.println("3. SRB (Boost : 12500kN, Masse : 590t)");
            System.out.println("4. Terminer l'ajout de boosters");
            System.out.print("Choix : ");
            String boosterChoice = scanner.nextLine();
            
            switch (boosterChoice) {
                case "1": rocket.addBooster(new BE3()); break;
                case "2": rocket.addBooster(new EAP()); break;
                case "3": rocket.addBooster(new SRB()); break;
                case "4": addMoreBoosters = false; break;
                default: System.out.println("Choix invalide."); break;
            }
        }
        
        if (rocket.getBoosters().size() >= launcher.getMaxBooster() && launcher.getMaxBooster() > 0) {
            System.out.println("Limite de boosters atteinte pour ce lanceur.");
        }

        // Launch
        System.out.println("\nPrêt pour le lancement...");
        boolean success = launchController.simulateLaunch(rocket, mission);
        double totalCost = launchController.calculateTotalPrice(rocket);

        // Save
        saveManager.saveLaunch(rocket, mission, success, totalCost);


    }
}
