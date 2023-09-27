## CIFRADO

Es el proceso de codificar la información de su representación original (texto plano)
a texto cifrado, de manera que solamente puede ser descifrado utilizando una clave.

Historia del cifrado:

1. Almacenar contraseñas en texto plano
2. ALmacenar contraseñas cifradas con una función hash
3. ALmacenar contraseñas cifradas con una función hash + salt (salt es un valor aleatorio)
4. ALmacenar contraseñas cifradas con una función adaptativa + factor de trabajo 
(el calculo o cifrado descifrado de contraseñas sea costoso, que tarden mas de 1 segundo en realizarse)

La seguridad se gana haciendo que la validación de contraseñas sea costoso computacionalmente.

## Algoritmos de Spring Security

* Bcrypt
* PBKDF2
* scrypt
* argon2