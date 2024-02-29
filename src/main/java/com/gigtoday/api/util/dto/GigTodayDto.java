package com.gigtoday.api.util.dto;

import com.gigtoday.api.domain.Gig;
import com.gigtoday.api.domain.Lineup;
import lombok.Builder;
import lombok.Getter;
import org.springframework.core.io.UrlResource;

import java.util.Map;

@Builder
@Getter
public class GigTodayDto {

    private final Long venueId;
    private final String venueName;
    private final Map<Long, String> artists;

    private static final int thumbnailIndex = 0;

    public static GigTodayDto of(Gig gig) {
        return GigTodayDto.builder()
                .venueId(gig.getVenue().getId())
                .venueName(gig.getVenue().getName())
                .artists(Lineup.toMap(gig.getLineups()))
                .build();
    }
}
