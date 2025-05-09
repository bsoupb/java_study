package day2.예제1;

import java.math.BigDecimal;

// 2. 구체적인 결제 구현
public class CreditCardPayment implements Payment {
    private PaymentStatus status = PaymentStatus.PENDING;
    @Override
    public void processPayment(BigDecimal amount) {
        // 신용카드 결제 로직
        status = PaymentStatus.COMPLETED;
    }

    @Override
    public PaymentStatus getStatus() {
        return status;
    }
}
