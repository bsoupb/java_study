package day5.알림시스템;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PushNotification implements NotificationStrategy {
    // 앱 식별자
    // 푸시 서비스 API 키
    // 앱 플랫폼 (IOS, ANDROID)

    private String apiId;
    private String apiKey;
    private String appPlatform;


    @Override
    public boolean sendNotification(String recipient, String subject, String content) {
        System.out.println("push 알림 전송: ");
        System.out.println("앱 ID: " + apiId);
        System.out.println("플랫폼: " + appPlatform);
        System.out.println("수신자: " + recipient);
        System.out.println("제목: " + subject);
        System.out.println("내용: " + content);
        return true;
    }
}
