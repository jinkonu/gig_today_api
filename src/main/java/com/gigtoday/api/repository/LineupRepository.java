package com.gigtoday.api.repository;

import com.gigtoday.api.domain.Lineup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineupRepository extends JpaRepository<Lineup, Long> {
}
