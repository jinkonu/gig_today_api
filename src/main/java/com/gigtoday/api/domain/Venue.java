package com.gigtoday.api.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Venue {

    /* DB id */
    @Id @GeneratedValue
    @Column(name = "venue_id")
    private Long id;

    /* Unrelated data */
    private String name;
    private String profile;

    /* Related data */
    @OneToMany(mappedBy = "venue")
    private List<Gig> gigs = new ArrayList<>();
}
