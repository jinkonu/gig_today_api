package com.gigtoday.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Lineup {

    /* DB id */
    @Id @GeneratedValue
    @Column(name = "lineup_id")
    private Long id;

    /* Related data */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gig_id")
    private Gig gig;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;


    /* Domain logic */
    public static Map<Long, String> toMap(List<Lineup> lineups) {
        return lineups.stream()
                .map(Lineup::getArtist)
                .collect(Collectors.toMap(
                        Artist::getId,
                        Artist::getName
                ));
    }

    public static List<Lineup> with(List<Artist> artists) {
        return artists.stream()
                .map(artist -> Lineup.builder().artist(artist).build())
                .toList();
    }
}
