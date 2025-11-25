package com.example.hms.app.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patients")
public class PatientController {

    static class Patient {
        public int id;
        public String name;
        public int age;
        public String disease;

        public Patient(int id, String name, int age, String disease) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.disease = disease;
        }
    }

    private final List<Patient> patients = new ArrayList<>();

    public PatientController() {
        patients.add(new Patient(1, "Riya", 24, "Fever"));
        patients.add(new Patient(2, "Amogh K Urs", 20, "Fever"));
        patients.add(new Patient(3, "Akash S U", 20, "cough"));
        patients.add(new Patient(4, "Advaith C Patil", 20, "cold"));
        patients.add(new Patient(5, "Abhishek Kashyap j ", 20, "Headache"));
        patients.add(new Patient(6, "Abhishek V Jadav", 22, "Flu"));

    }

    @GetMapping
    public Map<String, Object> getAllPatients() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("count", patients.size());
        response.put("timestamp", LocalDateTime.now());
        response.put("hospital", "City Hospital");
        response.put("patients", patients);
        return response;
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        patient.id = patients.size() + 1;
        patients.add(patient);
        return patient;
    }
}
