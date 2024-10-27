package com.nassreml.game.api.core.domain;

public interface GamePort {
    Game createGame(CreateGame game) throws GameAlreadyExistsException;

    Game findGame(Long id) throws GameNotFoundException;

    Game updateGame(Game updatedGame);

    void deleteGame(Long gameId);
}
