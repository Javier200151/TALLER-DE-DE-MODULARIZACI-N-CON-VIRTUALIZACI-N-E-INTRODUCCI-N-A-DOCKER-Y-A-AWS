# TALLER DE DE MODULARIZACIÓN CON VIRTUALIZACIÓN E INTRODUCCIÓN A DOCKER Y A AWS

El taller es una aplicación web usando Spark java. Esta aplicación se construyo en un container
para docker para la aplicación, se desplegó y se probó en una maquina local. Por ultimo se desplegó
el contenedor que se creo en una maquina virtual en AWS con Docker instalado

## Autor
* Javier Esteban López Peña

## Contrucción
* Visual Studio Code - Editor de código y ambiente de desarrollo
* Maven - Gestor de dependencias
* BootStrap

## Docker https://hub.docker.com/repository/docker/javier3005/firstwebappspark

## Prerequisites
* Docker - Container Manager
* Java 8 - Development Environment
* Git - Version Control System
* Spark - Micro framework for creating web applications in Java 8

## Screenshots

Pantalla Principal

![](img/main.PNG)

Insertar dato

![](img/insert.PNG)

Ultimos 10 Logs

![](img/logs.PNG)

AWS Despliegue

![](img/aws.PNG)

## Instrucciones

1. Clonar el repositorio

```
git clone https://github.com/Javier200151/TALLER-DE-DE-MODULARIZACI-N-CON-VIRTUALIZACI-N-E-INTRODUCCI-N-A-DOCKER-Y-A-AWS.git
```

2. Compilar/Construir el proyecto

```
mvn clean install
```

3. Ejecutar el docker compose

```
docker-compose up -d
```

4. Ahora la aplicación deberia funcionar al correrla con

```
java -cp "target/classes:target/dependency/*" co.edu.escuelaing.virtualization.dockerdemo.SparkWebServer
```

## Arquitectura

![](img/roundrobin.PNG)

Esta arquitectura es a lo que se refiere a el APP RoundRobin.
El usuario se comunica con la instacia RoundRobin, lo distrubuye a traves de las tres instancias que
tiene LogService y por ultimos este componente se comunica con mongodb, nuestra base de datos
