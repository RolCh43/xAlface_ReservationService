package com.xalface.microservices.reservation.xAlface_ReservationService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xalface.microservices.reservation.xAlface_ReservationService.DTOs.ReservationDTO;
import com.xalface.microservices.reservation.xAlface_ReservationService.exceptions.EntityNotFoundException;
import com.xalface.microservices.reservation.xAlface_ReservationService.model.Reservation;
import com.xalface.microservices.reservation.xAlface_ReservationService.repositories.ReservationRepository;
@Service
public class ReservationService {

     
    private final ReservationRepository reservationRepo;
    private final ValidationService validationService;
   
    @Autowired
    public ReservationService(ReservationRepository reservationRepo, ValidationService validationService) {
        this.reservationRepo = reservationRepo;
        this.validationService = validationService;
    }

    @Transactional(readOnly = true)
    public Reservation findById(Long id) {
        return reservationRepo.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada com id: " + id));
    }
    
    @Transactional(readOnly = true)
    public List<Reservation> findAll() {
        return reservationRepo.findAll();
    }

    @Transactional(readOnly = true)
    public List<Reservation> findByTeacherId(Long teacherId) {
        return reservationRepo.findByTeacherId(teacherId);
    }
    
    @Transactional()
    public Reservation create (ReservationDTO dto) {
        validationService.validateCreate(dto);
        Reservation reservation = new Reservation();
        reservation.setStartDateTime(dto.startDateTime());
        reservation.setEndDateTime(dto.endDateTime());
        reservation.setTeacherId(dto.teacherId());
        reservation.setClassroomId(dto.classroomId());    
        return reservationRepo.save(reservation);
    }

    @Transactional()
    public Reservation update(Long id, ReservationDTO dto) {
        validationService.validateUpdate(dto, id);
        Reservation reservation = reservationRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada com id: " + id));
        reservation.setStartDateTime(dto.startDateTime());
        reservation.setEndDateTime(dto.endDateTime());
        reservation.setTeacherId(dto.teacherId());
        reservation.setClassroomId(dto.classroomId());
        return reservationRepo.save(reservation);
    }

    @Transactional
    public void delete(Long id) {
        reservationRepo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Reservation> findByClassroomId(Long classroomId) {
        return reservationRepo.findByClassroomId(classroomId);
    }


     


}
