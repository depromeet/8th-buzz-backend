package com.depromeet.buzz.participation.repository;

import com.depromeet.buzz.participation.domain.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {
    boolean existsByUserUserIdAndPostId(String userId, Long postId);
}
