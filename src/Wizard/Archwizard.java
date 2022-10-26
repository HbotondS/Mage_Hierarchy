package Wizard;

import Wizard.Details.BeardType;
import Wizard.Details.HairColor;
import Wizard.Details.Race;
import Wizard.Details.Title;

public class Archwizard extends Wizard {
    private Title title;

    // default constructor
    public Archwizard() {}

    private Archwizard (Builder builder) {
        this.numberOfApprenticeCanHave = 5;
        this.race = builder.race;
        this.name = builder.name;
        this.hairColor = builder.hairColor;
        this.beardType = builder.beardType;
        this.title = builder.title;
    }

    @Override
    public void castMagic() {
        this.speak("I " + this.name + ", " + this.title +", going to use: ");
        this.magic.cast();
    }

    public static class Builder {
        private final Race race;
        private final String name;
        private HairColor hairColor;
        private BeardType beardType;
        private Title title;

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

        public Builder withTitle(Title title) {
            this.title = title;
            return this;
        }

        public Archwizard create() {
            return new Archwizard(this);
        }
    }
}
