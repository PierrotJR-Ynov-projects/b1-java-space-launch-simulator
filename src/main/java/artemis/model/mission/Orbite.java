package artemis.model.mission;

public class Orbite extends Mission{

    public Orbite(){
        super("Orbite terrestre",false,400,"Quelques heures",1);
    }

    @Override
    public String showDescription() {
        return "Mission : Envoie d'une fusée hors de l'orbite terrestre.";
    }
}
