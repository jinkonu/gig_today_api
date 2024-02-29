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
    @Builder.Default
    @OneToMany(mappedBy = "gig", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> images = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "gig")
    private List<Ticket> tickets = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @Builder.Default
    @OneToMany(mappedBy = "gig", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lineup> lineups = new ArrayList<>();


    /* Domain logic */
    public void addImages(List<MultipartFile> files) {
        List<File> images = files.stream()
                .map(File::of)
                .toList();

        this.images = images;
        images.forEach(image -> image.setGig(this));
    }

    public void addLineups(List<Artist> artists) {
        List<Lineup> lineups = Lineup.with(artists);

        this.lineups = lineups;
        lineups.forEach(lineup -> lineup.setGig(this));
    }
}
