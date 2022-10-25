import Magic.FireMagic;
import Wizard.Apprentice;
import Wizard.IWizard;
import Wizard.Wizard;
import Wizard.Archwizard;

public class Main {
    public static void main(String[] args) {
        IWizard peti = new Apprentice();

        peti.learnMagic(new FireMagic());
        peti.castMagic();

        IWizard merlin = new Wizard();
        merlin.acceptNewApprentice(peti);

        IWizard gandalf = new Archwizard();
        gandalf.acceptNewApprentice(merlin);
    }
}