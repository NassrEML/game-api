package com.nassreml.game.api.core.application.usecases;

import com.nassreml.game.api.core.domain.Game;
import com.nassreml.game.api.core.domain.GamePort;
import com.nassreml.game.api.core.domain.UpdatableFields;
import org.springframework.stereotype.Component;

@Component
public class UpdateGameCmd {

    private final GamePort gamePort;

    public UpdateGameCmd(GamePort gamePort) {
        this.gamePort = gamePort;
    }

    public Game execute(Long id, UpdatableFields updatableFields) {
        Game game = gamePort.findGame(id);
        Game updatedGame = game.update(updatableFields);

        return gamePort.updateGame(updatedGame);
    }

}
