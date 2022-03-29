package com.epam.brest.dao;

import com.epam.brest.model.Team;

import java.util.List;

public interface TeamDao {

    List<Team> findAll();
    Team    getTeamById(Integer teamId);
    Integer create(Team team);
    Integer update(Team team);
    Integer delete(Integer teamId);
    Integer count();
    boolean isUniqueTeamName(String teamName);
}
