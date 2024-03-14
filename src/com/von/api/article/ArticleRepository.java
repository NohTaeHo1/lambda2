package com.von.api.article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private ArticleRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vondb",
                "root",
                "rootroot");
    }
    private static ArticleRepository instance;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArticleRepository getInstance(){
        return instance;
    }

    private Connection conn;


    public List findAll() throws SQLException {
        List<Article> ls = new ArrayList<>();
        String sql = "select * from articles";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                ls.add(Article.builder()
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .content(rs.getString("content"))
                        .writer(rs.getString("writer"))
                        //.registerDate(rs.getDate("register_date"))
                        .build());

                System.out.println();
            } while (rs.next());
        } else {
            System.out.println("데이터가 없습니다.");
        }
        rs.close();
        pstmt.close();
        conn.close();

        return ls;
    }
}