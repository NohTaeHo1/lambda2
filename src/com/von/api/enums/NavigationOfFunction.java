package com.von.api.enums;

import com.von.api.account.AccountView;
import com.von.api.article.ArticleView;
import com.von.api.board.BoardView;
import com.von.api.crawler.CrawlerView;
import com.von.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum NavigationOfFunction {
        Exit("x", i -> {System.exit(0); return "x";}),
        User("u", i -> {
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Board("b",i ->{
        System.out.println("Board Menu");
        try {
            BoardView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Account("ac", i -> {
        System.out.println("Account Menu");
        AccountView.main(i);
        return "";
    }),
    Crawler("c", i -> {
        try {
            System.out.println("Crawler Menu");
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Article("ar", i -> {
        try {
            System.out.println("Article Menu");
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    })
    ;

    private final  String name;
    private final Function<Scanner, String> function;

    NavigationOfFunction(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String select(Scanner sc) {
        System.out.println("\n === " +
                "x-Exit +" +
                "u-User " +
                "b-Board " +
                "ac-Account " +
                "c-Crawler " +
                "ar-Articles" +
                "===");
        String selectedMenu = sc.next();
        System.out.println("선택한 메뉴 : "+selectedMenu);

        return Stream.of(values())
                .filter(i->i.name.equals(selectedMenu))
                .findAny()
                .orElseGet(()->Exit)
                .function.apply(sc)
                ;

    }
}
