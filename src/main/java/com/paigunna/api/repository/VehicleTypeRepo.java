/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paigunna.api.repository;

import com.paigunna.api.domain.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepo extends JpaRepository<VehicleType, Long>{

    
    
}
