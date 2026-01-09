package com.example.boardservice.client;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import com.example.boardservice.dto.AddActivityScoreDto;
import com.example.boardservice.dto.UserResponseDto;

@Component
public class UserClient {
    private final RestClient restClient;

    public UserClient(
        @Value("${client.user-service.url}")
        String userServiceUrl
    ) {
        this.restClient = RestClient.builder().baseUrl(userServiceUrl).build();
    }

    public Optional<UserResponseDto> fetchUser(Long userId) {
        try {
            UserResponseDto userResponseDto = this.restClient.get()
            .uri("/internal/users/{userId}", userId)
            .retrieve()
            .body(UserResponseDto.class);

            return Optional.ofNullable(userResponseDto);
        } catch (RestClientException e) {
            // 로깅 추가
            return Optional.empty();
        }
    }

    public List<UserResponseDto> fetchUsersByIds(List<Long> ids) {
        try {
           return this.restClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/internal/users")
                .queryParam("ids", ids)
                .build()
            )
            .retrieve()
            .body(new ParameterizedTypeReference<List<UserResponseDto>>() {});

        } catch (RestClientException e) {
            // 로깅
            return Collections.emptyList();
        }
    }

    public void addActivityScore(Long userId, int score) {
        AddActivityScoreDto addActivityScoreDto = new AddActivityScoreDto(
            userId,
            score
        );

        this.restClient.post()
            .uri("/internal/users/activity-score/add")
            .contentType(MediaType.APPLICATION_JSON)
            .body(addActivityScoreDto)
            .retrieve()
            .toBodilessEntity();
    }
}
