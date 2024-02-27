package com.gigtoday.api.util.dto;

import com.gigtoday.api.domain.Artist;
import lombok.Getter;

@Getter
public class ArtistJoinDto {

    private String name;
    private String profile;

    public Artist toEntity() {
        return Artist.builder()
                .name(name)
                .profile(profile)
                .build();
    }
}
