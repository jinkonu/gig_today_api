package com.gigtoday.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
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
    @OneToMany(mappedBy = "gig", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> images = new ArrayList<>();

    @OneToMany(mappedBy = "gig")
    private List<Ticket> tickets = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @OneToMany(mappedBy = "gig", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lineup> lineups = new ArrayList<>();
}
