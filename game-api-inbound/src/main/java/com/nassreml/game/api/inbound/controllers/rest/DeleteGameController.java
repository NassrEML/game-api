package com.nassreml.game.api.inbound.controllers.rest;


import com.nassreml.game.api.core.application.usecases.DeleteGameCmd;
import com.nassreml.game.api.inbound.commons.constants.ApiPathVariables;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPathVariables.API_ROUTE + ApiPathVariables.V1_ROUTE + ApiPathVariables.GAME_ROUTE)
public class DeleteGameController {

    private final DeleteGameCmd deleteGameCmd;

    public DeleteGameController(DeleteGameCmd deleteGameCmd) {
        this.deleteGameCmd = deleteGameCmd;
    }

    @DeleteMapping("/{gameId}")
    public ResponseEntity<Void> deleteGame(@PathVariable(name = "gameId") Long gameId) {

        deleteGameCmd.execute(gameId);

        return ResponseEntity.noContent().build();
    }
}
