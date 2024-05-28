package com.example.server.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * web api统一返回
 * @author ggg1235
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {

    private boolean success;

    private String message;

    private Object body;

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
