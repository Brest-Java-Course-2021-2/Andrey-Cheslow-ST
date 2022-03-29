package com.epam.brest.dao;

import com.epam.brest.model.dto.FootballerDto;

import java.time.LocalDate;
import java.util.List;

public interface FootballerDaoDto {
    /**
     * Get all footballers with team name .
     *
     * @return footballers list.
     */
    List<FootballerDto> findAllWithTeamName();

    /**
     * Get all footballers with team name and date filter "from" .
     *
     * @return footballers list.
     */
    List<FootballerDto> findAllWithTeamNameWithFilterFromDate(LocalDate fromDate);

    /**
     * Get all footballers with team name and date filter "to" .
     *
     * @return footballers list.
     */
    List<FootballerDto> findAllWithTeamNameWithFilterToDate(LocalDate toDate);

    /**
     * Get all footballers with team name and date filter "from-to" .
     *
     * @return footballers list.
     */
    List<FootballerDto> findAllWithTeamNameWithDateFilter(LocalDate fromDate,LocalDate toDate);
}
