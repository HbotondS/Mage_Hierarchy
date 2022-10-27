package Mage;

import Mage.Details.BeardType;
import Mage.Details.HairColor;
import Mage.Details.Race;
import Magic.IMagic;

public abstract class IMage {
    protected Race race;
    protected String name;
    protected HairColor hairColor;
    protected BeardType beardType;
    protected IMagic magic;

    public void speak(String speech) {
        System.out.println(speech);
    }

    public abstract void learnMagic(IMagic newMagic);
    public abstract void castMagic();

}
