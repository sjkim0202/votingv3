package com.example.votingv3.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class BlockchainRelayService {

    private final WebClient webClient = WebClient.create("http://<로컬서버IP>:3001");

    public String sendToLocalServer(Long voteId, int itemIndex, String userAddress) {
        Map<String, Object> requestBody = Map.of(
                "voteId", voteId,
                "itemIndex", itemIndex,
                "userAddress", userAddress
        );

        return webClient.post()
                .uri("/send-transaction")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block(); // sync
    }
}
