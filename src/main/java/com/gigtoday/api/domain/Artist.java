package com.gigtoday.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Artist {

    /* DB id */
    @Id @GeneratedValue
    @Column(name = "artist_id")
    private Long id;

    /* Unrelated data */
    private String name;
    private String profile;

    /* Related data */
    @OneToMany(mappedBy = "artist")
    private List<Lineup> lineups = new ArrayList<>();
}
