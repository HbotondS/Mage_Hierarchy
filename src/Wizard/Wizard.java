package Wizard;

import Magic.IMagic;
import Wizard.Details.BeardType;
import Wizard.Details.HairColor;
import Wizard.Details.Race;

public class Wizard extends Apprentice {

    //default constructor
    public Wizard() {}

    private Wizard(Builder builder) {
        this.numberOfApprenticeCanHave = 1;
        this.race = builder.race;
        this.name = builder.name;
        this.hairColor = builder.hairColor;
        this.beardType = builder.beardType;
    }

    @Override
    public void learnMagic(IMagic newMagic) {
        this.magic = newMagic;
    }

    @Override
    public void castMagic() {
        this.magic.cast();
    }

    public static class Builder {
        private final Race race;
        private final String name;
        private HairColor hairColor;
        private BeardType beardType;

        public Builder(Race race, String name) {
            if (race == null || name == null) {
                throw new IllegalArgumentException("Race and name cannot be null!");
            } else {
                this.race = race;
                this.name = name;
            }
        }

        public Builder withHairColor(HairColor hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public Builder withBeardType(BeardType beardType) {
            this.beardType = beardType;
            return this;
        }

        public Apprentice create() {
            return new Wizard(this);
        }
    }
}
