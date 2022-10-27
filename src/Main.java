import Mage.Apprentice;
import Mage.Details.BeardType;
import Mage.Details.HairColor;
import Mage.Details.Race;
import Mage.Mage;
import Magic.FireMagic;

public class Main {
    public static void main(String[] args) {
        Apprentice nadya = new Apprentice.Builder(Race.Human, "Nadya")
                .withHairColor(HairColor.Brown)
                .withBeardType(BeardType.CleanShave)
                .create();

        nadya.learnMagic(new FireMagic());
        nadya.castMagic();

        Mage merlin = new Mage.Builder(Race.Human, "Merlin")
                .withBeardType(BeardType.LongBeard)
                .withHairColor(HairColor.White)
                .create();
        merlin.acceptNewApprentice(nadya);
    }
}