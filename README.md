# Documentación de Arquitectura de API de Exchange Rate

## Introducción 

La API de Exchange Rate proporciona tasas de cambio actualizadas entre diferentes monedas. Esta documentación detalla la arquitectura subyacente de la API, incluidos los componentes principales, las tecnologías utilizadas y los flujos de datos.

## Arquitectura General 

La arquitectura de la API de Exchange Rate sigue un modelo de arquitectura basado en microservicios para garantizar la escalabilidad y la modularidad del sistema. Consiste en los siguientes componentes principales:

1.  **API Gateway:** El API Gateway actúa como punto de entrada único para la API y maneja la autenticación, la autorización, el enrutamiento de solicitudes y la traducción de protocolos.
    
2.  **Microservicios:** Los microservicios individuales proporcionan funcionalidades específicas de la API, como la obtención de tasas de cambio, la conversión de moneda, etc.
    
3.  **Base de Datos:** Se utiliza una base de datos para almacenar y recuperar datos relevantes, como las tasas de cambio históricas.
    

## Tecnologías Utilizadas 

La API de Exchange Rate está construida utilizando las siguientes tecnologías:

**Lenguaje de Programación:** Java 
**Framework de Desarrollo:** Spring Boot para la implementación de microservicios. 
**Base de Datos:** H2 para almacenar datos de tasas de cambio. 
**API Gateway:** Azure Api Management para gestionar las solicitudes entrantes y dirigirlas a los microservicios correspondientes. 
**Autenticación y Autorización:** JSON Web Tokens (JWT)

### Descripción de Componentes

1.  API Gateway El API Gateway se encarga de dirigir las solicitudes entrantes a los microservicios correspondientes y de gestionar la autenticación y autorización de los usuarios.
    
2.  Microservicios Los microservicios se implementan para proporcionar funcionalidades específicas de la API, como la obtención de tasas de cambio o la conversión de moneda. Cada microservicio se despliega de manera independiente y se comunica con la base de datos para acceder a los datos necesarios.
    
3.  Base de Datos Se utiliza H2 como base de datos para almacenar y recuperar datos de tasas de cambio. La base de datos se escala horizontalmente para manejar grandes volúmenes de datos y garantizar la disponibilidad del sistema.
    

## Consideraciones de Seguridad 

Para garantizar la seguridad de la API de Exchange Rate, se implementan las siguientes medidas:

Autenticación y autorización basadas en JWT. 
Validación de datos de entrada para prevenir ataques de inyección de código.

## Conclusiones 

La arquitectura de la API de Exchange Rate está diseñada para ser escalable, segura y de alto rendimiento. El uso de microservicios permite una fácil escalabilidad y mantenimiento del sistema, mientras que las tecnologías seleccionadas garantizan la seguridad y la eficiencia de la API.

Esta documentación proporciona una visión general de la arquitectura subyacente de la API de Exchange Rate, lo que facilita su comprensión y mantenimiento por parte de los desarrolladores y otras partes interesadas.


