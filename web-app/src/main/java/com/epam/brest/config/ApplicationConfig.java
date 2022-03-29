package com.epam.brest.config;

import com.epam.brest.TeamService;
import com.epam.brest.dao.FootballerDao;
import com.epam.brest.dao.TeamDao;
import com.epam.brest.impl.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@ComponentScan
public class ApplicationConfig {

    @Value("${rest.server.protocol}")
    private String protocol;
    @Value("${rest.server.host}")
    private String host;
    @Value("${rest.server.port}")
    private Integer port;

   private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ApplicationConfig(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

   /* @Bean
    TeamService teamService() {
        return new TeamServiceImpl(new TeamDaoJDBCImpl(namedParameterJdbcTemplate));
    }*/
    /*@Bean
    TeamDao teamDao(){
        return new TeamDaoJDBCImpl(namedParameterJdbcTemplate);
    }*/

}

