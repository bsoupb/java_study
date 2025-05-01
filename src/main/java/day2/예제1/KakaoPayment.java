package day2.예제1;

import java.math.BigDecimal;

// 2. 구체적인 결제 구현
public class KakaoPayment implements Payment {
    private PaymentStatus status = PaymentStatus.PENDING;

    @Override
    public void processPayment(BigDecimal amount) {
        status = PaymentStatus.COMPLETED;
    }

    @Override
    public PaymentStatus getStatus() {
        return status;
    }
}
