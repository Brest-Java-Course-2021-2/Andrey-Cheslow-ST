package com.epam.brest;

import com.epam.brest.model.dto.TeamDto;

import java.util.List;

public interface TeamDtoService {

    /**
     * Get all teams with number of players .
     *
     * @return teams list.
     */
    List<TeamDto> findAllWithNumberOfPlayersAndAvrSalarySql();
}