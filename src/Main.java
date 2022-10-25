import Magic.FireMagic;
import Wizard.Apprentice;
import Wizard.Details.BeardType;
import Wizard.Details.HairColor;
import Wizard.Details.Race;
import Wizard.IWizard;
import Wizard.Wizard;
import Wizard.Archwizard;

public class Main {
    public static void main(String[] args) {
        IWizard peti = new Apprentice.Builder(Race.Human, "Peti")
                .withHairColor(HairColor.Brown)
                .withBeardType(BeardType.CleanShave)
                .create();

        peti.learnMagic(new FireMagic());
        peti.castMagic();

        IWizard merlin = new Wizard.Builder(Race.Human, "Merlin").create();
        merlin.acceptNewApprentice(peti);

        IWizard gandalf = new Archwizard();
        gandalf.acceptNewApprentice(merlin);
    }
}