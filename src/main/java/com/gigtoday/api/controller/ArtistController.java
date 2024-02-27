package com.gigtoday.api.controller;

import com.gigtoday.api.service.ArtistService;
import com.gigtoday.api.util.dto.ArtistJoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ArtistController {

    private final ArtistService artistService;

    @PostMapping("/join/artist")
    public Long join(@RequestBody ArtistJoinDto dto) {
        return artistService.join(dto);
    }
}
