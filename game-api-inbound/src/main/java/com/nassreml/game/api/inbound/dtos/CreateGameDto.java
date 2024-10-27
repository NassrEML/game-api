package com.nassreml.game.api.inbound.dtos;

public record CreateGameDto(
        String name,
        Long userId
) {
}
