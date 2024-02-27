package com.gigtoday.api.util.dto;

import com.gigtoday.api.domain.Venue;
import lombok.Getter;

@Getter
public class VenueJoinDto {

    private String name;
    private String profile;

    public Venue toEntity() {
        return Venue.builder()
                .name(name)
                .profile(profile)
                .build();
    }
}
