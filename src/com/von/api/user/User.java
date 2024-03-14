package com.von.api.user;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString


public class User {

    private Long id;

    private String username;
    private String passwordConfirm;
    private String password;
    private String name;
    private String phone;
    private Long addressId;
    private String job;
    private double height;
    private double weight;

    @Builder(builderMethodName = "builder")
    public User(String username, String passwordConfirm, String password, String name, String phoneNumber, String job, double height, double weight) {
        this.username = username;
        this.passwordConfirm = passwordConfirm;
        this.password = password;
        this.name = name;
        this.phone = phoneNumber;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}