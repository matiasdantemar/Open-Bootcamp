## Medidad de seguridad en spring

## CSFR

* Cross-Site Request Forgery
Falsificacion de solicitudes de sitios, un atacante va a intentar hacer que una persona haga click en un enlace que seria potencialmente malicioso

Es un ataque que hace que el usuario final ejecute acciones no deseadas 
en una aplicacion web en la que estan autenticados actualmente.

Se lleva a cabo mediante ingenieria social un atacante puede engañar usuarios en una aplicacion web 
para que ejecuten acciones que elija el atacante.

## XSS

Secuencias de comandos entre sitios

Se inyecta una secuancia de comandos malitencinados maliciosos en un sitio web por lo general a traves de un input
para enviar codigo malicioso.

Por ejemplo enviar un script de JavaScript, que sea capaz de embeber la base de datos, guardar en la Base de Datos para cuando
se muestran anuncion, publicidades, salga un script malicioso que cuando logra que el usuario pinche en un banner y le hackeen

Medidas

* Control de caché
* Opciones de tipo de contenido o Content-Type
* Seguridad de transporte estricta de HTTP
* Opciones X-Frame
* Proteccion X-XSS (cross site scripting)

Spring habilita todas estas opciones por defecto, todo este tipo de medidas

## SQL ijection

Cuando tenemos una query

```sql
"select * from table where name='" + name + "';" 
```
name seria una variable de java y la estamos concatenando al sql porque no escapamos los parametros

```sql
"select * from table where name='" + 'Pepito or 1=1;delete * from users;' 
```
en vez de poner un nombre ponen una sentencia sql y usan algun escape para que se cierre la comilla y el resto siga siendo consulta SQL
pueden llegar a lograr que se ejecute una sentencia que borrara una tabla o extraer informacion de la tabla

Sanitizar la entrada a traves de parametros:


Para mas informacion visitar el sitio web OWASP para ver las medidas de seguridad, donde tratan temas de las posibles vulnerabilidades mas tipicas del entorno web

Este es el enlace al sitio web oficial de OWASP:
[OWASP](https://owasp.org/)

Este es el enlace al Top Ten de OWASP:
[Top Teen](https://owasp.org/www-project-top-ten/)