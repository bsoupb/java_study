package day5.자습.오리날다수정;

public class FlyBehaviorFactory {
    public static FlyBehaviorStrategy getFlyBehaviorStrategy(String flyBehavior) {
        if(flyBehavior == null) {
            throw new IllegalArgumentException("값이 없습니다");
        }

        return switch (flyBehavior.toLowerCase()) {
            case "noway" -> new FlyNoWayStrategy();
            case "wing" -> new FlyWithWingsStrategy();
            case "rocket" -> new FlyWithRocketStrategy();
            default -> throw new IllegalStateException("Invalid flyBehavior: " + flyBehavior);
        };
    }

}
