package com.von.api.menu;

import com.von.api.enums.Messenger;

import java.sql.*;

public class MenuRepository {
    private static MenuRepository instance;

    static {
        try {
            instance = new MenuRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private MenuRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vondb",
                "root",
                "rootroot");
    }

    public static MenuRepository getInstance() {
        return instance;
    }

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    public Messenger makeTable() {
        String sql = "CREATE TABLE IF NOT EXISTS menus (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "category VARCHAR(10) NOT NULL," +
                "item VARCHAR(20) NOT NULL)";
        try {
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }

    public Messenger removeTable() {
        String sql = "DROP TABLE IF EXISTS menus";
        try {
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }
    public Messenger insertMenu() {
        String sql = "INSERT INTO menus(category, item) VALUES(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, menu.getCategory());
            pstmt.setString(2, menu.getItem());
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred :" + menu.getCategory() + " " + menu.getItem());
            return Messenger.SQL_ERROR;
        }
    }

    public void makeMenus() {
        this.makeTable();
    }

    public void inserMenu( ) {
        this.insertMenu();
    }

    /*public void createTable() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vondb",
                "root",
                "rootroot");
        con.prepareStatement("INSERT INTO menus(item, category)\n" +
                        "        VALUES\n" +
                        "        ('0-종료', 'x-Exit'),\n" +
                        "        ('j-회원가입', 'u-User'),\n" +
                        "        ('l-로그인', 'b-Board'),\n" +
                        "        ('i-ID검색', 'm-Account'),\n" +
                        "        ('p-비번변경', 'c-Crawler'),\n" +
                        "        ('w-탈퇴', 'a-Article'),\n" +
                        "        ('ls-회원목록', ''),\n" +
                        "        ('n-이름검색', ''),\n" +
                        "        ('j-직업검색', ''),\n" +
                        "        ('c-회원수', ''),\n" +
                        "        ('touch-테이블생성', ''),\n" +
                        "        ('rm-테이블삭제', '');\n" +
                        "        \")")
        .executeQuery();
    }*/

}