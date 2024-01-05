package com.joelmaciel.hotelservice.domain.repositories;

import com.joelmaciel.hotelservice.domain.entities.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, UUID> {

    Page<Hotel> findByNameContaining(Pageable pageable, String name);

    Page<Hotel> findByLocationContaining(Pageable pageable, String location);
}
