package com.nassreml.game.api.core.application.usecases;

import com.nassreml.game.api.core.domain.GamePort;
import org.springframework.stereotype.Component;

@Component
public class DeleteGameCmd {

    private final GamePort gamePort;

    public DeleteGameCmd(GamePort gamePort) {
        this.gamePort = gamePort;
    }

    public void execute(Long gameId) {
        gamePort.deleteGame(gameId);
    }
}
