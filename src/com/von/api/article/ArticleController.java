package com.von.api.article;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleController {
    ArticleService as = ArticleServiceImpl.getInstance();


    public List<?> findAll( ) throws SQLException {
        return as.findAll();
    }
}