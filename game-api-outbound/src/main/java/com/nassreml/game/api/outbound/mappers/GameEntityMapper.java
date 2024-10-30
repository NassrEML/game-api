package com.nassreml.game.api.outbound.mappers;

import com.nassreml.game.api.core.domain.Game;
import com.nassreml.game.api.outbound.entities.GameEntity;

public class GameEntityMapper {

    public static Game toDomain(GameEntity gameEntity) {
        return new Game(gameEntity.getId(), gameEntity.getName(), gameEntity.getUserId());
    }

}
