package com.nassreml.game.api.inbound.controllers.rest;

import com.nassreml.game.api.core.application.usecases.UpdateGameCmd;
import com.nassreml.game.api.core.domain.Game;
import com.nassreml.game.api.core.domain.UpdatableFields;
import com.nassreml.game.api.inbound.commons.constants.ApiPathVariables;
import com.nassreml.game.api.inbound.dtos.GameDto;
import com.nassreml.game.api.inbound.mappers.GameMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPathVariables.API_ROUTE + ApiPathVariables.V1_ROUTE + ApiPathVariables.GAME_ROUTE)
public class PutGameController {

    private final UpdateGameCmd updateGameCmd;

    public PutGameController(UpdateGameCmd updateGameCmd) {
        this.updateGameCmd = updateGameCmd;
    }

    @PutMapping("/{gameId}")
    public ResponseEntity<GameDto> updateGame(@PathVariable("gameId") Long gameId, @RequestBody UpdatableFields updatableFields) {

        Game game = updateGameCmd.execute(gameId, updatableFields);

        GameDto gameDto = GameMapper.toDto(game);

        return ResponseEntity.ok(gameDto);
    }
}
