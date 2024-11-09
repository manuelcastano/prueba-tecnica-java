# Consideraciones

El proyecto fue desarrollado con el framework de Springboot y se utilizo una base de datos MySQL de Google cloud,

Se hizo uso de programación funcional con funciones Lambda y la función Stream de las listas de java.

Se tuvo en cuenta las buenas prácticas en el desarrollo de endpoints Rest, como que el verbo HTTP sea el que nos diga implicitamente la función del endpoint.

Para desplegar esta aplicación localmente, es necesario correr los siguientes comandos de docker:

- docker pull manymanito/pruebajava:latest
- docker run -p 8080:8080 manymanito/pruebajava:latest

No es posible que hagan el build de la imagen con Docker localmente, ya que no pude subir el archivo con las credenciales para google cloud, ya que es información
confidencial restringida por github.

También hago entrega de una carpeta con la colección de requests, para ser utilizada en una aplicación como insomnia o postman.

