package com.von.api.article;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleView {
    public static void main(Scanner sc) throws SQLException {
        ArticleController ac = new ArticleController();
        while (true) {
            System.out.println("0-종료 1-findAll");
            switch (sc.nextInt()) {
                case 0:
                    return;
                case 1:
                    ac.findAll().forEach(i-> System.out.println(i));
                    break;
            }
        }

    }
}