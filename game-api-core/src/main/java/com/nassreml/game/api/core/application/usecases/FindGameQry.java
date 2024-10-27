package com.nassreml.game.api.core.application.usecases;

import com.nassreml.game.api.core.domain.Game;
import com.nassreml.game.api.core.domain.GamePort;
import org.springframework.stereotype.Component;

@Component
public class FindGameQry {

    private final GamePort gamePort;

    public FindGameQry(GamePort gamePort) {
        this.gamePort = gamePort;
    }

    public Game execute(Long id) {
        return gamePort.findGame(id);
    }
}
