package com.xalface.microservices.reservation.xAlface_ReservationService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xalface.microservices.reservation.xAlface_ReservationService.dto.ClassroomDTO;

@FeignClient("classroom-service")
public interface ClassroomClient {
    @GetMapping("/classrooms/{id}")
    ClassroomDTO getById(@PathVariable("id") Long id);
    

}
