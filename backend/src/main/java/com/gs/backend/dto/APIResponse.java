package com.gs.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T> implements Serializable {

    private boolean status;
    private T data;
    private String message;

    public APIResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
}



