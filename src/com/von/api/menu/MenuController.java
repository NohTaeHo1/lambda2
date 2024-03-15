package com.von.api.menu;

import com.von.api.enums.Messenger;
import lombok.Getter;

import java.util.List;

public class MenuController {
    @Getter
    private static MenuController instance = new MenuController();
    MenuServiceImpl msi;
    public MenuController() {
        msi = MenuServiceImpl.getInstance();
    }
    public static MenuController getInstance() {
        return instance;
    }


    public void makeMenus() {
        msi.makeMenus();
    }

    public void insertMenus( ) {
        msi.inserMenus();
    }
}
