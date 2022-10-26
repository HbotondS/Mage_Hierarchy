package Wizard;

import Magic.IMagic;
import Wizard.Details.BeardType;
import Wizard.Details.HairColor;
import Wizard.Details.Race;

import java.util.ArrayList;
import java.util.List;

public abstract class IWizard {
    protected Race race;
    protected String name;
    protected HairColor hairColor;
    protected BeardType beardType;
    protected int numberOfApprenticeCanHave;
    protected IMagic magic;
    protected final List<IWizard> apprentices = new ArrayList<>();

    public void acceptNewApprentice(IWizard newApprentice) {
        if (this.getApprenticesNumber() < numberOfApprenticeCanHave) {
            this.speak("I, " + this.name + ", started teaching: " + newApprentice.name);
            this.apprentices.add(newApprentice);
        } else {
            this.speak("I cannot have more apprentice.");
        }
    }

    public int getApprenticesNumber() {
        return apprentices.size();
    }

    public void speak(String speech) {
        System.out.println(speech);
    }

    public abstract void learnMagic(IMagic newMagic);
    public abstract void castMagic();

}
