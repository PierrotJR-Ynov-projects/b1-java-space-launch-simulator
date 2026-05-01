package artemis.model.launcher;

public class SLS extends Launcher {

    public SLS(){
        super("SLS",true,2600,2,130,2000);
    }

    @Override
    public void showInformation(){
        System.out.println("Lanceur sélectionné: "+getName());
    }
}
