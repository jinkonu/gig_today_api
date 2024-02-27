package com.gigtoday.api.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Gig {

    /* DB id */
    @Id @GeneratedValue
    @Column(name = "gig_id")
    private Long id;

    /* Unrelated data */
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int ticketPrice;
    private String notice;


    /* Related data */
    @OneToMany(mappedBy = "gig")
    private List<Ticket> tickets = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @OneToMany(mappedBy = "gig")
    private List<Lineup> lineups = new ArrayList<>();
}
