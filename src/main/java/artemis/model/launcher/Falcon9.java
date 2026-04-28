package artemis.model.launcher;

public class Falcon9 extends Launcher {

    public Falcon9 (){
        super("Falcon 9",true,500,0,22,60);
    }

    @Override
    public void showInformation(){
        System.out.println("Lanceur sélectionné : "+getName());
    }
}
