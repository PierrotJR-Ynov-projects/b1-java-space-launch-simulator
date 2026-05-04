package artemis.service;

import artemis.model.Rocket;
import artemis.model.mission.Mission;

import java.io.File;
import java.io.FileWriter;
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
                + "\"fusee\": \"" + rocket.getName() + "\", "
                + "\"mission\": \"" + mission.getClass().getSimpleName() + "\", "
                + "\"statut\": \"" + status + "\", "
                + "\"cout\": " + cost
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
        System.out.println("▮▮▮ ▮▮▮ Lecture de la sauvegarde ▮▮▮ ▮▮▮");

        // check if file exist else after read file
        java.io.File file = new java.io.File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("L'historique est vide. Aucun lancement n'a encore été effectué.");
            System.out.println("▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮");
            return;
        }

        // read file line by line
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(FILE_PATH))) {
            String line;
            int count = 1;

            // while text exist read file
            while ((line = reader.readLine()) != null) {
                System.out.println("Vol " + count + " -> " + line);
                count++;
            }

        } catch (java.io.IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        System.out.println("▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮ ▮▮▮");
    }
}