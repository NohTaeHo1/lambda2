package com.von.api.board;

import com.von.api.article.Article;

import java.sql.SQLException;
import java.util.List;

public class BoardServiceImpl implements BoardService {
    private BoardServiceImpl(){
    }
    private static BoardService instance = new BoardServiceImpl();

    public static BoardService getInstance(){
        return instance;
    }


    @Override
    public List<?> readArticles() throws SQLException {
        return null;
    }
}