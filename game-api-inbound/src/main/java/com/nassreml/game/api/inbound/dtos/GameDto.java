package com.nassreml.game.api.inbound.dtos;

public record GameDto(
        Long id,
        String name,
        Long userId
) {
}
