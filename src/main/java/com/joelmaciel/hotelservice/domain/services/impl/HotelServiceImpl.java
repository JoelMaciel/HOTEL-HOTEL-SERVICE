package com.joelmaciel.hotelservice.domain.services.impl;

import com.joelmaciel.hotelservice.api.dtos.request.HotelRequestDTO;
import com.joelmaciel.hotelservice.api.dtos.response.HotelDTO;
import com.joelmaciel.hotelservice.domain.entities.Hotel;
import com.joelmaciel.hotelservice.domain.exceptions.HotelNotFoundException;
import com.joelmaciel.hotelservice.domain.repositories.HotelRepository;
import com.joelmaciel.hotelservice.domain.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<HotelDTO> getAll(Pageable pageable, String name, String location) {
        Page<Hotel> hotels = getPageHotels(pageable, name, location);
        return hotels.map(HotelDTO::toDTO);
    }

    @Override
    @Transactional
    public HotelDTO save(HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = HotelRequestDTO.toEntity(hotelRequestDTO);
        return HotelDTO.toDTO(hotelRepository.save(hotel));
    }

    @Override
    @Transactional(readOnly = true)
    public HotelDTO findById(UUID hotelId) {
        Hotel hotel = findByHotel(hotelId);
        return HotelDTO.toDTO(hotel);
    }

    @Override
    @Transactional(readOnly = true)
    public Hotel findByHotel(UUID hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException(hotelId));
    }

    private Page<Hotel> getPageHotels(Pageable pageable, String name, String location) {
        Page<Hotel> hotels;
        if (name != null) {
            hotels = hotelRepository.findByNameContaining(pageable, name);
        } else if (location != null) {
            hotels = hotelRepository.findByLocationContaining(pageable, location);
        } else {
            hotels = hotelRepository.findAll(pageable);
        }
        return hotels;
    }
}
