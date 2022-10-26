import Magic.FireMagic;
import Magic.IceMagic;
import Wizard.Apprentice;
import Wizard.Details.BeardType;
import Wizard.Details.HairColor;
import Wizard.Details.Race;
import Wizard.Details.Title;
import Wizard.IWizard;
import Wizard.Wizard;
import Wizard.Archwizard;

public class Main {
    public static void main(String[] args) {
        IWizard nadya = new Apprentice.Builder(Race.Human, "Nadya")
                .withHairColor(HairColor.Brown)
                .withBeardType(BeardType.CleanShave)
                .create();

        nadya.learnMagic(new FireMagic());
        nadya.castMagic();

        IWizard merlin = new Wizard.Builder(Race.Human, "Merlin").create();
        merlin.acceptNewApprentice(nadya);

        IWizard adanadan = new Archwizard.Builder(Race.Elf, "Adanadan")
                .withTitle(Title.ALMIGHTY)
                .withBeardType(BeardType.LongBeard)
                .withHairColor(HairColor.Blonde)
                .create();
        adanadan.acceptNewApprentice(merlin);
        adanadan.learnMagic(new IceMagic());
        adanadan.castMagic();
    }
}