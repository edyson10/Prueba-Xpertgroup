# PRUEBA XPERT GROUP #

Prueba técnica – Desarrollador Backend Java

### Intrucciones ###

El tiempo ideal de ejecución de la prueba estø entre 3 y 4 horas. Luego de recibir la prueba debes enviar tus resultados en møximo 24 horas. La prueba debe ejecutarse usando: Java Spring Boot, Mongo DB.
¡Buena suerte!

### Backend ###

El BackEnd debe tener 1 controlador: gatos e imøgenes. Se debe crear un servicio por cada controlador y los modelos necesarios para el intercambio de datos a trav«s de REST, ademøs de implementar pruebas unitarias y buenas prøcticas de desarrollo (SOLID, Clean Architecture).

Los controlador deben conectarse a la API pública [thecatapi](https://thecatapi.com/) 

* Puede usar la key

live_JBT0Ah0Nt12iyl2IpjQVLDWjcLk0GQwf4zI9wBMfmfejKmcC31mOJp4yJz5TsOUP

### Controlador Gatos ###

El controlador debe tener 3 acciones:

* GET /breeds :

Debe retornar una lista de las razas de gatos.

* GET /breeds/:breed_id

Debe retornar ÿnicamente la raza de gato solicitada

* GET /breeds/search:

Debe retornar la información asociada a la consulta realizada de acuerdo a los parametros.

Cada una de las acciones corresponde a un punto de entrada de TheCatAPI y por ende no requiere del uso de base de datos.

Debe crear el archivo Dockerfile para contenerizar el API y ejecutarse en Docker.


### Solución ###

Pasos para ejecutar el proyecto:

* Clonar eeste repositorio.
* Importar la coleccion postman para realizar dichas pruebas.
* Abrir el proyecto en algún IDE de su preferencia.
* Ejecutar el proyecto y probar mediante postman u otro programa cliente para probar los endpoint.
* (Opcional) Ejecutar este comando en la terminal desde la raís del pryecto para levantar el proeycto en docker.

Comando para ejecutar la imagen docker:

docker build -t catapi:1.0 .

Comando para iniciar el contenedor y exponer el puerto 8080:

docker run -p 8080:8080 catapi:1.0
