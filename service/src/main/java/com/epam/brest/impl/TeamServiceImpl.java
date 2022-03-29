package com.epam.brest.impl;

import com.epam.brest.TeamService;
import com.epam.brest.dao.TeamDao;
import com.epam.brest.exceptions.TeamNotFoundException;
import com.epam.brest.model.Team;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamDao teamDao;

    public TeamServiceImpl(TeamDao teamDao) {
        this.teamDao = teamDao;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Team> findAll() {
        return this.teamDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Team getTeamById(Integer teamId) {
        try {
            return this.teamDao.getTeamById(teamId);
        }catch (EmptyResultDataAccessException e){
            throw new TeamNotFoundException(teamId);
        }

    }

    @Override
    @Transactional
    public Integer create(Team team) {
        return this.teamDao.create(team);
    }

    @Override
    @Transactional
    public Integer update(Team team) {
        return this.teamDao.update(team);
    }

    @Override
    @Transactional
    public Integer delete(Integer teamId) {
        return this.teamDao.delete(teamId);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer count() {
        return this.teamDao.count();
    }
}
