package com.example.boardservice.dto;

public class CreateBoardRequestDto {
    private String title;
    private String content;
    
    public CreateBoardRequestDto() {
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
}
