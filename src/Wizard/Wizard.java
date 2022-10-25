package Wizard;

import Magic.IMagic;

public class Wizard extends Apprentice {

    public Wizard() {
        this.numberOfApprenticeCanHave = 1;
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
