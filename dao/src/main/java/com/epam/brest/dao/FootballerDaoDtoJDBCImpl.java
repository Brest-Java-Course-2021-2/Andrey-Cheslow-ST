package com.epam.brest.dao;

import com.epam.brest.model.dto.FootballerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@PropertySource("footballer.properties")
public class FootballerDaoDtoJDBCImpl implements FootballerDaoDto{

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public FootballerDaoDtoJDBCImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Value("${findAllWithTeamName}")
    private String findAllWithTeamName;

    @Value("${findAllWithTeamNameWithFilterFromDate}")
    private String findAllWithTeamNameWithFilterFromDate;

    @Value("${findAllWithTeamNameWithFilterToDate}")
    private String findAllWithTeamNameWithFilterToDate;

    @Value("${findAllWithTeamNameWithDateFilter}")
    private String findAllWithTeamNameWithDateFilter;

    @Override
    public List<FootballerDto> findAllWithTeamName() {
        return namedParameterJdbcTemplate.query(findAllWithTeamName, BeanPropertyRowMapper.newInstance(FootballerDto.class));
    }

    @Override
    public List<FootballerDto> findAllWithTeamNameWithFilterFromDate(LocalDate fromDate) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("fromDate",fromDate);
        return namedParameterJdbcTemplate.query(findAllWithTeamNameWithFilterFromDate,sqlParameterSource,BeanPropertyRowMapper.newInstance(FootballerDto.class));
    }
    @Override
    public List<FootballerDto> findAllWithTeamNameWithFilterToDate(LocalDate toDate) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("toDate",toDate);
        return namedParameterJdbcTemplate.query(findAllWithTeamNameWithFilterToDate,sqlParameterSource,BeanPropertyRowMapper.newInstance(FootballerDto.class));
    }
    @Override
    public List<FootballerDto> findAllWithTeamNameWithDateFilter(LocalDate fromDate, LocalDate toDate) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("toDate",toDate)
                .addValue("fromDate",fromDate);
        return namedParameterJdbcTemplate.query(findAllWithTeamNameWithDateFilter,sqlParameterSource,BeanPropertyRowMapper.newInstance(FootballerDto.class));
    }
}
