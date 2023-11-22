package com.example.todolist.entity;

import java.io.Serializable;

public interface GenerationId <K extends Serializable> {

    void setId(K id);

    K getId();

}
