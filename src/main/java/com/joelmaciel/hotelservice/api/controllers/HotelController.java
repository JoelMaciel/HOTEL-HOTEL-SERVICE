package com.joelmaciel.hotelservice.api.controllers;

import com.joelmaciel.hotelservice.api.dtos.request.HotelRequestDTO;
import com.joelmaciel.hotelservice.api.dtos.response.HotelDTO;
import com.joelmaciel.hotelservice.domain.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public Page<HotelDTO> getAll(
            @PageableDefault(page = 0, size = 10, sort = "hotelId", direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String location) {
        return hotelService.getAll(pageable, name, location);
    }

    @GetMapping("/{hotelId}")
    public HotelDTO getOne(@PathVariable UUID hotelId) {
        return hotelService.findById(hotelId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HotelDTO save(@RequestBody @Valid HotelRequestDTO hotelRequestDTO) {
        return hotelService.save(hotelRequestDTO);
    }
}
