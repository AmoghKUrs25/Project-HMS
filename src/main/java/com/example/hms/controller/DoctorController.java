package com.example.hms.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    static class Doctor {
        public int id;
        public String name;
        public String specialization;
        public int experienceYears;

        public Doctor(int id, String name, String specialization, int experienceYears) {
            this.id = id;
            this.name = name;
            this.specialization = specialization;
            this.experienceYears = experienceYears;
        }
    }

    private final List<Doctor> doctors = new ArrayList<>();

    public DoctorController() {
        doctors.add(new Doctor(1, "Dr. Sharma", "Cardiologist", 10));
        doctors.add(new Doctor(2, "Dr. Priya", "Pediatrician", 7));
    }

    @GetMapping
    public Map<String, Object> getAllDoctors() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("count", doctors.size());
        response.put("timestamp", LocalDateTime.now());
        response.put("hospital", "City Hospital");
        response.put("doctors", doctors);
        return response;
    }
}
