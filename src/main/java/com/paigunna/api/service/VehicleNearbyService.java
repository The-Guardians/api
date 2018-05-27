/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paigunna.api.service;

import com.paigunna.api.dto.VehicleDto;
import java.util.List;


public interface VehicleNearbyService {

    List<VehicleDto> findByUserIdAndDistanceAndVehicleType(Long userId, Long distance, String vehicleType);
    
}
