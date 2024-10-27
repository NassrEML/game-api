package com.nassreml.game.api.core.domain;

public record Game(
        Long id,
        String name,
        Long userId
) {
    public Game update(UpdatableFields updatableFields) {
        return new Game(id, updatableFields.name(), userId);
    }
}
