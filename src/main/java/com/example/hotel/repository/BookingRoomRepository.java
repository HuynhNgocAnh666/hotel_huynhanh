package com.example.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hotel.domain.BookingRoom;

public interface BookingRoomRepository extends JpaRepository<BookingRoom, Long> {
    @Query("select b from BookingRoom b LEFT JOIN FETCH b.dichVu d")
    List<BookingRoom> findAllWithDichVu();

    @Query("select b from BookingRoom b LEFT JOIN FETCH b.dichVu d where b.user.id = ?1")
    List<BookingRoom> findByUserId(Long id);
}