package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String getGreeting() {
        logger.trace("Trace level");
        logger.debug("Debug level");
        logger.info("Info level");
        logger.warn("Warn level");
        logger.error("Error level");
        logger.error("An error message", new DummyThrowable("Sample value for dummy object"));
        return "Hi";
    }
}

class DummyThrowable extends Throwable {
    private String value;

    public DummyThrowable(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
