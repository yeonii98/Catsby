package com.hanium.catsby.repository;

import com.hanium.catsby.domain.TownCommunity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TownRepository extends JpaRepository<TownCommunity, Integer> {
}
