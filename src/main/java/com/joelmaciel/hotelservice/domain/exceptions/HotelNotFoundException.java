package com.joelmaciel.hotelservice.domain.exceptions;

import java.util.UUID;

public class HotelNotFoundException extends ResourceNotFoundException {
    public HotelNotFoundException(String message) {
        super(message);
    }

    public HotelNotFoundException(UUID hotelId) {
        this(String.format("Hotel with given uuid not found %s", hotelId));
    }
}
