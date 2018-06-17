package com.paigunna.api.rest;

import com.paigunna.api.domain.Test;
import com.paigunna.api.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Arm
 */

@RestController
@RequestMapping("/test")
public class TestResource {

    @Autowired
    private TestRepo testRepo;


    @PostMapping
    public Test gotosave(@RequestBody Test test){
        return testRepo.save(test);
    }
}
