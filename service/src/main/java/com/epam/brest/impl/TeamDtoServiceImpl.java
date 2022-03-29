package com.epam.brest.impl;

import com.epam.brest.TeamDtoService;
import com.epam.brest.dao.TeamDaoDto;
import com.epam.brest.model.dto.TeamDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class TeamDtoServiceImpl implements TeamDtoService {

    private final TeamDaoDto teamDaoDto;

    public TeamDtoServiceImpl(TeamDaoDto teamDaoDto) {
        this.teamDaoDto = teamDaoDto;
    }

    @Override
    public List<TeamDto> findAllWithNumberOfPlayersAndAvrSalarySql() {
        return this.teamDaoDto.findAllWithNumberOfPlayersAndAvrSalarySql();
    }
}
