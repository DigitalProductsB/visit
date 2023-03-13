package com.internal.visit.exception

class DataNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DataNotFound(String msg) {
        super(msg);
    }
}
