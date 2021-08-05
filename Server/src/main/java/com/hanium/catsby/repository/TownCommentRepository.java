package com.hanium.catsby.repository;

import com.hanium.catsby.domain.TownComment;
import com.hanium.catsby.domain.TownCommunity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TownCommentRepository extends JpaRepository<TownComment, Integer> {
}
