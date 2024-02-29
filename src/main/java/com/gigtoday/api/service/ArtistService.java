package com.gigtoday.api.service;

import com.gigtoday.api.repository.ArtistRepository;
import com.gigtoday.api.util.dto.ArtistJoinDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service
public class ArtistService {

    private final ArtistRepository artistRepository;


    public Long join(ArtistJoinDto dto) {
        return artistRepository.save(dto.toEntity())
                .getId();
    }
}
