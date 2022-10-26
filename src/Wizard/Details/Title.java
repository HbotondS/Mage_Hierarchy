package Wizard.Details;

public enum Title {
    WHITE("The White"),
    TALL("The Tall"),
    ALMIGHTY("The Almighty")
    ;

    private final String text;

    Title(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
