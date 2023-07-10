## Spring Boot

Proyecto Spring Boot con las siguientes dependencias / starter:
*   H2
* Spring Data JPA
* Spring Web
* Spring Boot Dev Tools

Aplicacion API REST con acceso  a base de datos H2 para persistir la infórmacion.

El acceso se puede realizar desde Postman o Navegador.

## Entidad Book

1. Book clase para crear las tablas y campos en BD
2. BookRespository interface para poder guardar en BD
3. BookController clase para poder acceder a traves de una solicitud HTTP
   1.  Buscar todos los libros
   2.  Buscar un solo libro
   3.  Crear un solo libro
   4.  Actualizar un libro existente
   5.  Borrar un libro
   6.  Borrar todos los libros