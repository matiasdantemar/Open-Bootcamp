Identifica las características principales de los patrones de diseño más conocidos, indica para qué valen y un caso de uso para cada uno de ellos.

Patrón Singleton: Se utiliza cuando se requiere que exista una única instancia de una clase en todo el sistema. Un caso de uso común es en la gestión de configuraciones globales, donde se necesita acceder a la misma instancia de configuración en diferentes partes del sistema.

Patrón Factory: Se utiliza para crear objetos de diferentes clases que implementan una interfaz común. Un caso de uso típico es en la creación de conexiones a bases de datos, donde se necesita crear instancias de diferentes tipos de conexiones según el tipo de base de datos a la que se quiere acceder.

Patrón Builder: Se utiliza para construir objetos paso a paso sin la necesidad de un constructor con múltiples parámetros. Un caso de uso común es en la construcción de objetos complejos, como la creación de un objeto de configuración con múltiples opciones personalizables.

Patrón Prototype: Se utiliza para crear nuevos objetos copiando un objeto existente en lugar de crearlos desde cero. Un caso de uso común es en la creación de instancias de objetos que tienen una configuración similar, donde se puede clonar un objeto existente y luego personalizarlo según las necesidades.

Patrón Decorator: Se utiliza para añadir funcionalidad a una clase existente sin modificar esa clase. Un caso de uso común es en la manipulación de objetos en tiempo de ejecución, donde se necesita agregar comportamiento adicional a un objeto existente sin afectar su estructura original.

Patrón Adapter: Se utiliza para permitir que clases con diferentes implementaciones funcionen coherentemente. Un caso de uso común es en la integración de sistemas o la utilización de bibliotecas externas, donde se necesita adaptar la interfaz de una clase existente para que sea compatible con otra clase o sistema.

Patrón Facade: Se utiliza para ocultar la complejidad de un subsistema proporcionando una interfaz simplificada. Un caso de uso común es en la creación de interfaces de usuario o APIs que brindan acceso a un conjunto de funcionalidades complejas, donde se desea simplificar el uso y reducir la dependencia directa del cliente con las partes internas del subsistema.



Crea una pequeña aplicación implementando el patrón Singlenton y demuestra que, efectivamente, no crea instancias nuevas. Puedes tomar la sesión 7 como referencia.