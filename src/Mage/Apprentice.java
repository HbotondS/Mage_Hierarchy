package Mage;

import Magic.IMagic;
import Mage.Details.BeardType;
import Mage.Details.HairColor;
import Mage.Details.Race;

public class Apprentice extends IMage {

    // default constructor
    public Apprentice() {}

    private Apprentice(Builder builder) {
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
        this.speak("I " + this.name + ", trying:");
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
            return new Apprentice(this);
        }
    }
}
