package com.von.api.user;

import com.von.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private Connection connection;

    private UserRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vondb",
                "root",
                "rootroot");
    }
    ;
    private static UserRepository instance;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserRepository getInstance() {
        return instance;
    }


    public String test() {
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {

        List<User> ls = new ArrayList<>();

        ResultSet rs = connection.prepareStatement("select * from articles").executeQuery();
        if (rs.next()) {
            do {
                ls.add(User.builder()
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .phoneNumber(rs.getString("phoneNumber"))
                        .job(rs.getString("job"))
                        .build());

                System.out.printf("ID: %d\tTitle: %10s\tContent: %10s\tWriter: %s\n",
                        rs.getInt("id"),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                System.out.println();
            } while (rs.next());
        } else {
            System.out.println("데이터가 없습니다.");
        }
        rs.close();
        connection.close();
        return null;
    }

    public Messenger createTable() throws SQLException {

        String sql =
                "CREATE TABLE IF NOT EXISTS users (\n" +
                        "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                        "    username VARCHAR(20) NOT NULL,\n" +
                        "    password VARCHAR(20) NOT NULL,\n" +
                        "    name VARCHAR(20),\n" +
                        "    phone VARCHAR(20),\n" +
                        "    job VARCHAR(20),\n" +
                        "    height VARCHAR(20),\n" +
                        "    weight VARCHAR(20)\n" +
                        ");"; //.executeUpdate();
        PreparedStatement pstmt = connection.prepareStatement(sql);

        return (pstmt.executeUpdate()==0)? Messenger.SUCCESS: Messenger.FAIL;
        //return (a.next()) ? result = "테이블 이미 존재-실패":result = "테이블 생성 성공";
    }

    public String deleteTable() throws SQLException {
        connection.prepareStatement("DROP TABLE users;").executeUpdate();
        return "테이블 삭제 성공";
    }
    public Messenger createUsers() throws SQLException {
        String sql ="CREATE TABLE IF NOT EXISTS members (\n" +
                "        \"                       id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "        \"                       member_name VARCHAR(20) NOT NULL,\n" +
                "        \"                       password VARCHAR(20) NOT NULL,\n" +
                "        \"                       name VARCHAR(20),\n" +
                "        \"                       phone_number VARCHAR(20),\n" +
                "        \"                       job VARCHAR(20),\n" +
                "        \"                       height VARCHAR(20),\n" +
                "        \"                       weight VARCHAR(20)\n" +
                "        \"";

        return (connection.prepareStatement(sql).executeUpdate() >= 0) ? Messenger.SUCCESS: Messenger.FAIL;
    }
}