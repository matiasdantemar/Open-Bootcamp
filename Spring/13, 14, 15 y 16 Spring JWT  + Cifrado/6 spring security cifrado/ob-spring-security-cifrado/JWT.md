## JWT Json Web Token, credenciales
https://jwt.io/introduction

es un estandar abierto que permite transmitir informacion entre dos partes de forma segura: 

cliente - servidor

react..angular - aplicacion de spring boot

JSON Web Token

## Funcionamiento Session 

### mecanismo estandar que se ha utilizado antes de los tokens

1. Cliente envia una petición  a un servidor (/api/login) el usuario y contraseña viajan cifrado por un certificado SSL cidfrado
2. Servidor valida el username y password, si no son validos devolvera una respuesta 401 unauthorized,
3. Servidor valida el username y password, sí sí son validos se almacena el usuario en session (session: conjunto de peticiones seguidas durante un determinado tiempo)
4. Se genera un cookie en el cliente
5. En proximas peticiones se comprueba que el cliente esta en session

Desventajas:

* La informacion de la session se almacena en el servidor, lo cual consume recursos.

### Funcionamiento JWT

1. Cliente envia una petición  a un servidor (/api/login) el usuario y contraseña viajan cifrado por un certificado SSL cidfrado
2. Servidor valida el username y password, si no son validos devolvera una respuesta 401 unauthorized, 
3. Servidor valida el username y password, si si son validos entonces genera un token JWT utilizando una secret key (almacenada en application.properties se puede leer de una variable de entorno dentro del sistema)
4. Servidor devuelve el token JWT generado al cliente
5. Cliente envía peticiones a los endpoints REST del servidor utilizando el token JWT en las cabeceras
6. Servidor valida el token JWT en cada peticion y si es correcto permite el acceso a los datos

Ventajas:

* El token se guarda en el cliente, de manera que consume menos recurso en el servidor, permitiendo mayor escalabilidad (poder brindar mas servicios a mas usuarios, tener mas recursos)

Desventajas:

* El token esta en el navegador, no se puede deslogear, no podriamos invalidarlo desde la fecha de expiracion asignada cuando se creó
    * Lo que se permite es dar la opcion de logout, lo cual simplemente BORRA el token
 
## Estructura del token JWT

consta de 3 partes separadas por un punto (.) y codificadas en base 64 cada una:

1.  Header (es una sección que contiene metadatos sobre el token)

alg: algoritmo de firma que se esta utilizando

typ: tipo de token

```json
{
  "alg": "HS512",
  "typ": "JWT"
}

```

2. Payload (información, datos de usuario, no sensibles)

```json
{
  "name": "Matias Martinez",
  "admin": true
}
```

3. Signatuera (funcion) se codifica en base 64 el punto 1 y 2 

```
{
HMACkSHA256(
base64UrlEncode(header) + "." + base64UrlEncode(payload), secret
  )
}
```

el secret se almacena en el servidor, estaria securizado

Ejemplo del token generado 

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```

En el User-Agent envia el token JWT en las cabeceras:

```
Authorization: bear<token>
```

Configuracionb Spring

Crear proyecto Spring Boot con 

* Spring Security
* Spring Web
* Spring Boot Devtools
* Spring Data JPA
* PostgreSQL
* Swagger-ui 
```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.0.3</version>
</dependency>
```
* Dependencia JWT (se añade manualmente en el pom.xml)

```xml

<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt</artifactId>
  <version>0.9.1</version>
</dependency>
```