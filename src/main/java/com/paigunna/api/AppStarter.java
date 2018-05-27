/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paigunna.api;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.paigunna")
public class AppStarter {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppStarter.class, args);
    }
}
