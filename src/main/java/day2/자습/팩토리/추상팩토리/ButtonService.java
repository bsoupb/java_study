package day2.자습.팩토리.추상팩토리;

public class ButtonService {
    public String button(Os os) {
        ButtonFactory buttonFactory = getButtonFactory(os);
        return buttonFactory.osButton(os);
    }

    private ButtonFactory getButtonFactory(Os os) {
        if(os == Os.WINDOWS) {
            return new WindowsButtonFactory();
        } else if(os == Os.MAC) {
            return new MacButtonFactory();
        }
        throw new IllegalArgumentException("unsupported os type");
    }
}
