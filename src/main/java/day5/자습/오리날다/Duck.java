package day5.자습.오리날다;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Duck {
    private String name;
    private String species;
    private String habitat;
    private String flyBehavior;
    private double speed;
    
    private FlyBehaviorStrategy flyBehaviorStrategy;

    public Duck() {

    }

    public void setFlyBehavior(FlyBehaviorStrategy flyBehaviorStrategy) {
        this.flyBehaviorStrategy = flyBehaviorStrategy;
    }
    
    public void performFly() {
        if(flyBehaviorStrategy != null) {
            flyBehaviorStrategy.fly();
        } else {
            System.out.println("날 수 있는 전략이 설정되지 않았습니다");
        }
    }

}
