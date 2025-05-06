package day2.자습.팩토리.추상팩토리;

public class MacButton implements Button {

    @Override
    public String getTheme() {
        return "";
    }

    @Override
    public void check() {
        System.out.println("MAC 체크박스 체크");
    }

    @Override
    public void click() {
        System.out.println("MAC 라디오버튼 클릭");
    }
}
