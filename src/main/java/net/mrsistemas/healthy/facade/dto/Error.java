package net.mrsistemas.healthy.facade.dto;

import java.io.Serializable;

public class Error implements Serializable {

    private Long id;
    private String type;
    private String message;


    public Error(Long id, String type, String message) {
        super();
        this.id = id;
        this.type = type;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
