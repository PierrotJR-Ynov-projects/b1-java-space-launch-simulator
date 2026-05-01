package artemis.model.launcher;

public class Ariane5 extends Launcher {

    public Ariane5(){
        super("Ariane 5",false,700,2,20,180);
    }

    @Override
    public void showInformation(){
        System.out.println("Lanceur sélectionné : " + getName());
    }
}
