package com.epam.tc.hw6.service.exception;

public class WebDriverLaunchTypeException extends IllegalArgumentException {
    public WebDriverLaunchTypeException() {
        super("Unsupported launch type. Only local and remote are available");
    }
}
