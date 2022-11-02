import Mage.Apprentice;
import Mage.Details.BeardType;
import Mage.Details.HairColor;
import Mage.Details.Race;
import Mage.IMage;
import Mage.Mage;
import Magic.FireMagic;

import java.util.Iterator;

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

        Apprentice harry = new Apprentice.Builder(Race.Human, "Harry Potter")
                .withHairColor(HairColor.Black)
                .withBeardType(BeardType.CleanShave).create();
        Apprentice ron = new Apprentice.Builder(Race.Human, "Ron Weasly")
                .withBeardType(BeardType.CleanShave)
                .withHairColor(HairColor.Red).create();
        Apprentice draco = new Apprentice.Builder(Race.Human, "Draco Malfoy")
                .withBeardType(BeardType.CleanShave)
                .withHairColor(HairColor.Blonde).create();
        Mage snape = new Mage.Builder(Race.Human, "Severus Snape")
                .withBeardType(BeardType.CleanShave)
                .withHairColor(HairColor.Black).create();
        snape.acceptNewApprentice(draco);
        Mage dumbledore = new Mage.Builder(Race.Human, "Albus Dumbledore")
                .withBeardType(BeardType.LongBeard)
                .withHairColor(HairColor.White).create();
        dumbledore.acceptNewApprentice(harry);
        dumbledore.acceptNewApprentice(snape);
        dumbledore.acceptNewApprentice(ron);

        merlin.acceptNewApprentice(dumbledore);

        StringBuilder buffer = new StringBuilder();
        printHierarchy(buffer, merlin, "", "");
        System.out.println(buffer );
    }
    private static void printHierarchy(StringBuilder buffer, IMage mage, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(mage.getName())
                .append(" (")
                .append(mage.getClass().getSimpleName())
                .append(")");
        buffer.append('\n');
        if (mage instanceof Mage) {
            for (Iterator<IMage> it = ((Mage) mage).getApprentices().iterator(); it.hasNext();) {
                IMage next = it.next();
                if (it.hasNext()) {
                    printHierarchy(buffer, next, childrenPrefix + "├── ", childrenPrefix + "│   ");
                } else {
                    printHierarchy(buffer, next, childrenPrefix + "└── ", childrenPrefix + "    ");
                }
            }
        }
    }
}