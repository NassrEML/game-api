package com.nassreml.game.api.core.application.usecases;

import com.nassreml.game.api.core.domain.CreateGame;
import com.nassreml.game.api.core.domain.Game;
import com.nassreml.game.api.core.domain.GamePort;
import org.springframework.stereotype.Component;

@Component
public class CreateGameCmd {
    private final GamePort gamePort;

    public CreateGameCmd(GamePort gamePort) {
        this.gamePort = gamePort;
    }

    public Game execute(CreateGame game) {
        return gamePort.createGame(game);
    }
}
