package com.gigtoday.api.domain;

import jakarta.persistence.*;

@Entity
public class Ticket {

    /* DB id */
    @Id @GeneratedValue
    @Column(name = "ticket_id")
    private Long id;

    /* Related data */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gig_id")
    private Gig gig;
}
