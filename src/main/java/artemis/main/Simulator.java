package artemis.main;

import artemis.model.Rocket;
import artemis.model.booster.*;
import artemis.model.capsule.*;
import artemis.model.launcher.*;
import artemis.model.mission.*;
import artemis.service.LaunchController;
import artemis.service.SaveManager;

import java.util.ArrayList;
import java.util.List;
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

        // 1. Choose the mission
        List<Mission> missions = List.of(new ISS(), new Lune(), new Mars(), new Orbite(), new Pluton());
        System.out.println("\nChoisissez une mission :");
        for (int i = 0; i < missions.size(); i++) {
            Mission m = missions.get(i);
            String mannedStatus = m.getManned() ? "Oui" : "Non";
            System.out.println((i + 1) + ". " + m.getName() + " (Habité : " + mannedStatus + ") - " + m.showDescription());
        }
        int missionIdx = readInt(scanner, 1, missions.size()) - 1;
        Mission mission = missions.get(missionIdx);

        System.out.println("\n--- Configuration de la fusée pour la mission : " + mission.getName() + " ---");
        System.out.print("Entrez le nom de votre fusée : ");
        String rocketName = scanner.nextLine();

        // 2. Choose a launcher
        List<Launcher> launchers = List.of(new Ariane5(), new Falcon9(), new SLS(), new SaturneV());
        System.out.println("\nChoisissez un lanceur :");
        for (int i = 0; i < launchers.size(); i++) {
            Launcher l = launchers.get(i);
            System.out.println((i + 1) + ". " + l.getName() + " (Max boosters : " + l.getMaxBooster() + ", Fuel : " + l.getMaxFuel() + "t, Payload : " + l.getPayLoad() + "t)");
        }
        int launcherIdx = readInt(scanner, 1, launchers.size()) - 1;
        Launcher launcher = launchers.get(launcherIdx);

        // 3. Choose the capsule
        List<Capsule> capsules = List.of(new Apollo(), new CargoDragon(), new CrewDragon(), new Orion());
        System.out.println("\nChoisissez une capsule :");
        for (int i = 0; i < capsules.size(); i++) {
            Capsule c = capsules.get(i);
            String type = c.isManned() ? "Habité (Max : " + c.getCurrentPerson() + "/" + (c.isManned() ? "3-7" : "0") + ")" : "Cargo";
            // Note: I'll use a generic display since max capacity is hidden in subclasses usually, 
            // but I'll use isManned and mass which are in the base class.
            System.out.println((i + 1) + ". " + c.getName() + " (" + (c.isManned() ? "Habité" : "Cargo") + ", Masse : " + c.getMass() + "t)");
        }
        int capsuleIdx = readInt(scanner, 1, capsules.size()) - 1;
        Capsule capsule = capsules.get(capsuleIdx);

        // 4. Passenger selection (Step 1)
        if (capsule.isManned()) {
            System.out.print("Combien de passagers souhaitez-vous embarquer ? (Max : " + getMaxPersons(capsule) + ") : ");
            int nbPassagers = readInt(scanner, 0, getMaxPersons(capsule));
            capsule.canAddPerson(nbPassagers);
        }

        Rocket rocket = new Rocket(rocketName, launcher, capsule);

        // 5. Add boosters
        List<Booster> availableBoosters = List.of(new BE3(), new EAP(), new SRB());
        boolean addMoreBoosters = true;
        while (addMoreBoosters && rocket.getBoosters().size() < launcher.getMaxBooster()) {
            System.out.println("\nAjouter un booster ? (Boosters actuels : " + rocket.getBoosters().size() + " / " + launcher.getMaxBooster() + ")");
            for (int i = 0; i < availableBoosters.size(); i++) {
                Booster b = availableBoosters.get(i);
                System.out.println((i + 1) + ". " + b.getName() + " (Poussée : " + b.getExtraBoost() + "kN, Masse : " + b.getMass() + "t)");
            }
            System.out.println((availableBoosters.size() + 1) + ". Terminer l'ajout de boosters");
            
            int boosterChoice = readInt(scanner, 1, availableBoosters.size() + 1);
            if (boosterChoice <= availableBoosters.size()) {
                // Create a NEW instance of the booster
                Booster selected = availableBoosters.get(boosterChoice - 1);
                try {
                    rocket.addBooster(selected.getClass().getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    System.out.println("Erreur lors de l'ajout du booster.");
                }
            } else {
                addMoreBoosters = false;
            }
        }

        // 6. Launch
        System.out.println("\nPrêt pour le lancement...");
        boolean success = launchController.simulateLaunch(rocket, mission);
        double totalCost = launchController.calculateTotalPrice(rocket);

        // 7. Save
        saveManager.saveLaunch(rocket, mission, success, totalCost);
    }

    // Helper for safe integer input (Step 3)
    private static int readInt(Scanner scanner, int min, int max) {
        while (true) {
            try {
                System.out.print("Votre choix : ");
                int val = Integer.parseInt(scanner.nextLine());
                if (val >= min && val <= max) return val;
                System.out.println("Veuillez choisir un nombre entre " + min + " et " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez saisir un nombre.");
            }
        }
    }

    // Helper to get max persons (since it's private in Capsule but we can't change it yet)
    // For now, I'll use a simple mapping or just accept that the Capsule class needs a getter for maxPerson
    private static int getMaxPersons(Capsule c) {
        if (c instanceof Apollo) return 3;
        if (c instanceof CrewDragon) return 7;
        if (c instanceof Orion) return 4;
        return 0;
    }
}
