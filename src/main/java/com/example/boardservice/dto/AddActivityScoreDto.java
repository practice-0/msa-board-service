package com.example.boardservice.dto;

public class AddActivityScoreDto {
    private Long userId;
    private int score;
    public AddActivityScoreDto() {
    }
    public AddActivityScoreDto(Long userId, int score) {
        this.userId = userId;
        this.score = score;
    }
    public Long getUserId() {
        return userId;
    }
    public int getScore() {
        return score;
    }

}
