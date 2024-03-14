package com.von.api.crawler;

import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner sc) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        CrawlerController cc = new CrawlerController();

        Iterator<Element> title;
        Iterator<Element> artist;
        Iterator<Element> rank;
        Map<String, ?> map;


        while (true) {
            System.out.println("[메뉴]\n 0-종료\n " +
                    "1-벅스뮤직 차트\n " +
                    "2-멜론뮤직 차트\n " +
                    "3-ID검색\n " +
                    "4-비번변경\n " +
                    "5-탈퇴\n " +
                    "6-회원목록\n " +
                    "7-이름검색\n " +
                    "8-직업검색\n " +
                    "9-회원수\n ");


            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("=== 벅스뮤직 ===");
                    map = cc.findBugsMusic(sc);

                    title = (Iterator<Element>) map.get("1");
                    artist = (Iterator<Element>) map.get("2");
                    rank = (Iterator<Element>) map.get("3");
                    System.out.println("벅스뮤직 결과 : ");
                    while (rank.hasNext()) {
                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
                    }
                    break;
                case "2":
                    System.out.println("=== 멜론뮤직 차트 ===");

                    map = cc.findMelonMusic(sc);

                    title = (Iterator<Element>) map.get("1");
                    artist = (Iterator<Element>) map.get("2");
                    rank = (Iterator<Element>) map.get("3");
                    System.out.println("멜론뮤직 결과 : ");
                    while (rank.hasNext()) {
                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
                    }

                    break;
                case "3":
                    System.out.println("=== ID검색 ===");

                    break;
                case "6":
                    System.out.println("=== 회원목록 ===");
                    break;
                case "8":
                    System.out.println("=== 직업검색 ===");
                    break;
                case "9":
                    System.out.println("=== 회원수 ===");
                    return;
            }
        }
    }
}