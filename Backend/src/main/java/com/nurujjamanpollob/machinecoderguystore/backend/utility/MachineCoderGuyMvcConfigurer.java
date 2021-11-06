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

package com.nurujjamanpollob.machinecoderguystore.backend.utility;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Nurujjaman Pollob
 * <p>
 * Override Spring WebMvcConfigurer to add new resource path
 * @see WebMvcConfigurer for more information
 */


@Configuration
public class MachineCoderGuyMvcConfigurer implements WebMvcConfigurer {


    /**
     * @param registry get existing ResourceHandlerRegistry instance to add new resource location
     * @see ResourceHandlerRegistry for more information
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {


        Path userFilesDir = Paths.get(Variables.USERS_FILE_DIRECTORY);
        String userFilesPath = userFilesDir.toFile().getAbsolutePath();

        // add paths to Spring resource handler
        registry.addResourceHandler("/" + Variables.USERS_FILE_DIRECTORY + "**")
                .addResourceLocations("file:/" + userFilesPath + "/")
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());

        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
