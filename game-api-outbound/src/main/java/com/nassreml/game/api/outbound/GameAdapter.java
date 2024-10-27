package com.nassreml.game.api.outbound;

import com.nassreml.game.api.core.domain.*;
import org.springframework.stereotype.Component;

@Component
public class GameAdapter implements GamePort {

    @Override
    public Game createGame(CreateGame game) {
        if (game.name().equals("Nassr")) {
            throw new GameAlreadyExistsException("Game with name " + game.name() + " already exists");
        }
        return new Game(1L, game.name(), game.userId());
    }

    @Override
    public Game findGame(Long id) {
        if (id == 1L) {
            throw new GameNotFoundException("Game with id " + id + " not found");
        }
        return new Game(id, "Nassr", 1L);
    }

    @Override
    public Game updateGame(Game updatedGame) {
        return updatedGame;
    }

    @Override
    public void deleteGame(Long gameId) {
        return;
    }
}
