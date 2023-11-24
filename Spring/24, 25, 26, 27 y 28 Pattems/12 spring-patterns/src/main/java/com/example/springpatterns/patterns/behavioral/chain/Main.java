package com.example.springpatterns.patterns.behavioral.chain;

import com.example.springpatterns.patterns.behavioral.chain.processor.CSRFAuthenticationProcessor;
import com.example.springpatterns.patterns.behavioral.chain.processor.JWTAuthenticationProcessor;
import com.example.springpatterns.patterns.behavioral.chain.processor.OAuthAuthenticationProcessor;
import com.example.springpatterns.patterns.behavioral.chain.provider.CSRFProvider;
import com.example.springpatterns.patterns.behavioral.chain.provider.JWTAuthProvider;
import com.example.springpatterns.patterns.behavioral.chain.provider.OAuthProvider;

// Cadena de responsabilidad: se crean varias clases que son ejecutoras, procesadores o manejadores que llevan a cabo una operacion, si una de ellas no es capaz de resolver operacion
// pasa a la siguiente y a su vez a la siguiente... se crea una especie de cadena de responsabilidad la cual concatenamos por asi decirlo objetos,
// csrf = new CSRFAuthenticationProcessor(oauth); estaria vinculado al siguiente
// oauth = new OAuthAuthenticationProcessor(jwt); este vinculado al siguiente y asi.. estando la oportunidad de que si uno no es capaz de comprobar algo se lo pase al siguiente
//Una cadena de responsabilidades en que unas veces va a preguntar una cosa u otras veces otra, en algunas ocaciones va a ejecutar lo suyo y en otras lo otro, dependiendo como lo
//programe en los filtros estoy pasando la misma peticion a todos, la misma peticion pasa al siguiente y al siguiente... en cualquiera de ello se puede bloquear, terminar proceso, capturar.
// Ejemplo los filtros token, Oauth, CSRF, usuario y contraseña, cabeceras que tienen que estar en la peticion por cada peticion, etc, se comprueba la seguridad, hasta que un
// procesador sea capaz de resolver lo que necesita

public class Main {

    public static void main(String[] args) {

        AuthenticationProcessor jwt = new JWTAuthenticationProcessor(null); //termina con la llamada para que no haga mas llamadas, es el primer objeto no puedo unirlo a nada
        AuthenticationProcessor oauth = new OAuthAuthenticationProcessor(jwt); //le paso el objeto que acabo de crear jwt, es el segundo objeto ya se puede unir con el anterior
        AuthenticationProcessor csrf = new CSRFAuthenticationProcessor(oauth); //se puede unir con el anterior

//en base a la request se extrae el token
        csrf.isAuthorized(new CSRFProvider()); //le paso CSRFProvider() o lo necesario para hacer sus comprobaciones, tokem, request etc, y dependiendo deja seguir adelante o se captura
//pasa a la siguiente ya que JWT no esta pensado para csrf, no tiene los datos necesario para que csrf haga todas las comprobaciones
        csrf.isAuthorized(new JWTAuthProvider()); //si le pasara otro proceso en vez de JWTAuthProvider va a verificar que ese JWT no le corresponde y lo deja pasar al siguiente proceso
//pasa al siguiente proceso hasta encontrar a quien se encarga de ejecutar toda la responsabilidad
        csrf.isAuthorized(new OAuthProvider());



        //El csrf funciona cuando le llega el parametro que funcione para el
    }
}
