package com.xalface.microservices.reservation.xAlface_ReservationService.DTOs;

import java.time.LocalDateTime;

public record ReservationDTO(
    LocalDateTime startDateTime,
    LocalDateTime endDateTime,
    Long teacherId,
    Long classroomId
) {}
