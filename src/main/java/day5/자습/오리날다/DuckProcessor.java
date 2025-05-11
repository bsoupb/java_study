package day5.자습.오리날다;

import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class DuckProcessor {
    @Setter
    private FlyBehaviorStrategy flyBehaviorStrategy;

    public DuckProcessor(FlyBehaviorStrategy flyBehaviorStrategy) {
        this.flyBehaviorStrategy = flyBehaviorStrategy;
    }

    public FlyBehaviorStrategy getFlyBehaviorStrategy(String flyBehavior) {
        return switch (flyBehavior.toLowerCase()) {
            case "noway" -> new FlyNoWayStrategy();
            case "wing" -> new FlyWithWingsStrategy();
            case "rocket" -> new FlyWithRocketStrategy();
            default -> throw new IllegalStateException("Invalid flyBehavior: " + flyBehavior);
        };
    }

    public String speediness(double speed) {
        if(speed > 10.0) {
            System.out.println("빠른 오리");
            return "빠른 오리";
        } else if(speed > 5.0 && speed < 10.0) {
            System.out.println("보통 오리");
            return "보통 오리";
        } else if(speed > 0.0 && speed < 5.0) {
            System.out.println("느린 오리");
            return "느린 오리";
        } else {
            throw new IllegalArgumentException("속도는 음수일 수 없습니다.");
        }
    }

    public void display(String species) {
        System.out.println("저는 " + species + "입니다.");
    }

    public void process(String flyBehavior) {
        Duck duck = new Duck();

        FlyBehaviorStrategy strategy = getFlyBehaviorStrategy(flyBehavior);
        duck.setFlyBehavior(strategy);
        duck.performFly();
    }
}
