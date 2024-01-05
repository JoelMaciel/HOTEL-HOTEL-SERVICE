package com.joelmaciel.hotelservice.domain.services;

import com.joelmaciel.hotelservice.api.dtos.request.HotelRequestDTO;
import com.joelmaciel.hotelservice.api.dtos.response.HotelDTO;
import com.joelmaciel.hotelservice.domain.entities.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface HotelService {

    HotelDTO save(HotelRequestDTO hotelRequestDTO);

    Page<HotelDTO> getAll(Pageable pageable, String name, String location);

    HotelDTO findById(UUID hotelId);

    Hotel findByHotel(UUID hotelId);

}
