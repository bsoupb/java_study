package day5.자습.오리날다;

public class FlyWithRocketStrategy implements FlyBehaviorStrategy {
    @Override
    public void fly() {
        System.out.println("로켓으로 날 수 있는 오리");
    }
}
