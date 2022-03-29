package com.epam.brest.impl;

import com.epam.brest.FootballerService;
import com.epam.brest.dao.FootballerDao;
import com.epam.brest.exceptions.FootballerNotFoundException;
import com.epam.brest.model.Footballer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FootballerServiceImpl implements FootballerService {

    private final FootballerDao footballerDao;

    public FootballerServiceImpl(FootballerDao footballerDao) {
        this.footballerDao = footballerDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Footballer> findAll() {
        return this.footballerDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Footballer getFootballerById(Integer footballerId) {
        try {
            return this.footballerDao.getFootballerById(footballerId);
        }catch (EmptyResultDataAccessException e){
            throw new FootballerNotFoundException(footballerId);
        }
    }

    @Override
    @Transactional
    public Integer create(Footballer footballer) {
        return this.footballerDao.create(footballer);
    }

    @Override
    @Transactional
    public Integer update(Footballer footballer) {
        return this.footballerDao.update(footballer);
    }

    @Override
    @Transactional
    public Integer delete(Integer footballerId) {
        return this.footballerDao.delete(footballerId);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer count() {
        return this.footballerDao.count();
    }
}
