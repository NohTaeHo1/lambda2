package com.von.api.user;


import com.von.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

import java.util.Optional;
import java.util.Scanner;

public class UserController {
    private static UserController instance = new UserController();
    UserServiceImpl us;

    private UserController() {
        us = UserServiceImpl.getInstance();
    }

    public static UserController getInstance() {
        return instance;
    }

    public String addUsers() {
        return us.addUsers();
    }

    public String join(Scanner scanner) {
        us.save(User.builder()
                .username(scanner.next())
                .phoneNumber(scanner.next())
                .password(scanner.next())
                .build());
        return "회원가입 성공";
    }

    public List<User> findAll() {
        return us.findAll();
    }

    public String login(Scanner scanner) {
        return us.login(User.builder()
                .username(scanner.next())
                .password(scanner.next())
                .build());
    }

    public Optional<User> findById(Scanner scanner) {
        return us.findById(Long.parseLong(scanner.next()));
    }

    public String updatePassword(Scanner scanner) {
        return us.updatePassword(User.builder()
                .username(scanner.next())
                .phoneNumber(scanner.next())
                .password(scanner.next())
                .build());
    }

    public String delete(Scanner scanner) {
        us.delete(User.builder()
                .username(scanner.next())
                .build());
        return "회원삭제";
    }


    public List<?> findUsersByName(Scanner scanner) {
        return us.findUsersByName(scanner.next());
    }


    public List<?> findUsersByJob(Scanner scanner) {
        return us.findUsersByJob(scanner.next());
    }


    public String count() {
        return us.count();
    }


    public List<?> findUsers() throws SQLException {
        return us.findUsers();
    }

    public Messenger createUsers() throws SQLException {
        return us.createUsers();
    }

    public Messenger createTable() throws SQLException {
        return us.createTable();
    }

    public String deleteTable() throws SQLException {
        return us.deleteTable();
    }
}