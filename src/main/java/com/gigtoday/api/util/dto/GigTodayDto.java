package com.gigtoday.api.util.dto;

import com.gigtoday.api.domain.Gig;
import com.gigtoday.api.domain.Lineup;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class GigTodayDto {

    final Long venueId;
    final String venueName;
    final Map<Long, String> artists;

    public static GigTodayDto of(Gig gig) {
        return GigTodayDto.builder()
                .venueId(gig.getVenue().getId())
                .venueName(gig.getVenue().getName())
                .artists(Lineup.toMap(gig.getLineups()))
                .build();
    }
}
