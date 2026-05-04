package artemis.service;

import artemis.model.Rocket;
import artemis.model.mission.Mission;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class SaveManager {

    // data path
    private static final String DIRECTORY_PATH = "data";
    private static final String FILE_PATH = DIRECTORY_PATH + "/save.json";

    // start launch save method
    public void saveLaunch(Rocket rocket, Mission mission, boolean success, double cost) {

        // create a new file if it doesn't exist
        File directory = new File(DIRECTORY_PATH);
        if (!directory.exists()) {
            directory.mkdir();
        }

        // manual creation of the json structure
        String status = success ? "Succès" : "Échec";
        String jsonLine = "{"
                + "fusee:" + rocket.getName() + ", "
                + "mission: " + mission.getClass().getSimpleName() + ", "
                + "statut: " + status + ", "
                + "cout: " + cost
                + "}";

        // saving the file
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(jsonLine + "\n");
            System.out.println("Sauvegarde réussie dans le fichier suivant : " + FILE_PATH);
            // handle errors
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    public void readSave() {
        System.out.println("\n▮▮▮ ▮▮▮ Lecture de la sauvegarde ▮▮▮ ▮▮▮");

        // check if file exist else after read file
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("L'historique est vide. Aucun lancement n'a encore été effectué.");
            System.out.println("▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮\n");
            return;
        }

        // read file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int count = 1;

            // while text exist read file
            while ((line = reader.readLine()) != null) {
                String cleanLine = line.replace("{", "").replace("}", "");
                System.out.println("Vol " + count + " : " + cleanLine);
                count++;
            }

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        System.out.println("▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮\n");
    }
}