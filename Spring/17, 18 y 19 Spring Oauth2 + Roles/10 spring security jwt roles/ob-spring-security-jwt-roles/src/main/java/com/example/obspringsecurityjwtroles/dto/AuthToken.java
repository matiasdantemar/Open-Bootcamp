package com.example.obspringsecurityjwtroles.dto;
//DTO clases que sirven para enviar datos, no corresponden con uan tabla en BD
public class AuthToken {

    private String token;

    public AuthToken(){

    }

    public AuthToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}