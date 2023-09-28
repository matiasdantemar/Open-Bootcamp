package com.example.obspringsecurityjwtroles.exception;
//podemos crear varias clases que lancen excepciones o una clase que valga para una cosas u otra, puedo agregr por ejemplo PasswordSecureException
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailAlreadyExistsException extends ResponseStatusException {
    //que un servicio pase un estado Http no tiene sentido, mejor dejar solo el message

    public EmailAlreadyExistsException(String message) {
        super(HttpStatus.CONFLICT, message); //estas intentando guardar email, pero ya existe datos con ese email CONFLICTO, problema que reace en el lado del cliente
    }
}
