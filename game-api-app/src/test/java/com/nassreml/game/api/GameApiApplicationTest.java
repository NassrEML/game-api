package com.nassreml.game.api;

import com.nassreml.game.api.core.domain.UpdatableFields;
import com.nassreml.game.api.inbound.dtos.CreateGameDto;
import com.nassreml.game.api.inbound.dtos.GameDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameApiApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    @Order(1)
    void shouldCreateGame() {
        // Given
        String url = "http://localhost:%d/api/v1/games".formatted(port);
        CreateGameDto createGameDto = new CreateGameDto(
                "Rocket League",
                1L
        );

        // When
        ResponseEntity<GameDto> response = restTemplate.postForEntity(url, createGameDto, GameDto.class);

        // Then
        GameDto gameDto = new GameDto(
                1L,
                "Rocket League",
                1L
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(gameDto, response.getBody());
    }

    @Test
    @Order(2)
    void shouldUpdateGame() {
        // Given
        GameDto gameDto = new GameDto(
                1L,
                "Rocket League",
                1L
        );

        String url = "http://localhost:%d/api/v1/games/%d".formatted(port, gameDto.id());

        UpdatableFields updatableFields = new UpdatableFields("Rocket League v2");


        GameDto updatedGameDto = new GameDto(
                gameDto.id(),
                updatableFields.name(),
                gameDto.userId()
        );

        // When
        restTemplate.put(url, updatableFields);

        ResponseEntity<GameDto> response = restTemplate.getForEntity(url, GameDto.class);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedGameDto, response.getBody());
    }

    @Test
    @Order(3)
    void shouldGetGame() {
        // Given
        GameDto gameDto = new GameDto(
                1L,
                "Rocket League v2",
                1L
        );

        String url = "http://localhost:%d/api/v1/games/%d".formatted(port, gameDto.id());

        // When
        ResponseEntity<GameDto> response = restTemplate.getForEntity(url, GameDto.class);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(gameDto, response.getBody());
    }

    @Test
    @Order(4)
    void shouldDeleteGame() {
        // Given
        String url = "http://localhost:%d/api/v1/games/%d".formatted(port, 1L);
        ResponseEntity<GameDto> gameDtoResponseEntity = restTemplate.getForEntity(url, GameDto.class);
        assertEquals(HttpStatus.OK, gameDtoResponseEntity.getStatusCode());

        // When
        restTemplate.delete(url);

        ResponseEntity<GameDto> response = restTemplate.getForEntity(url, GameDto.class);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
