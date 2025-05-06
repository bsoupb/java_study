package day2.자습.팩토리.추상팩토리;

public class WindowsButtonFactory extends ButtonFactory {
    @Override
    protected Button createButton() {
        return new WindowsButton();
    }
}
