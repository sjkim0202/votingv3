package com.example.votingv3.controller;

import com.example.votingv3.dto.VoteSubmitRequest;
import com.example.votingv3.service.BlockchainRelayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/tx")
@RequiredArgsConstructor
public class TransactionRelayController {

    private final BlockchainRelayService blockchainRelayService;

    @PostMapping("/vote/{voteId}/submit")
    public ResponseEntity<?> submitVoteTransaction(
            @PathVariable Long voteId,
            @RequestBody VoteSubmitRequest request
    ) {
        String txHash = blockchainRelayService.sendToLocalServer(
                voteId,
                request.getItemIndex(),
                request.getUserAddress()
        );

        return ResponseEntity.ok(Map.of(
                "message", "트랜잭션 전송 완료",
                "txHash", txHash
        ));
    }
}

