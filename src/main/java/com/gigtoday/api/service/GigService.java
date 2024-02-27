package com.gigtoday.api.service;

import com.gigtoday.api.repository.GigRepository;
import com.gigtoday.api.repository.LineupRepository;
import com.gigtoday.api.repository.VenueRepository;
import com.gigtoday.api.util.dto.GigJoinDto;
import com.gigtoday.api.util.dto.GigTodayDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.gigtoday.api.util.GigDateUtils.endOfDay;
import static com.gigtoday.api.util.GigDateUtils.now;

@RequiredArgsConstructor
@Transactional
@Service
public class GigService {

    public final GigRepository gigRepository;
    public final VenueRepository venueRepository;
    public final LineupRepository lineupRepository;


    public Long join(GigJoinDto dto) {
        return gigRepository.save(dto.toEntity(
                venueRepository.findById(dto.getVenudId()).orElseThrow(),
                dto.getLineupIds().stream()
                        .map((lineupId) -> lineupRepository.findById(lineupId).orElseThrow())
                        .toList()
        )).getId();
    }

    public List<GigTodayDto> getTodayGigs() {
        return gigRepository.findAllByStartTimeBetween(now, endOfDay).stream()
                .map(GigTodayDto::of)
                .toList();
    }
}
