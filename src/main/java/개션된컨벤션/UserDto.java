package 개션된컨벤션;

import java.util.Objects;

public class UserDto {
    private String username;
    private int age;
    private String phoneNumber;

    public void setUsername(String username) {
        this.username = Objects.requireNonNull(username, "Username cannot be null");
        // 여기서 error 터뜨림
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isValidAge() {
        return age >= 0;
    }
}
