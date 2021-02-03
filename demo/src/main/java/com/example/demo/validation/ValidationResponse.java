package com.example.demo.validation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ValidationResponse implements Serializable {

    private static final long serialVersionUID = 854879902734658567L;

    private List<MessageError> fieldErrors = new ArrayList<>();

    private String status;
    
    private Object resultado;

    public ValidationResponse() {
        // Construtor Padrão
    }

    public ValidationResponse(String status) {
        this.status = status;
    }

    public void addFieldError(String path, String message) {
        MessageError error = new MessageError(path, message);
        fieldErrors.add(error);
    }
    
}