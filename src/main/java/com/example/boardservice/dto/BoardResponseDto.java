package com.example.boardservice.dto;

public class BoardResponseDto {
    private final Long boardId;
    private final String title;
    private final String content;
    private final UserDto user;

    public BoardResponseDto(Long boardId, String title, String content, UserDto user) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Long getBoardId() {
        return boardId;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public UserDto getUser() {
        return user;
    }

    
}
