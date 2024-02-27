package com.gigtoday.api.controller;

import com.gigtoday.api.service.GigService;
import com.gigtoday.api.util.dto.GigJoinDto;
import com.gigtoday.api.util.dto.GigTodayDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GigController {

    private final GigService gigService;

    @PostMapping("/join/gig")
    public Long join(@RequestBody GigJoinDto dto) {
        return gigService.join(dto);
    }

    @GetMapping("/gig/today")
    public List<GigTodayDto> getTodayGigs() {
        return gigService.getTodayGigs();
    }
}
