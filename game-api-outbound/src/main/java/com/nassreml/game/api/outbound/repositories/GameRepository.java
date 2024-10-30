package com.nassreml.game.api.outbound.repositories;

import com.nassreml.game.api.outbound.entities.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {
    boolean existsByName(String name);
}
