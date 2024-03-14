package com.von.api.user;

import com.von.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;


public interface UserService {
    Messenger join(User user);

    String count();


    String addUsers();

    String login(User user);

    String updatePassword(User user);

    List<?> findUsersByName(String name);

    Map<String, ?> findUsersByNameFromMap(String name);

    List<?> findUsersByJob(String job);

    Map<String, ?> findUsersByJobFromMap(String job);

    Map<String, ?> getUserMap();

    String test();

    List<?> findUsers() throws SQLException;

    Messenger createUsers() throws SQLException;

    String deleteTable() throws SQLException;

    Messenger createTable() throws SQLException;
}