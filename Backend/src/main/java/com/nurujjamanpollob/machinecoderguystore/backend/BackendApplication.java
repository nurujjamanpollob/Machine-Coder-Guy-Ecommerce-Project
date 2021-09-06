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

package com.nurujjamanpollob.machinecoderguystore.backend;

import com.nurujjamanpollob.machinecoderguystore.commonlibrary.utilities.Variables;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

// entry point of out Backend module application
@SpringBootApplication
@EntityScan({Variables.COMMON_LIBRARY_ENTRY_POINT, com.nurujjamanpollob.machinecoderguystore.backend.utility.Variables.BACKEND_LIBRARY_ENTRY_POINT_USER})
@ComponentScan(basePackages = {Variables.BASE_PACKAGE_NAME})
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
