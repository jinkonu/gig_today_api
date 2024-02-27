package com.gigtoday.api.domain;

import jakarta.persistence.*;

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
}
