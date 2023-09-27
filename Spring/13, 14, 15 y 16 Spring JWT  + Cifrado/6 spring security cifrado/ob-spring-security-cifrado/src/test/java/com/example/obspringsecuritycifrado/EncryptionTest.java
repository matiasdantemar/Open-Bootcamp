package com.example.obspringsecuritycifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class EncryptionTest {

    /**
     * BCrypt genera su propio salt de 16 bytes
     * el resultado de cifrado con BCrypt será un string 60 caracteres
     * $a indica versión
     * $10 fuerza (de 4 a 31, por defecto 10) mientras mas fuerza mas costosa sera la validación de la contraseña y mas tiempo tardara
     * Los 22 siguientes caracteres son el salt geneado
     */
    @Test
    void bcryptTest(){
        BCryptPasswordEncoder passwordEnconder = new BCryptPasswordEncoder();
        
        String hashedPassword =  passwordEnconder.encode("admin");
        System.out.println(hashedPassword);

        boolean matches = passwordEnconder.matches("Admin", hashedPassword);
        System.out.println(matches);
    }

    @Test
    void bcryptCheckMultiplePassword(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        for (int i = 0; i < 30; i++){
            System.out.println(passwordEncoder.encode("admin"));

        }
    }

    @Test
    void pbkdf2() {
        Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(
                "",     // Secret, you can provide your own secret here
                2, // Iterations
                256,    // Hash width
                512     // Key length
        );
        for (int i = 0; i < 30; i++){
            System.out.println(passwordEncoder.encode("admin"));

        }
    }

    @Test
    void argon() {
        Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();
        for (int i = 0; i < 30; i++){
            System.out.println(passwordEncoder.encode("admin"));

        }
    }

    @Test
    void scrypt() {
        SCryptPasswordEncoder passwordEncoder = new SCryptPasswordEncoder();
        for (int i = 0; i < 30; i++){
            System.out.println(passwordEncoder.encode("admin"));

        }
    }


    @Test
    void springPasswordEncoders(){
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("argon2", new Argon2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        //no seguros:
        encoders.put("noop", NoOpPasswordEncoder.getInstance()); //deprecado, si no quiero usar ningun password encoder
        encoders.put("sha256", new StandardPasswordEncoder()); //deprecado, legacy

        //spring trabaja con esta interfaz para no tener que trabajar con un passwordEncoder en concreto por si el dia de mañana depreca uno, entonces permite cambiar sin complicaicones
        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", encoders);//recibe un algoritmo(texto) y un mapa en el cual voy a tener diferentes algoritmos

        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);
    }
}
