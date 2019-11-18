# Gestor_Cartera
Administra la cartera de clientes de un asesor financiero de seguros


Desarollador:
Juan Sanchez Sanchez

Asesor:
Aldo Daniel Sanchez Bastida


[Grails]: Framework para desarrollo web

[Groovy]: Lenguaje de programación basado en la JVM de Java 




## Version 1.0 (Beta) - INESTABLE
Para configurar el proyecto hasta su version actual correctamente
siga las siguientes instrucciones

Windows
- Abrir una cmd o Simbolos del sistema (Si se tiene la version de **git bash** es RECOMENDADO)
- Ejecutar los siguientes comandos
    - $ __git reset --hard__
    - $ __git checkout nuevaEstructura__
    - $ __git pull__
        - ..ingresar datos de git en caso de solicitarlos..
    
- Eliminar la base de datos (cartera.sql)  
    -phpMyAdmin: selecciona base de datos y eliminar
    -mysql client cli:
        -mysql>__drop database **cartera**__
        -mysql>__create database **cartera**__
    - se crea la base de datos cartera o se purga la ya existente para no tener problemas con el plugin de Grails
   

[Grails]: https://grails.org/
[Groovy]: http://groovy-lang.org/