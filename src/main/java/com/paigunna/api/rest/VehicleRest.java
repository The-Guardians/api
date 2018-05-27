/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paigunna.api.rest;

import com.paigunna.api.dto.VehicleDto;
import com.paigunna.api.service.VehicleNearbyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehicleRest {

    @Autowired
    private VehicleNearbyService service;

    @GetMapping("/nearby")
    public List<VehicleDto> nearby(
            @RequestParam(name = "user_id") Long userId,
            @RequestParam(name = "distance") Long distance,
            @RequestParam(name = "vehicle_type") String vehicleType
    ) {
        return service.findByUserIdAndDistanceAndVehicleType(userId, distance, vehicleType);
    }

}
