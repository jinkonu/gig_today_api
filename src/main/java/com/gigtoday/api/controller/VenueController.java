package com.gigtoday.api.controller;

import com.gigtoday.api.service.VenueService;
import com.gigtoday.api.util.dto.VenueJoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class VenueController {

    private final VenueService venueService;

    @PostMapping("/join/venue")
    public Long join(@RequestBody VenueJoinDto dto) {
        return venueService.join(dto);
    }
}
