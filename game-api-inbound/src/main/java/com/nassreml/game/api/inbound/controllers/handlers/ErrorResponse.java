package com.nassreml.game.api.inbound.controllers.handlers;

import java.time.LocalDateTime;

public record ErrorResponse(LocalDateTime timestamp, String message, String details) {
}