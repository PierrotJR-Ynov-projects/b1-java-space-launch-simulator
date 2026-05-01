package artemis.model.mission;

public class ISS extends Mission{

    public ISS(){
        super("ISS",true,400,"12h à quelques jours",1.2);
    }

    @Override
    public String showDescription() {
        return "Mission : Envoyer des ravitaillements sur l'ISS";
    }
}
