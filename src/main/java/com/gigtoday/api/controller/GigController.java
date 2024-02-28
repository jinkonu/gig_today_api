package com.gigtoday.api.controller;

import com.gigtoday.api.service.GigService;
import com.gigtoday.api.util.dto.GigJoinDto;
import com.gigtoday.api.util.dto.GigTodayDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GigController {

    private final GigService gigService;

    @PostMapping(value = "/join/gig")
    public Long join(@RequestPart(name = "images") List<MultipartFile> images,
                     @RequestPart(name = "dto") GigJoinDto dto) {
        return gigService.join(images, dto);
    }

    @GetMapping("/gig/today")
    public List<GigTodayDto> getTodayGigs() {
        return gigService.getTodayGigs();
    }
}
