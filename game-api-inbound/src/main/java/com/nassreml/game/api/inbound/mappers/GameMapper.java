package com.nassreml.game.api.inbound.mappers;

import com.nassreml.game.api.core.domain.CreateGame;
import com.nassreml.game.api.core.domain.Game;
import com.nassreml.game.api.inbound.dtos.CreateGameDto;
import com.nassreml.game.api.inbound.dtos.GameDto;

public class GameMapper {
    public static CreateGame toDomain(CreateGameDto createGameDto) {
        return new CreateGame(createGameDto.name(), createGameDto.userId());
    }

    public static GameDto toDto(Game game) {
        return new GameDto(game.id(), game.name(), game.userId());
    }
}
