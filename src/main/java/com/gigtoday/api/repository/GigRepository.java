package com.gigtoday.api.repository;

import com.gigtoday.api.domain.Gig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GigRepository extends JpaRepository<Gig, Long> {
    List<Gig> findAllByStartTimeBetween(LocalDateTime from, LocalDateTime to);
}
