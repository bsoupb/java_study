package day2.자습;

import java.util.Objects;

enum Gender {
    MALE("남성"),
    FEMALE("여성");

    private final String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

public class User {
    private final String userId;
    private final String password;

    private final String nickname;
    private final String address;
    private final int age;
    private final Gender gender;

    private User(Builder builder) {
        this.userId = builder.userId;
        this.password = builder.password;
        this.nickname = builder.nickname;
        this.address = builder.address;
        this.age = builder.age;
        this.gender = builder.gender;
    }

    public static class Builder {
        private final String userId;
        private final String password;

        private String nickname;
        private String address;
        private int age;
        private Gender gender;

        public Builder(String userId, String password) {
            this.userId = Objects.requireNonNull(userId, "userId must not be null");
            this.password = Objects.requireNonNull(password, "password must not be null");
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder age(int age) {
            if(age < 0 || age > 150) {
                throw new IllegalArgumentException("age must be between 0 and 150");
            }
            this.age = age;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = Objects.requireNonNull(gender, "gender must not be null");
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    User user = new User.Builder("A1234", "1234")
            .nickname("hong1234")
            .address("Seoul")
            .age(29)
            .gender(Gender.MALE)
            .build();
}
