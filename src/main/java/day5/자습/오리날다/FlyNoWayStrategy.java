package day5.자습.오리날다;


public class FlyNoWayStrategy implements FlyBehaviorStrategy {
    @Override
    public void fly() {
        System.out.println("날개로 날 수 없는 오리");
    }
}
