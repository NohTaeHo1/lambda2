package com.von.api.user;

import com.von.api.enums.UserRouter;

import java.sql.SQLException;
import java.util.Scanner;


public class UserView {
    public static void main(Scanner sc) throws SQLException {
        UserController uc = UserController.getInstance();
        //System.out.println("adduser 수 : "+msg);

        while (true) {
            UserRouter.getP(sc);
        }
    }
}