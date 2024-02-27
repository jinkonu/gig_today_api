package com.gigtoday.api.service;

import com.gigtoday.api.repository.VenueRepository;
import com.gigtoday.api.util.dto.VenueJoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VenueService {

    private final VenueRepository venueRepository;


    public Long join(VenueJoinDto dto) {
        return venueRepository.save(dto.toEntity())
                .getId();
    }
}
