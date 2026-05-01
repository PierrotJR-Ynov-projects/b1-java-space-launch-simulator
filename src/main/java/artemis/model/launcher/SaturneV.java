package artemis.model.launcher;

public class SaturneV extends Launcher {

    public SaturneV(){
        super("Saturne V",true,2700,0,140,1500);
    }

    @Override
    public double getBonusFiabilitie(){
        return 0.02;
    }

}
