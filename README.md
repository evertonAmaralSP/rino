HipoRino Reports
===========

Servidor de Rastreamento de eventos e Analise dados


Description
---------------

HipoRino Reports é um servidor em desenvolvimento. Feito para analisar fluxo de dados.


Requirements
-------------------

 * Java =< 6.0
 * Maven2 
 * mongodb
 * RabbitMQ


Installation
--------------

    git clone git@github.com:evertonAmaralSP/rino.git
    cd rino

    # Use mvn para installar as dependencias
    mvn install

Running HipoRino Reports
------------------------------

Start aplicação:

    mongod > /tmp/mongo.log &   (na pasta que foi instalado)
    habbitmqmq-server (na pasta que foi instalado)
    mvn jetty:run
