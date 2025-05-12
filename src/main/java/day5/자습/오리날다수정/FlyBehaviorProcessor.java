package day5.자습.오리날다수정;

public class FlyBehaviorProcessor implements FlyBehavior {

    @Override
    public String speediness(double speed) {
        if(speed > 10.0) {
            System.out.println("빠른 오리");
            return "빠른 오리";
        } else if(speed > 5.0 && speed < 10.0) {
            System.out.println("보통 오리");
            return "보통 오리";
        } else if(speed >= 0.0 && speed < 5.0) {
            System.out.println("느린 오리");
            return "느린 오리";
        } else {
            throw new IllegalArgumentException("속도는 음수일 수 없습니다.");
        }
    }

    @Override
    public void display(String species) {
        System.out.println("저는 " + species + "입니다.");
    }

    @Override
    public void process(String flyBehavior) {
        FlyBehaviorStrategy flyBehaviorStrategy = FlyBehaviorFactory.getFlyBehaviorStrategy(flyBehavior);
        flyBehaviorStrategy.fly();
    }
}
