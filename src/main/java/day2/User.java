package day2;

public class User {
    // 불변객체
    private final String firstName;     // 필수
    private final String lastName;      // 필수
    private final int age;              // 선택
    private final String phone;         // 선택
    private final String address;       // 선택
    private final String email;         // 선택

    // 1. 필수 매개변수만 받는 생성자
    public User(String firstName, String lastName) {
        this(firstName, lastName, 0, "", "", "");
    }

    public User(String firstName, String lastName, int age, String phone, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }
}
