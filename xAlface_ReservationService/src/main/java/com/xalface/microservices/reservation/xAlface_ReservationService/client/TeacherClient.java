package com.xalface.microservices.reservation.xAlface_ReservationService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xalface.microservices.reservation.xAlface_ReservationService.dto.TeacherDTO;

@FeignClient("user-service")
public interface TeacherClient {
    @GetMapping("/teachers/{id}")
    TeacherDTO getById(@PathVariable("id") Long id);
}
