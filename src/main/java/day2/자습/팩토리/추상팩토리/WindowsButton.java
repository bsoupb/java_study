package day2.자습.팩토리.추상팩토리;

public class WindowsButton implements Button {
    @Override
    public String getTheme() {
        return "";
    }

    @Override
    public void check() {
        System.out.println("Windows 체크박스 체크");
    }

    @Override
    public void click() {
        System.out.println("Windows 라디오 버튼 클릭");
    }
}
