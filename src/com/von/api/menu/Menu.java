package com.von.api.menu;

import lombok.AccessLevel;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"id"})

public class Menu {
    private Long id;
    private String item;
    private String category;
    @Builder(builderMethodName = "builder")
    public Menu(String item, String category) {
        this.item = item;
        this.category = category;
    }
}


//insert into menus(item, category), values("1-회원가입". "users")
