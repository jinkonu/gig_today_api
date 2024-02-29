package com.gigtoday.api.service;

import com.gigtoday.api.domain.Gig;
import com.gigtoday.api.repository.*;
import com.gigtoday.api.util.dto.GigJoinDto;
import com.gigtoday.api.util.dto.GigTodayDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.gigtoday.api.util.GigDateUtils.endOfDay;
import static com.gigtoday.api.util.GigDateUtils.now;

@RequiredArgsConstructor
@Transactional
@Service
public class GigService {

    public final GigRepository gigRepository;
    public final VenueRepository venueRepository;
    public final ArtistRepository artistRepository;
    public final LineupRepository lineupRepository;


    public Long join(List<MultipartFile> images, GigJoinDto dto) {
        return gigRepository.save(dto.toEntity(
                images,
                venueRepository.findById(dto.getVenueId()).orElseThrow(),
                dto.getArtistIds().stream()
                        .map((artistId) -> artistRepository.findById(artistId).orElseThrow())
                        .toList()
                )
        ).getId();
    }

    public List<GigTodayDto> getTodayGigs() {
        return gigRepository.findAllByStartTimeBetween(now, endOfDay).stream()
                .map(GigTodayDto::of)
                .toList();
    }
}
