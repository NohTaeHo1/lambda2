package com.von.api.board;

import com.von.api.common.UtilService;
import com.von.api.common.UtilServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardView {
    public static void main(Scanner sc) throws SQLException {
        List<Board> articles = new ArrayList<>();
        UtilService util = UtilServiceImpl.getInstance();
        BoardController bc = new BoardController();

  /*      for (int i = 0; i < 5; i++) {
            articles.add(Board.builder()
                    //.id(util.createRandomLong())
                    .boardType(util.createRandomContent())
                    .boardName(util.createRandomName())
                    .build());
        }
        for (Board i : articles) {

            System.out.println(i.toString());
        }

        articles.forEach(i -> {
            System.out.println(i.toString());
        });
*/
        while(true){
            System.out.println("[메뉴]0-종료 1-게시판 보기");
            switch(sc.nextInt()){
                case 0:
                    return;
                case 1:
                    System.out.println("[게시판 보기]");
                    bc.readArticles();
            }
        }
    }

}