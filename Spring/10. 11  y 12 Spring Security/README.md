Ejercicio 1

Crear un proyecto Spring Boot con las dependencias:

H2

Spring Data JPA

Spring Web

Spring Boot dev tools

Crear una clase HelloController que sea un controlador REST. Dentro de la clase crear un método que retorne un saludo. Probar que retorna el saludo desde el navegador y desde Postman.

Ejercicio 2

Dentro de la misma app crear las clases necesarias para trabajar con "ordenadores":

Laptop (entidad)

LaptopRepository (repositorio)

LaptopController (controlador)

Desde LaptopController crear un método que devuelva una lista de objetos Laptop.

Probar que funciona desde Postman.

Los objetos Laptop se pueden insertar desde el método main de la clase principal.

Ejercicio 3

Crear un método en LaptopController que reciba un objeto Laptop enviado en formato JSON desde Postman y persistirlo en la base de datos.

Comprobar que al obtener de nuevo los laptops aparece el nuevo ordenador creado.

Ejercicio 4

Implementar los métodos CRUD en el API REST de Laptop creada en ejercicios anteriores.

Los métodos CRUD:

findAll()

findOneById()

create()

update()

delete()

deleteAll()

Ejercicio 5

Implementar swagger sobre el API REST de Laptop y verificar que funciona en la URL: http://localhost:8081/swagger-ui/

Ejercicio 6

Crear casos de test para el controlador de Laptop desde Spring Boot. Con click derecho dentro del código de la clase LaptopController utilizar la opción Generate > Test para crear la clase con todos los tests unitarios e implementarlos siguiente el proceso visto en clase.