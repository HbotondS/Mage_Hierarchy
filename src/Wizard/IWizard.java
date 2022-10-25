package Wizard;

import Magic.IMagic;

import java.util.ArrayList;
import java.util.List;

public abstract class IWizard {
    protected int numberOfApprenticeCanHave;
    protected IMagic magic;
    protected final List<IWizard> apprentices = new ArrayList<>();

    public void acceptNewApprentice(IWizard newApprentice) {
        if (this.getApprenticesNumber() < numberOfApprenticeCanHave) {
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
