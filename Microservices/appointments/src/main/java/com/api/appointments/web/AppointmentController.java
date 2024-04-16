package com.api.appointments.web;

import com.api.appointments.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping(path = "/appointment")
public class AppointmentController {
    private AppointmentService appointmentService;


}
