package com.gigtoday.api.util.dto;

import com.gigtoday.api.domain.Artist;
import com.gigtoday.api.domain.Gig;
import com.gigtoday.api.domain.Lineup;
import com.gigtoday.api.domain.Venue;
import com.gigtoday.api.util.GigDateUtils;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class GigJoinDto {

    private String name;
    private String date;
    private String startTime;
    private String endTime;
    private int ticketPrice;
    private String notice;
    private Long venueId;
    private List<Long> artistIds;

    public Gig toEntity(Venue venue, List<Artist> artists) {
        return Gig.builder()
                .name(name)
                .startTime(GigDateUtils.of(date, startTime))
                .endTime(GigDateUtils.of(date, endTime))
                .ticketPrice(ticketPrice)
                .notice(notice)
                .venue(venue)
                .lineups(Lineup.with(artists))
                .build();
    }
}
