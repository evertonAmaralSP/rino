Rino Reports
===========

Servidor de Rastreamento de eventos e Analise dados


Description
---------------

Rino Reports é um servidor em desenvolvimento. Feito para analisar fluxo de dados.


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
    
Contributors
------------

 * Everton Amaral <everton.amaral@gmail.com>
 * Leandro Miserani <leandro.miserani@hiporino.com>


License
-------    

  (The MIT License)

  Permission is hereby granted, free of charge, to any person obtaining
  a copy of this software and associated documentation files (the
  'Software'), to deal in the Software without restriction, including
  without limitation the rights to use, copy, modify, merge, publish,
  distribute, sublicense, and/or sell copies of the Software, and to
  permit persons to whom the Software is furnished to do so, subject to
  the following conditions:

  The above copyright notice and this permission notice shall be
  included in all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND,
  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
  IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
  CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
  SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
