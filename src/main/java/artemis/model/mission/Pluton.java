package artemis.model.mission;

public class Pluton extends Mission{
    public Pluton(){
        super("Pluton",false,5000000000L,"9 à 10 ans",0.000001);
    }
    @Override
    public String showDescription(){
        return "Mission : Les USA souhaitent lancer une fusée sur Pluton pour prouver qu'il s'agit d'une planète";
    }
}
