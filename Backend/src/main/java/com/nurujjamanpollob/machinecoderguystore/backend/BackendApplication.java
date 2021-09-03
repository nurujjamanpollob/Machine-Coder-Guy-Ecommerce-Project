package com.nurujjamanpollob.machinecoderguystore.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan({"com.nurujjamanpollob.machinecoderguystore.commonlibrary", "com.nurujjamanpollob.machinecoderguystore.backend.users"})
@ComponentScan(basePackages = { "com.nurujjamanpollob.machinecoderguystore.*" })
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
