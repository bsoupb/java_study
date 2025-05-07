package day5.결제시스템;

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentStrategy creditCardPayment = new CreditCardPayment("홍길동", 
                "1234-5678-9812-3456", "123", "12/34");
    
        PaymentProcesser processor = new PaymentProcesser(creditCardPayment);

        System.out.println("========= 신용카드 결제 =========");
        processor.pay(10000);
        
        // 결제방법을 paypal 변경
        System.out.println("========= PayPal 로 결제 변경 =========");
        PaymentStrategy payPalPayment = new PayPalPayment("test@gmail.com", "password");
        processor.pay(10000);
        
        // kakao
        System.out.println("========= Kakao 로 결제 변경 =========");
        PaymentStrategy kakao = new KakaoPayPayment("010-1234-5678", "password");
        processor.setPaymentStrategy(kakao);
        processor.pay(10000);
    }
}
