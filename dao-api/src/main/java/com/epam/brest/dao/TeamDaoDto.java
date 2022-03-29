package com.epam.brest.dao;

import com.epam.brest.model.dto.TeamDto;

import java.util.List;

public interface TeamDaoDto {

    /**
     * Get all teams with number of players .
     *
     * @return teams list.
     */
    List<TeamDto> findAllWithNumberOfPlayersAndAvrSalarySql();

}
