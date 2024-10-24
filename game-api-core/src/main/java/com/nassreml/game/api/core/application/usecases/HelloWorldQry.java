package com.nassreml.game.api.core.application.usecases;

import com.nassreml.game.api.core.domain.HelloWorld;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldQry {
    public String execute() {
        return new HelloWorld().get();
    }
}
