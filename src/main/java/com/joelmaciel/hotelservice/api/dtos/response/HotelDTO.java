package com.joelmaciel.hotelservice.api.dtos.response;

import com.joelmaciel.hotelservice.domain.entities.Hotel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class HotelDTO {

    private UUID hotelId;
    private String name;
    private String location;
    private String information;

    public static HotelDTO toDTO(Hotel hotel) {
        return HotelDTO.builder()
                .hotelId(hotel.getHotelId())
                .name(hotel.getName())
                .location(hotel.getLocation())
                .information(hotel.getInformation())
                .build();
    }
}
