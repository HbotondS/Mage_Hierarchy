package Mage;

import Magic.IMagic;
import Mage.Details.BeardType;
import Mage.Details.HairColor;
import Mage.Details.Race;

import java.util.ArrayList;
import java.util.List;

public class Mage extends IMage {
    private final List<IMage> apprentices = new ArrayList<>();

    //default constructor
    public Mage() {}

    private Mage(Builder builder) {
        this.race = builder.race;
        this.name = builder.name;
        this.hairColor = builder.hairColor;
        this.beardType = builder.beardType;
    }

    public List<IMage> getApprentices() {
        return apprentices;
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

    public void acceptNewApprentice(IMage newApprentice) {
        this.speak("I, " + this.name + ", started teaching: " + newApprentice.name);
        this.apprentices.add(newApprentice);
    }

    public int getApprenticesNumber() {
        return apprentices.size();
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

        public Mage create() {
            return new Mage(this);
        }
    }
}
