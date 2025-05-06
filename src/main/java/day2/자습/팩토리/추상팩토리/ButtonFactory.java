package day2.자습.팩토리.추상팩토리;

public abstract class ButtonFactory {
    public final String osButton(Os os) {
        Button button = createButton();
        return button.getTheme();
    }

    protected abstract Button createButton();
}
