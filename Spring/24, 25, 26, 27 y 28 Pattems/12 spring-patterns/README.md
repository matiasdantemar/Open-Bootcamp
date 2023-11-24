# Patrones de Diseño

Los patrones de diseño no son código en sí mismos; más bien, son una forma de estructurar el código con el objetivo de resolver problemas comunes en el desarrollo de software.

En esencia, los patrones de diseño son una guía sobre cómo organizar las clases que ya se han programado o que se planea programar para llevar a cabo una tarea específica. Ya sea para la construcción de objetos, la adición de funcionalidades a objetos existentes, la ejecución de algoritmos de manera dinámica, la asignación de responsabilidades, el control del comportamiento de un objeto desde otro, o la notificación a otros objetos desde uno principal, los patrones de diseño proporcionan una estructura de clases definida para cada caso.

Por ejemplo, se podría crear una interfaz que declare una serie de métodos y luego implementar clases que representen algoritmos distintos, como métodos de pago (PayPal, Bitcoin, etc.). Dependiendo de la elección del usuario, se puede sustituir uno por otro en tiempo real, lo que equivale a reemplazar un algoritmo por otro, y este es un ejemplo de la aplicación del patrón Estrategia.

## Patrones a explorar:

- Plantilla (Template) (Method template) HtmlTemplate
- Cadena de responsabilidad (Chain of Responsibility) Autenticacion, como httpSecurity
- Estrategia (Strategy) Metodo de pago, diferentes metodos de pago
- Proxy  Intermediario Imagen pesada
- Constructor (Builder) Constructores con muchos parametros
- Observador (Observer) Notify weather observers, notifica el cliva a los observadores
- Decorador (Decorator) Imagen con decoradores, evita la herencia multiple

## Tipos de patrones (Catergorias)

- **Patrones Creacionales (reational):** Se centran en cómo se deben construir objetos, especialmente objetos complejos. son los mas esenciales
  - Constructor (Builder)

- **Patrones Estructurales (structural):** Se enfocan en la estructura y disposición de los objetos cuando interactúan entre sí. Ayudan a gestionar sistemas compuestos por múltiples componentes interrelacionados.
  - Proxy
  - Decorador: Añade funcionalidades a objetos existentes, como aplicar filtros a una imagen, de manera incremental.

- **Patrones de Comportamiento (behavioral):** Se centran en cómo funcionan y se comportan los objetos, es decir, cómo se ejecutan sus métodos.
  - Plantilla (Template)
  - Cadena de responsabilidad (Chain of Responsibility)
  - Estrategia (Strategy)
  - Observador (Observer)

## Objetivos generales de todos los patrones de diseño

Los patrones de diseño persiguen varios objetivos generales:

- **Reducir el acoplamiento:** Esto se logra al minimizar la dependencia de las clases entre sí, lo que facilita realizar cambios en una clase sin afectar en gran medida a otras, evitando la creación de un código complejo y difícil de mantener.

- **Reutilización de código:** Permiten la reutilización eficiente del código, evitando la duplicación y fomentando la construcción de componentes y clases genéricas.

- **Flexibilidad:** Los patrones hacen que el código sea más flexible y adaptable al cambio, permitiendo la sustitución de componentes y comportamientos de manera eficiente.

- **Escalabilidad:** Facilitan la escalabilidad del sistema, permitiendo la adición de nuevas funcionalidades y componentes sin la necesidad de reestructurar toda la arquitectura.

- **Eficiencia:** Al aprovechar soluciones probadas y establecidas, se mejora la eficiencia del desarrollo y se reduce la posibilidad de errores.

- **Estándares de buenas prácticas:** Los patrones de diseño son ampliamente reconocidos en la comunidad de desarrollo de software, lo que promueve una comprensión común y el uso de buenas prácticas.

- **Favorece el testing:** Los patrones de diseño también favorecen el proceso de desarrollo centrado en pruebas, como el Test Driven Development (TDD) y el Behavior-Driven Development (BDD), al facilitar la estructuración del código de manera que sea más fácil de probar y mantener, contribuyendo así a una mayor calidad del software.


# Recursos de interés 

https://refactoring.guru/design-patterns/catalog

https://github.com/eugenp/tutorials/tree/master/patterns

https://www.baeldung.com/spring-framework-design-patterns

## 1. Patrón Plantilla
Permite

* Desacoplar código 
* Reutilizar código

## 2. Patrón cadena de responsabilidad 

En Spring Security tenemos los filtros (ejemplo para extraer el token de JWT se podrian añadir mas filtros para comprobar 
la responsabilidad) se agregua un filtro y luego otro... hasta que se detecta que algo funciona mal y corta la peticion

Objetivos:
* Reducir el acoplamiento: Desacoplar codigo
* Flexibilidad al permitir cambiar responsabilidad: Cambiar un filtro por otro en cualquier momento
* Componer objetos que en su totalidad resuelven una unidad de trabajo: Al llevar al cabo una tarea preceso a partir de concatenar 
una serie de objetos se evalua algo y se resuelve lo que seria el problema

A tener en cuenta: 
* se les llama Manejadores o filtros

* Cada elemento de la cadena de responsabilidad (Manejador) tiene su propia implementación: Cada uno proporciona su propio codigo para hacer una cosa u otra
* Cada manejador hace referencia al siguiente manejador: Para que la cadena continue asi pase al siguiente Manejador, siguiente...
* No deberían formarse ciclos recursivos: Que las clases se llamen ciclicamente y se convierta en un ciclo infinito

## 3. Patrón estrategia

Permite utilizar algoritmos de forma dinámica. Ejemplo metodo de pago Paypal, tarjeta bancaria, reembolso, en funcion de lo que eligio el usuario se ponga un algoritmo u otro, en vez de tener un fijo que el pago siempre sea de una manera, se reemplaza un comportamiento por otro

Ventajas:

* Cambiar un algoritmo o comportamiento en tiempo de ejecución (runtime): Que no tenga que parar la aplicacion, compilar codigo para poder cambiar un comportamiento, todo se realiza en tiempo de ejecucion, se aislan la implementacion de los algoritmos
* Clara separación de comportamientos, cada algoritmo representa una estrategia: 
* Dentro de los Principios SOLID: Implementamos el principio Open Closed. Podemos introducir nuevas estrategias sin alterar el código original. No hay que modificar el codigo original por que haya un nuevo metodo de pago, se añade un nuevo algoritmo que es una clase y esa clase se reemplaza una implementacion por otra, se puede hacer con inyeccion de dependencia, implementacion sencilla como crear una nueva clase y cambiar como se inyecta para que use un @Bean u otro @Bean

Desventajas:
* Se puede llegar a complicar al tener que introducir nuevas clases / interfaces: Tener que estar creando clases nuevas constantemente (BoilerPlate dicho de manera informal) es inflacion de clases 
* Si los algoritmos no son muy distintos puede no tener sentido hacer tanto código.
* Los clientes(clases) que la utilizan tienen que ser conscientes de la existencia de las diferentes estrategias, por ejemplo si quiero pagar con paypal voy a necesitar que tengo que pasar un objeto de tipo paypal strategy, por lo tanto tiene que tener cierta nocion de que existe ese metodo de pago
* La programación funcional permite simplificar el uso del patrón estrategia al poder pasar comportamiento(o metodos) por parámetros por lo que no haría falta crear nuevas clases evitando el uso del patrón estrategia evitando el uso del patron estrategia

## 4. Proxy

Carga de objeto pesado: imágenes, conexiones a base de datos (contexto de persistencia). Que un objeto se haga pasar por otro.

La carga de estos objetos se difiere todo lo posible. Ejemplo la carga de Beans en memoria. diferir (en vez de arrancar al comienzo de la aplicacion se difiere hasta que se utilice)

Client --> Objeto (clase o objeto que necesito)

si ese objeto no esta disponible al cliente le va a dar un error, puede ser un objeto muy pesado de cargar o no se a inicializado se agrega entre medio un PROXY o clase intermedia que se va a objeto, el proxy inicializa el objeto lo carga en memoria cuando sea necesario e interactua con el cliente como si fuera el propio objeto, para que el cliente no interactue directamente con el objeto y le pueda dar un error si el objeto no esta creado, llamando al proxy que tendra las comprobaciones necesaria para verificar si esta cargado sino lo carga lo prepara o lo que tenga que realizar.

Client --> Proxy --> Objeto

Es usado en objetos pesados, Ejemplos: SessionFactory (Hibernate), EntityManagerFactory (JPA). son tipos de datos.

Ventajas:

* Permite gestionar el ciclo de vida del objeto pesado sin que el Client (cliente) tenga noción de ello sin que se entere. quien utiliza el objeto solo pide el objeto y ya esta, el como se cree, como se inicialice, como se lo cargue en memoria, le da igual, eso lo hace el proxy intermedio
* El proxy funciona incluso aunque el objeto pesado no haya sido inicializado, deje de funcionar o no esté disponible.
* Principios SOLID: principio Open Closed. Podemos introducir nuevos objetos pesados. a ese proxy podria agregarle cosas y el cliente no se enteraria, podria introducir objetos pesados o reemplazar algun proxy, etc.


Desventajas:

* Diferir la carga de un objeto no siempre será lo mejor si se necesita de inmediato, si estoy difiriendo la carga por temas de rendimiento pero lo necesito si o si ya puede ser un problema.
* Introducción de nuevas clases puede dar lugar a complejidad, siempre es recomendable que las clases sean pequeñas que hagan pocas cosas y si tengo que agregar nuevas responsabilidades hacerlo en clases separadas eso es lo idoneo, pero tambien es cierto que al tener demasidas clases, interfaces, clases abstractas, metodos por todo lado hace que el codigo sea bastante complicado

## 5. Builder o constructor

Cuando tengo una clase con muchos atributos y necesito múltiples formas de crear objetos haciendo uso de constructores sobrecargados. (en una clase podemos tener mas de un constructor, vacio con uno o varios parametros, la sobrecarga de metodos es ).

Tener todas las posibles combinaciones de constructores puede llegar a ser muy complejo de mantener. Si tengo un objeto una clase y quiero crear objetos a partir de esa clase y tiene 20 atributos, quiero crear cada vez de manera distinta un objeto con 3 atributos, con 10, 15, 3 y otro orden se vuelve complejo.

Utiliza fluent programming style para lograr construir los objetos: Devolver `this` al final de cada método setter.

Ventajas:
* Permite construir objeto paso a paso encadenando llamadas a métodos en una misma línea (parecido a lo que hice con http security que va llamando a un metodo y me lo permite concatenar). parecido a chain of responsability parecido pero no exactamente lo mismo
* Permite crear objetos cada vez con diferentes atributos sin necesidad de tener un constructor para cada manera de crearlos.
* Principios SOLID: principio SRP (Single Responsibility Principle Una sola responsabilidad) al aislar la forma de construir el objeto a los clientes. El que necesite crear el objeto ya no tiene que andar utilizando el operador new pasandole muchos parametros, sino lo haria con unas series de metodos como cuando hice con https. falicitando la lectura, comprension, que no me equivoque, porque al crear un constructor con varios parametros es muy facil que me equivoque que existan dos seguidos con el mismo tipo de dato y que me confunda en el orden, no me da un error de sintaxis (errores mas complicados de detectar).

Desventajas:
* Requiere crear una nueva clase Builder lo cual puede añadir complejidad a la clase original. duplico atributos, si en futuro pienso agregar mas atributos tengo que agregarlo en ambos lados

## 6. Observer

Cuando tenemos una asociación de tipo one to many (uno a muchos) entre clases y queremos que cuando se actualice el objeto del lado one se notifique automáticamente a los objetos del lado many.

Por ejemplo:

Un canal de YouTube sube nuevo vídeo y se notifica automáticamente a todos sus suscriptores. o sea el suscriptor no notifica al canal de youtube sino es el canal es quien notifica, la comunicacion es unidireccional.

Tendria en el cado de POO un objeto que dentro tendria un atributo que seria una lista, la clase Youtube con un atributo que seria suscriptores, para que cuando se produzca la subida de un nuevo video se notificaria a los suscriptores a los asociados a ese canal.

Ventajas:
* Principios SOLID: principio Open Closed. Podemos introducir nuevos objetos suscriptores, sin necesidad de cambiar la estructura existente.
* Establecer relaciones o asociaciones entre objetos en tiempo de ejecución (runtime), añadir, quitar suscriptores.

Contras:
* Puede ser que no se siga un orden a la hora de notificar a los suscriptores (observadores) y se haga de manera aleatoria

## 7. Decorator

Agregar nueva funcionalidad a objetos existentes. Decorar objetos con nuevas funcionalidades.

Ejemplo: muñeca rusa (se le va agregando una muñeca y luego otra y otra...). Un objeto se puede decorar con funcionalidad y a su vez el resultado se le puede seguir aplicando otros decoradores. 

En vez de modificar un objeto el codigo dentro del metodo creo un decorador que es otra clase que va a envolver a esta otra y en consecuencia va a agregarle otra funcionalidad (mas comportamientos) antes o despues de la ejecucion de determinado metodo, es importante en auditorias se va a ejecutar un metodo de mi servicio, controlador se le agrega una funcionalidad de que antes de que eso ocurra haga el registro de que eso esta pasando en una BD o un archivo, que envie un mensaje o realice otra accion. Intercepta un metodo y ejecuta algo antes de que se ejecute ese metodo.

Ventajas:

* Extender la funcionalidad de objetos existentes sin necesidad de utilizar herencia, la herencia esta bien pero a veces puede llegar a complicar un poco las cosas, teniendo que crear varias jerarquias 
* Agregar nuevas responsabilidades o comportamientos a un objeto en tiempo de ejecución (runtime), tengo un objeto y le agrego un metodo, le voy a agregando funcionalidad y luego otro y otro.
* Múltiples comportamientos sobre un mismo objeto por medio de utilizar más de un decorador a la vez. tengo un objeto decorado y a su vez le aplico otrao decorador.
* SRP Principio de una sola responsabilidad, cada decorador sería una clase y se centraría en una única responsabilidad. otra clase una responsabilidad y no tenerlas todas en una sola clase quedando un codigo muy complejo que al final no es facil de gestionar.

Desventajas:

* Complejidad cuando hay muchos decoradores, complejidad a la hora de implementar el patrón al tener varias clases abstractas, dificil de enteder porque al final tengo que envolver una clase dentro de otra, un objeto envuelve a otro que envuelve a otro haciendo que sea complicado de entender.
* Difícil quitar eliminar un decorador que está dentro de otro decorador. decorador que esta mas al centro mas al fondo implica rehacer otra vez el objeto sin ese decorador llevando mas trabajo.
* El orden de los decoradores puede ser importante y podría ser difícil tener que cambiarlo o alterarlo. tendria que sacar todo para volver a montar los decoradores
* Ejemplo la muñeca rusa si ya meti una muñeca dentro de otra resulta que me confundi y quiero poner una diferente tengo que desmontar todas las que eh puesto por encima y cambiarlo todo



Como vemos no existe un Patron perfecto, si no que son pequeñas soluciones a posibles problemas comunes que encontramos en programacion y que cada una aporta su propio valor, esto ya es decision del programador el que tiene que decidir cual aplica mejor en cada caso y a lo mejor no aplica un patron en concreto sino que una variacion del mismo o dos variaciones del mismo o varios patrones mezclados eso es decision del programador en base a su contexto y a lo que tenga que desarrollar que patron podria encajar o que ideas de patrones podrian servir para programar, a lo mejor extrae idea de varios patrones sin llegar a implementar un patron en concreto haciendolo de su propia manera pero parecido a como lo harian un par de patrones, cada escenario sera un mundo, cada escenario de programacion es diferente.

