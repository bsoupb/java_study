package day2.예제1;

import java.math.BigDecimal;

// 결제 처리 상태 확인
// 팩토리를 사용해서 적절한 Payment 구현체를 받아서, 그것으로 결제 로직을 실행
public class PaymentService {
    public void processPayment(PaymentMethod method, BigDecimal amount) {
        Payment payment = PaymentFactory.createPayment(method);
        payment.processPayment(amount);

        PaymentStatus status = payment.getStatus();
    }
}

/*
    실제 비지니스 로직 실행
 */