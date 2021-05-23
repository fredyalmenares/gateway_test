package com.test.gateway.exception;

public class EntityAlreadyExistsException extends RuntimeException {

    private final String entity;
    private final String id;

    public EntityAlreadyExistsException(String entity, String idColumn, String id) {
        super(entity + " with "+idColumn+" " + id + " already exists.");
        this.entity = entity;
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public String getId() {
        return id;
    }
}
