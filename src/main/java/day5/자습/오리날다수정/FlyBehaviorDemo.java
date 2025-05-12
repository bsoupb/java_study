package day5.자습.오리날다수정;


public class FlyBehaviorDemo {
    public static void main(String[] args) {
        FlyBehaviorProcessor processor = new FlyBehaviorProcessor();

        // 날지 못하는 오리
        System.out.println("=== 날지 못하는 오리 ===");
        processor.process("noway");
        processor.speediness(1.2);
        processor.display("펭귄");

        // 날개로 나는 오리
        System.out.println("=== 날개로 나는 오리 ===");
        processor.process("wing");
        processor.speediness(5.5);
        processor.display("흰오리");

        // 로켓으로 나는 오리
        System.out.println("=== 로켓으로 나는 오리 ===");
        processor.process("rocket");
        processor.speediness(12.0);
        processor.display("노란오리");
    }
}
