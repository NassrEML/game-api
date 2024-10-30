package com.nassreml.game.api.outbound.adapters;

import com.nassreml.game.api.core.domain.*;
import com.nassreml.game.api.outbound.entities.GameEntity;
import com.nassreml.game.api.outbound.mappers.GameEntityMapper;
import com.nassreml.game.api.outbound.repositories.GameRepository;
import org.springframework.stereotype.Component;

@Component
public class GameAdapter implements GamePort {

    private static final String GAME_NOT_FOUND_MSG = "Game with id %d not found";

    private final GameRepository gameRepository;

    public GameAdapter(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game createGame(CreateGame game) {
        if (gameRepository.existsByName(game.name())) {
            throw new GameAlreadyExistsException("Game with name %s already exists".formatted(game.name()));
        }

        GameEntity gameEntity = gameRepository.save(new GameEntity(game.name(), game.userId()));
        return GameEntityMapper.toDomain(gameEntity);
    }

    @Override
    public Game findGame(Long gameId) {
        return gameRepository.findById(gameId)
                .map(GameEntityMapper::toDomain)
                .orElseThrow(() -> new GameNotFoundException(GAME_NOT_FOUND_MSG.formatted(gameId)));
    }

    @Override
    public Game updateGame(Game updatedGame) {
        if (!gameRepository.existsById(updatedGame.id())) {
            throw new GameNotFoundException(GAME_NOT_FOUND_MSG.formatted(updatedGame.id()));
        }

        GameEntity gameEntity = new GameEntity(updatedGame.id(), updatedGame.name(), updatedGame.userId());

        GameEntity savedEntity = gameRepository.save(gameEntity);

        return GameEntityMapper.toDomain(savedEntity);
    }

    @Override
    public void deleteGame(Long gameId) {
        if (!gameRepository.existsById(gameId)) {
            throw new GameNotFoundException(GAME_NOT_FOUND_MSG.formatted(gameId));
        }
        gameRepository.deleteById(gameId);
    }
}
