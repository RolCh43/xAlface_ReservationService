package com.xalface.microservices.reservation.xAlface_ReservationService.dto;

import java.time.LocalDateTime;

public record ReservationDTO(
    LocalDateTime startDateTime,
    LocalDateTime endDateTime,
    Long teacherId,
    Long classroomId
) {}
