package com.nassreml.game.api.inbound.controllers.rest;


import com.nassreml.game.api.core.application.usecases.CreateGameCmd;
import com.nassreml.game.api.core.domain.CreateGame;
import com.nassreml.game.api.core.domain.Game;
import com.nassreml.game.api.inbound.commons.constants.ApiPathVariables;
import com.nassreml.game.api.inbound.dtos.CreateGameDto;
import com.nassreml.game.api.inbound.dtos.GameDto;
import com.nassreml.game.api.inbound.mappers.GameMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPathVariables.API_ROUTE + ApiPathVariables.V1_ROUTE + ApiPathVariables.GAME_ROUTE)
public class PostGameController {


    private final CreateGameCmd createGameCmd;

    public PostGameController(CreateGameCmd createGameCmd) {
        this.createGameCmd = createGameCmd;
    }

    @PostMapping("")
    public ResponseEntity<GameDto> createGame(@RequestBody CreateGameDto createGameDto) {
        CreateGame createGame = GameMapper.toDomain(createGameDto);

        Game createdGame = createGameCmd.execute(createGame);

        GameDto gameDto = GameMapper.toDto(createdGame);

        return ResponseEntity.ok(gameDto);
    }
}

