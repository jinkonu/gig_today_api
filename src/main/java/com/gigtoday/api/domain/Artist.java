package com.gigtoday.api.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
