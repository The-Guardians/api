package com.paigunna.api.service;


import com.paigunna.api.dto.UserDto;
import com.paigunna.api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProviderActiveServiceImpl implements ProviderActiveService{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<UserDto> findActiveProvider() {

        String query = "select * from user u where u.status = \'PROVIDER\'";


        return jdbcTemplate.queryForObject(query, new RowMapper<List<UserDto>>() {

            @Override
            public List<UserDto> mapRow(ResultSet resultSet, int i) throws SQLException {

                List<UserDto> result = new ArrayList<>();
                while (resultSet.next()){
                    UserDto userDto = new UserDto();
                    userDto.setId(resultSet.getLong("id"));
                    userDto.setFirstName(resultSet.getString("first_name"));
                    userDto.setLastName(resultSet.getString("last_name"));
                    userDto.setEmail(resultSet.getString("email"));
                    userDto.setStatus(resultSet.getString("status"));
                    userDto.setLatitude(resultSet.getDouble("gps_lat"));
                    userDto.setLongitude(resultSet.getDouble("gps_lng"));
                    result.add(userDto);
                }
                return result;
            }
        });
    }
}
