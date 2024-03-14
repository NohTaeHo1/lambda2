package com.von.api.board;

import java.sql.SQLException;
import java.util.List;

public interface BoardService {
    List<?> readArticles() throws SQLException;
}