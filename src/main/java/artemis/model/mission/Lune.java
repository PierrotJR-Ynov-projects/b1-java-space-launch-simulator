package artemis.model.mission;

public class Lune extends Mission{

    public Lune(){
        super("Lune",true,400000,"8 à 10 jours",0.005);
    }

    @Override
    public String showDescription() {
        return "Mission : Réaliser un aller-retour sur la Lune dans le but d'obtenir de la roche lunaire.";
    }
}
