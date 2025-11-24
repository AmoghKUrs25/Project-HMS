package com.example.hms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

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

    private final List<Appointment> appointments = new ArrayList<>();

    public AppointmentController() {
        appointments.add(new Appointment(1, "Amogh", "Dr. Sharma", LocalDate.now(), "Scheduled"));
        appointments.add(new Appointment(2, "Riya", "Dr. Priya", LocalDate.now().plusDays(1), "Pending"));
    }

    @GetMapping
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
