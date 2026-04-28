package artemis.model.launcher;

public class Ariane5 extends Launcher {

    // constructor of ariane5
    public Ariane5() {
        super("Ariane5",false,0,700,2,20,180);
    }

    @Override
    public void showInformation(){
        System.out.println("Lanceur : " + this.getName() + " selectionné");
    }
}