package com.study.projectboard.dto;

import com.study.projectboard.domain.UserAccount;

import java.time.LocalDateTime;
public record UserAccountDto(
        Long id,
        String userId,
        String userPassword,
        String email,
        String nickname,
        String memo,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static UserAccountDto of(String userId, String userPassword, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new UserAccountDto(null, userId, userPassword, email, nickname, memo, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static UserAccountDto of(Long id, String userId, String userPassword, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new UserAccountDto(id, userId, userPassword, email, nickname, memo, createdAt, createdBy, modifiedAt, modifiedBy);
    }


    public static UserAccountDto of(String userId, String userPassword, String email, String nickname, String memo) {
        return new UserAccountDto(1L, userId, userPassword, email, nickname, memo, null, null, null, null);
    }

    public static UserAccountDto from(UserAccount entity) {
        return new UserAccountDto(
                entity.getId(),
                entity.getUserId(),
                entity.getUserPassword(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getMemo(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public UserAccount toEntity() {
        return UserAccount.of(
                userId,
                userPassword,
                email,
                nickname,
                memo
        );
    }
}