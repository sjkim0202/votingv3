package com.example.votingv3.repository;

import com.example.votingv3.entity.VoteItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 투표 항목(후보자 등) 레포지토리
 */
public interface VoteItemRepository extends JpaRepository<VoteItem, Long> {
    List<VoteItem> findByVoteId(Long voteId); // 특정 투표에 속한 항목들 조회
}
