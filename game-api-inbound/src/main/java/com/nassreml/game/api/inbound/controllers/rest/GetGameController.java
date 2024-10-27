package com.nassreml.game.api.inbound.controllers.rest;

import com.nassreml.game.api.core.application.usecases.FindGameQry;
import com.nassreml.game.api.core.domain.Game;
import com.nassreml.game.api.inbound.commons.constants.ApiPathVariables;
import com.nassreml.game.api.inbound.dtos.GameDto;
import com.nassreml.game.api.inbound.mappers.GameMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPathVariables.API_ROUTE + ApiPathVariables.V1_ROUTE + ApiPathVariables.GAME_ROUTE)
public class GetGameController {

    private final FindGameQry findGameQry;

    public GetGameController(FindGameQry findGameQry) {
        this.findGameQry = findGameQry;
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GameDto> getGame(@PathVariable(name = "gameId") Long gameId) {

        Game game = findGameQry.execute(gameId);

        GameDto gameDto = GameMapper.toDto(game);

        return ResponseEntity.ok(gameDto);
    }
}
