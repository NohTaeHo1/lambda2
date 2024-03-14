package com.von.api.enums;

import com.von.api.user.UserController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
public enum UserRouter {

    EXIT("x", sc -> {
        return;
    }),
    JOIN("j", sc -> UserController.getInstance().join(sc)),
    LOGIN("l", sc -> UserController.getInstance().login(sc)),
    IDSEARCH("i", sc -> UserController.getInstance().findById(sc)),
    CHANGEPW("p", sc -> UserController.getInstance().updatePassword(sc)),
    WITHDRAW("w", sc -> UserController.getInstance().delete(sc)),
    LIST("ls", sc -> UserController.getInstance().findAll()),
    NAMESEARCH("n", sc -> UserController.getInstance().findUsersByName(sc)),
    JOBSEARCH("j", sc -> UserController.getInstance().findUsersByJob(sc)),
    MEMCOUNT("c", sc -> UserController.getInstance().count()),
    CREATETABLE("touch", sc -> {
        try {
            UserController.getInstance().createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    DELTABLE("rm", sc -> {
        try {
            UserController.getInstance().deleteTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    });
    private final String key;
    private final Consumer<Scanner> consumer;

    UserRouter(String key, Consumer<Scanner> consumer) {
        this.key = key;
        this.consumer = consumer;
    }


    public static void getP(Scanner sc) throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vondb",
                "root",
                "rootroot");
        String sql = "SELECT item FROM menus";
        con.prepareStatement(sql).executeQuery();

        getPage(sc.next()).consumer.accept(sc);
    }

    private static UserRouter getPage(String sc) {
        return Arrays.stream(values())
                .filter(o -> o.key.equals(sc))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 값이 아닙니다."));
    }
}