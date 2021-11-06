/*
 * Copyright (c) 2021 Nurujjaman Pollob, All Right Reserved.
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package com.nurujjamanpollob.machinecoderguystore.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Nurujjaman Pollob
 * Configuration class to configure Spring Web Security setting
 * For more information, plese see those class documentation:
 * @see org.springframework.security.config.annotation.SecurityConfigurer
 * @see WebSecurityConfigurerAdapter
 * @see Configuration
 * @see EnableWebSecurity
 */
@Configuration
@EnableWebSecurity
public class MachineCoderGuySecurity extends WebSecurityConfigurerAdapter {

    /**
     * Create a bean that replace Spring default password Encoder
     * @return Password Encoder Object we prefer to use!
     */
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }


    /**
     * @param http Spring injected HttpSecurity object to configure
     *             Web security settings
     * @throws Exception if you pass conflicting or wrong settings
     * @see HttpSecurity doc for more information
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // allow all request without authorization
        http.authorizeRequests().anyRequest().permitAll();

    }
}
