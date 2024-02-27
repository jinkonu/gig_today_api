package com.gigtoday.api.service;

import com.gigtoday.api.domain.Artist;
import com.gigtoday.api.repository.ArtistRepository;
import com.gigtoday.api.util.dto.ArtistJoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArtistService {

    private final ArtistRepository artistRepository;


    public Long join(ArtistJoinDto dto) {
        return artistRepository.save(dto.toEntity())
                .getId();
    }
}
