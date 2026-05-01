package artemis.model.mission;

public class Mars extends Mission{

    public Mars(){
        super("Mars",true,225000000,"12 à 18 mois",0.000015);
    }

    @Override
    public String showDescription() {
        return "Mission : Expéditions sur la planète Mars.";
    }
}
