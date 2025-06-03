package com.xalface.microservices.reservation.xAlface_ReservationService.dto;

public record ClassroomDTO(
    String id,
    String roomCode,
    String name,
    String description,
    int capacity,
    boolean isAvailable
) {}
