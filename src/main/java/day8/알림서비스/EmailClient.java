package day8.알림서비스;

// 이메일을 보내주는 클라이언트 (메일 서버)
public class EmailClient {
    public void sendEmail(String mail, String message) {
        System.out.println("Email sent to " + mail + " with Message" + message);
    }
}
