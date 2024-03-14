package com.von.api.board;

import java.sql.SQLException;
import java.util.List;

public class BoardController {
    BoardService bs;

    public BoardController( ) {
        this.bs = BoardServiceImpl.getInstance();
    }

    public List<?> readArticles() throws SQLException {
        return bs.readArticles();
    }
}