package com.karabiner.securityproduct.review.service;

public class ReviewAlreadyExistsExeption extends RuntimeException {
    public ReviewAlreadyExistsExeption(String message) {
        super(message);
    }
}
