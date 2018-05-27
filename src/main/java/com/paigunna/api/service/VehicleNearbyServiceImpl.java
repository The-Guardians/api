/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paigunna.api.service;

import com.paigunna.api.domain.User;
import com.paigunna.api.dto.VehicleDto;
import com.paigunna.api.repository.UserRepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class VehicleNearbyServiceImpl implements VehicleNearbyService {

    private static final int RADIUS = 6371;//kilometers

    private static final int NUMBER_OF_RECORDS = 20;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<VehicleDto> findByUserIdAndDistanceAndVehicleType(Long userId, Long distance, String vehicleType) {

        User user = userRepo.findOne(userId);
        if (user.getGpsLatitude() == null || user.getGpsLongitude() == null) {
            throw new RuntimeException("Please open gps.");
        }

        String query = "select u.gps_lat, "
                + "       u.gps_lng, "
                + "       u.id, "
                + "       v.license, "
                + "       concat(u.first_name, ' ', u.last_name) as name,  "
                + "       v.province, "
                + "       t.rate, "
                + "       t.name as type_name, "
                + "       t.description type_desc, "
                + "       u.distance   "
                + "          "
                + "from ( "
                + "    SELECT u.*,  "
                + "           ( " + RADIUS + " * acos( cos( radians(?) ) * cos( radians( u.gps_lat ) ) * cos( radians( u.gps_lng ) - radians(?) ) + sin( radians(?) ) * sin( radians( u.gps_lat ) ) ) ) AS distance  "
                + "    FROM user u "
                + "    where u.id <> ? "
                + "    HAVING distance < ? "
                + "    LIMIT 0 , " + NUMBER_OF_RECORDS + " "
                + ") u "
                + " "
                + "inner join vehicle v "
                + "on (u.id = v.user_id) "
                + " "
                + "inner join vehicle_type t "
                + "on (v.type = t.id)   ";

        return jdbcTemplate.queryForObject(query, new Object[]{
                user.getGpsLatitude(),
                user.getGpsLongitude(),
                user.getGpsLatitude(),
                userId,
                distance
        }, new RowMapper<List<VehicleDto>>() {
            @Override
            public List<VehicleDto> mapRow(ResultSet rs, int i) throws SQLException {
                List<VehicleDto> result = new ArrayList<>();
                while (rs.next()) {
                    VehicleDto dto = new VehicleDto();
                    dto.setLatitude(rs.getDouble("gps_lat"));
                    dto.setLongitude(rs.getDouble("gps_lng"));
                    dto.setId(rs.getLong("id"));
                    dto.setLicense(rs.getString("license"));
                    dto.setProviderName(rs.getString("name"));
                    dto.setProvince(rs.getString("province"));
                    dto.setRate(rs.getBigDecimal("rate"));
                    dto.setType(rs.getString("type_name"));
                    dto.setTypeDesc(rs.getString("type_desc"));
                    dto.setDistance(rs.getDouble("distance"));
                    result.add(dto);
                }
                return result;
            }

        });
    }

}
