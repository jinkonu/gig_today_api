package com.gigtoday.api.util.dto;

import com.gigtoday.api.domain.*;
import com.gigtoday.api.util.GigDateUtils;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

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

    public Gig toEntity(List<MultipartFile> images, Venue venue, List<Artist> artists) {
        Gig gig = Gig.builder()
                .name(name)
                .startTime(GigDateUtils.of(date, startTime))
                .endTime(GigDateUtils.of(date, endTime))
                .ticketPrice(ticketPrice)
                .notice(notice)
                .venue(venue)
                .build();

        gig.addImages(images);
        gig.addLineups(artists);

        return gig;
    }
}
