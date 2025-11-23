package com.example.hms.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class HmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HmsApplication.class, args);
    }

    @GetMapping("/patients")
    public List<Map<String, Object>> getPatients() {
        return Arrays.asList(
                Map.of("id", 1, "name", "Amogh", "age", 22, "disease", "Fever"),
                Map.of("id", 2, "name", "Riya", "age", 30, "disease", "Flu")
        );
    }
}
