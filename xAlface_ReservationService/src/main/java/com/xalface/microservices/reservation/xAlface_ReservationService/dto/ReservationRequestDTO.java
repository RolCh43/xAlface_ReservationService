package com.xalface.microservices.reservation.xAlface_ReservationService.dto;

import java.time.LocalDateTime;

public record ReservationRequestDTO(
    LocalDateTime startDateTime,
    LocalDateTime endDateTime,
    String roomCode
)  {}
