package com.von.api.article;

import lombok.*;

import java.sql.*;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"id"})

public class Article {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private Date registerDate;
    @Builder
    public Article(Long id, String title, String content, String writer, Date registerDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.registerDate = registerDate;
    }
}