package com.nassreml.game.api.inbound.controllers;

import com.nassreml.game.api.core.application.usecases.HelloWorldQry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello-world")
public class GetHelloWorldController {

    private final HelloWorldQry helloWorldQry;

    public GetHelloWorldController(HelloWorldQry helloWorldQry) {
        this.helloWorldQry = helloWorldQry;
    }

    @GetMapping("/")
    public ResponseEntity<String> helloWorld() {
        String result = helloWorldQry.execute();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}