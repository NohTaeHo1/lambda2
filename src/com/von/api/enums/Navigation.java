package com.von.api.enums;

import com.von.api.account.AccountView;
import com.von.api.article.ArticleView;
import com.von.api.board.BoardView;
import com.von.api.crawler.CrawlerView;
import com.von.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public enum Navigation {

    EXIT("x", sc -> {
        System.exit(0);
    }),
    USER("u", sc -> {
        try {
            UserView.main(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    BOARD("b", sc -> {
        try {
            BoardView.main(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    ACCOUNT("m", sc -> AccountView.main(sc)),
    CRAW("c", sc -> {
        try {
            CrawlerView.main(sc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }),
    ARTICLE("a", sc -> {
        try {
            ArticleView.main(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    });
    private final String key;
    private final Consumer<Scanner> consumer;

    Navigation(String key, Consumer<Scanner> consumer) {
        this.key = key;
        this.consumer = consumer;
    }

    public static void getPage(Scanner sc) {
        System.out.println("=== x-Exit " +
                "u-User " +
                "b-Board " +
                "m-Account " +
                "c-Crawler " +
                "a-Article"
                + "===");
        getP(sc.next()).consumer.accept(sc);
    }

    private static Navigation getP(String sc) {
        return Arrays.stream(values()).filter(o -> o.key.equals(sc))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 값이 아닙니다."));
    }
}