package com.example.hms.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@RestController
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

    static class Appointment {
        public int id;
        public String patientName;
        public String doctorName;
        public LocalDate date;
        public String status;

        public Appointment(int id, String patientName, String doctorName, LocalDate date, String status) {
            this.id = id;
            this.patientName = patientName;
            this.doctorName = doctorName;
            this.date = date;
            this.status = status;
        }
    }

    private final List<Patient> patients = new ArrayList<>();
    private final List<Doctor> doctors = new ArrayList<>();
    private final List<Appointment> appointments = new ArrayList<>();

    public PatientController() {
        patients.add(new Patient(1, "Amogh", 22, "Fever"));
        patients.add(new Patient(2, "Riya", 25, "Flu"));

        doctors.add(new Doctor(1, "Dr. Sharma", "Cardiologist", 10));
        doctors.add(new Doctor(2, "Dr. Priya", "Pediatrician", 7));

        appointments.add(new Appointment(1, "Amogh", "Dr. Sharma", LocalDate.now(), "Scheduled"));
        appointments.add(new Appointment(2, "Riya", "Dr. Priya", LocalDate.now().plusDays(1), "Pending"));
    }

    // ✅ THIS is the key: /patients returns a WRAPPER object, not just list
    @GetMapping("/patients")
    public Map<String, Object> getAllPatients() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("count", patients.size());
        response.put("timestamp", LocalDateTime.now());
        response.put("hospital", "City Hospital");
        response.put("patients", patients);
        return response;
    }

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        patient.id = patients.size() + 1;
        patients.add(patient);
        return patient;
    }

    @GetMapping("/doctors")
    public Map<String, Object> getAllDoctors() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("count", doctors.size());
        response.put("timestamp", LocalDateTime.now());
        response.put("hospital", "City Hospital");
        response.put("doctors", doctors);
        return response;
    }

    @GetMapping("/appointments")
    public Map<String, Object> getAllAppointments() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("count", appointments.size());
        response.put("timestamp", LocalDateTime.now());
        response.put("hospital", "City Hospital");
        response.put("appointments", appointments);
        return response;
    }
}
