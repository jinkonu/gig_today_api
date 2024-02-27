package com.gigtoday.api.util;

import com.gigtoday.api.domain.Artist;
import com.gigtoday.api.domain.Lineup;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GigLineupUtils {

    public static Map<Long, String> of(List<Lineup> lineups) {
        return lineups.stream()
                .map(Lineup::getArtist)
                .collect(Collectors.toMap(
                        Artist::getId,
                        Artist::getName
                ));
    }
}
