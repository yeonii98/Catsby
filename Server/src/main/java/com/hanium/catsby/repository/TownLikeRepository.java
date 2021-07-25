package com.hanium.catsby.repository;

import com.hanium.catsby.domain.TownComment;
import com.hanium.catsby.domain.TownLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TownLikeRepository extends JpaRepository<TownLike, Integer> {
}
