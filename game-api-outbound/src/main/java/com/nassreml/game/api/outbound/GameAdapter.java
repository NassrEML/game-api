package com.nassreml.game.api.outbound;

import com.nassreml.game.api.core.domain.CreateGame;
import com.nassreml.game.api.core.domain.Game;
import com.nassreml.game.api.core.domain.GameAlreadyExistsException;
import com.nassreml.game.api.core.domain.GamePort;
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
}
