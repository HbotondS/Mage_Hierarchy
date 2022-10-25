package Wizard;

import Magic.IMagic;

public class Apprentice extends IWizard {

    public Apprentice() {
        this.numberOfApprenticeCanHave = 0;
    }

    @Override
    public void learnMagic(IMagic newMagic) {
        this.magic = newMagic;
    }

    @Override
    public void castMagic() {
        this.magic.cast();
    }
}
