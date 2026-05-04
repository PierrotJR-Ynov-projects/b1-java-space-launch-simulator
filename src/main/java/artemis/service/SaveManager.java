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
}