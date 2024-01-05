package com.joelmaciel.hotelservice.api.dtos.request;

import com.joelmaciel.hotelservice.domain.entities.Hotel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class HotelRequestDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String location;
    @NotBlank
    private String information;

    public static Hotel toEntity(HotelRequestDTO requestDTO) {
        return Hotel.builder()
                .name(requestDTO.getName())
                .location(requestDTO.getLocation())
                .information(requestDTO.getInformation())
                .build();
    }
}
