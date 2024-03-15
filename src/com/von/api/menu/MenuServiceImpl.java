package com.von.api.menu;

import com.von.api.enums.Messenger;

public class MenuServiceImpl {
    private static MenuServiceImpl instance = new MenuServiceImpl();
    private MenuRepository mr;

    private MenuServiceImpl() {
        mr = MenuRepository.getInstance();
    }

    public static MenuServiceImpl getInstance() {
        return instance;
    }


    private void insertMenus() {
        String[] categories = {"navigate", "user", "account", "article", "board", "soccer"};
        String[][] menus = {{"x", "usr", "acc", "cwl", "art", "bbs", "scc"},
                {"x", "mk", "joi", "log", "cat :", "ch-pw", "rm",
                        "ls-a", "ls-n", "ls-job", "cnt"},
                {"x", "mk", "touch", "with", "depo", "bal", "rm", "cat", "ls-a"},
                {"x", "mk"},
                {"x", "mk"},
                {"x", "mk"}};

        for (int i = 0; i < menus.length; i++)
            for (int j = 0; j < menus[i].length; j++)
                mr.insertMenu(Menu.builder().category(categories[i]).item(menus[i][j]).build());
    }

    public void makeMenus() {
        mr.makeMenus();
    }

    public void inserMenus( ) {
        mr.inserMenu();
    }
}