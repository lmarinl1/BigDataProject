# Informe de Análisis 
## Problema a resolver
**Contexto:** El surgir de las redes sociales ha traido consigo un cambio en la manera en la que las empresas se relacionan con sus clientes, habilitando una comunicación más rápida y directa, además de las transformaciones en las estrategias de publicidad y mercadeo que ponen en práctica. Por otra parte es importante resaltar que el costo  es mucho menor cuando se habla de utilizar  [las redes sociales](https://estelladigital.com/los-seguidores-followers-las-redes-sociales-nacen-se-hacen/ "followers en redes sociales")  para anunciarse, que hacerlo por medios tradicionales como la radio y la televisión.[1]

Un sin número de estudios se ha realizado en torno a las redes sociales, por aquí tenemos unos resultados interesantes:
> -   **84%** de los usuarios de internet acceden a las redes sociales.
> -   **27%** del tiempo en internet lo utilizan en las redes sociales.
> -   **74%** de los usarios de redes sociales, piensan que éstas son un medio de confianza al que acudir cuando se quiere tomar una decisión sobre la compra de un producto o servicio.
> -   **60%** de los consumidores interactúa con, al menos, un proveedor en las redes sociales.

En lo que concierne a las empresas:

> -   **91%** de las empresas utilizan las redes sociales para hacer marketing de contenido.
> -   **64%** las utiliza para investigar el estado de los mercados y a la competencia.
> -   **50%** de las empresas que utilizan redes sociales, dicen que han ayudado a que sus ventas se incrementen.
> -   **52%** de las empresas dicen que las redes sociales les han ayudado a captar nuevos clientes.

Por otro lado, las redes sociales más utilizadas por los negocios son [Twitter](https://twitter.com), en especial en el sector tecnológico y de software, y [LinkedIn](https://www.linkedin.com/), cuando se ofrecen servicios profesionales y marketing; aunque tampoco hay que dejar de lado a [Facebook](https://www.facebook.com/) y [Pinterest](https://co.pinterest.com/), que cuentan con un gran número de usuarios.



|   |   |
|----|----|
| ![](http://pngimg.com/uploads/twitter/twitter_PNG34.png) | **Twitter es una de las herramientas más usadas en la red social. Las técnicas de análisis de texto y sentimiento permiten a las organizaciones acercarse a la emoción verdadera** que reside detrás de cada actualización de estado, de cada publicación o de  [cada Tweet que lanzan sus clientes.](https://blog.es.logicalis.com/analytics/redes-sociales-como-fuentes-de-datos-el-caso-de-tweeter)[2]|
|||
|||

**Problemática:** Un documental creado por la firma *Nicolas Glimois and Christophe Weber* denominado [**Pepsi vs Cola: The Marketing Battle of the Century**](https://www.amazon.com/Pepsi-Cola-Marketing-Battle-Century/dp/B074QW7KZZ), enmarca la gran batalla que han vivido las 2 marcas de bebida sabor cola más reconocidas a nivel mundial.
En el documental se evidencian los altibajos de cada una de las compañías y como se han convertido en ícono de la competencia capitalista norteaméricana, una competencia que las ha catapultado al éxito mundial.[3]

Al 2010 tenemos un panorama publicado por la reconocida página de Mercadeo: [MarketingDirecto](https://www.marketingdirecto.com), representado por la siguiente imagen:[4]

![Panorama histórico](https://www.marketingdirecto.com/wp-content/uploads/2011/11/10.jpg)

Esto muestra un panorama muy equitativo para la fecha.

#### El objetivo del presente ejercicio es realizar un breve estudio del panorama actual sobre el panorama de Coca-Cola y Pepsi, en el escenario de Twitter como red social influyente en la actualidad, este estudio consiste en un análisis de sentimientos de cada uno de los usuarios de Twitter que en sus Tweets han puesto algo relacionado con cualquiera de las dos empresas. 

## Arquitectura preliminar de datos
 - **Ciclo de Vida:**
 - **Almacenamiento:**
 - **Procesamiento:**

## Fuentes y Naturaleza de los datos - Tecnologías

## Sistema de ingesta de datos - Tecnologías 
 Para la ingesta de datos se pretende utilizar Apache Flume, un software distribuido que permite recolectar y mover grandes cantidades de datos, ya que hace posible recolectar datos de Twitter y almacenarlos en HDFS. Para esto también se requierecrear una aplicación de Twitter que nos premita tener acceso a los Tweets. 
 
## Almacenamiento de datos - Tecnologías
Para el almacenamiento de datos se utilizará HDFS con Hive. Esto se debe a que la naturaleza de los datos a almacenar se maneja más fácil mediante la estructura similar a tablas y queries SQL. 

## Análisis de datos - Tecnologías 
 Para analizar los datos es conveniente utilizar una biblioteca de Natural Language Processing (NLP) y Spark cuenta con estas capacidades. Existen diferentes APIs que permiten procesar la informaciónd e Tweets para tener una idea de los sentimientos que éstos quieren expresar.

[1] [¿Por qué son importantes las redes sociales en los negocios?](https://jorgecastro.mx/por-que-son-importantes-las-redes-sociales-en-los-negocios/)
[2] [Técnicas de análisis Twitter: herramientas y aplicaciones que te permiten conocer mejor a tus clientes](https://blog.es.logicalis.com/analytics/tecnicas-de-analisis-twitter-herramientas-y-aplicaciones-que-te-permiten-conocer-mejor-a-tus-clientes)
[3] [Coca-Cola vs Pepsi duelo de titanes](https://www.reasonwhy.es/reportaje/coca-cola-vs-pepsi-duelo-de-titanes)
[4] [Coca-Cola vs Pepsi la increible historia de la guerra de los refrescos de cola](https://www.marketingdirecto.com/anunciantes-general/anunciantes/coca-cola-vs-pepsi-la-increible-historia-de-la-guerra-de-los-refrescos-de-cola)
