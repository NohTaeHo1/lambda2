package com.von.api.article;

import com.von.api.common.AbstractService;
import com.von.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl extends AbstractService implements ArticleService{
    private ArticleRepository repository;
    private ArticleServiceImpl (){
        repository = ArticleRepository.getInstance();
    }
    private static ArticleService instance = new ArticleServiceImpl();
    public static ArticleService getInstance(){
        return instance;
    }


    @Override
    public Messenger save(Object o) {
        return null;
    }

    @Override
    public List findAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Object o) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}