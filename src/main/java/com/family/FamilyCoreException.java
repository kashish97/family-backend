package com.family;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FamilyCoreException extends Exception {

    private static final long serialVersionUID = 6657794035649049923L;


    public FamilyCoreException(String message) {
        super(message);
        log.error(message,this);
    }
}
