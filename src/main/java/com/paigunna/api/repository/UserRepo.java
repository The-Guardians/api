/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paigunna.api.repository;

import com.paigunna.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author armme : 15/03/2018
 */

public interface UserRepo extends JpaRepository<User, Long>{

    User save(User user);

}
