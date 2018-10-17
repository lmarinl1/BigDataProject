# Analisis-Draft

### Introducción
AWS define *Data Streaming* como:
> *"Los  datos que se generan constantemente a partir de **miles de fuentes de datos**, que normalmente envían los registros de datos simultáneamente en conjuntos de **tamaño pequeño** (varios kilobytes). 
> Los datos de streaming incluyen diversos tipos de datos, como archivos de registros generados por los clientes que utilizan sus aplicaciones móviles o web, compras electrónicas, actividades de los jugadores en un juego, información de redes sociales, operaciones bursátiles o servicios geoespaciales, así como [telemetría](https://es.wikipedia.org/wiki/Telemetr%C3%ADa) de dispositivos conectados o instrumentación en centros de datos." [^1^](https://aws.amazon.com/es/streaming-data/)*

Este tipo de  datos debe ser procesado de forma secuencial y gradual, registro por registro o en ventanas de tiempo graduales; se  suele utilizar para diferentes tipos de análisis, tales como: [**correlaciones**](https://es.wikipedia.org/wiki/Correlaci%C3%B3n), [**agregaciones**](https://www.tecnologias-informacion.com/agregacion.html), **filtrado** y [**muestreo**](https://enablement.acl.com/helpdocs/analytics/13/user-guide/es/Content/da_sampling_data/sampling_data.htm). 
La información derivada del análisis aporta a las empresas visibilidad de numerosos aspectos del negocio y de las actividades de los clientes, como el uso del servicio (para la medición/facturación), la actividad del servidor, los clics en un sitio web y la ubicación geográfica de dispositivos, personas y mercancías, y **les permite responder con rapidez** ante cualquier situación que surja. Por ejemplo:
>Las empresas pueden supervisar los cambios en la opinión pública de sus marcas y productos al analizar constantemente las transmisiones de los medios sociales y responder rápidamente cuando sea necesario.

### Desafíos a la hora de Trabajar con *Data Streaming*



## Referencias
[1] Building a Fast, Scalable & Accurate NLP Pipeline on Apache Spark https://www.brighttalk.com/webcast/17156/334430?utm_campaign=webcasts-search-results-feed&utm_content=case%20of%20use%20spark&utm_source=brighttalk-portal&utm_medium=web

[2] Streaming Analytics Use Cases on Apache Spark https://www.brighttalk.com/webcast/12891/319621?utm_campaign=webcasts-search-results-feed&utm_content=case%20of%20use%20spark&utm_source=brighttalk-portal&utm_medium=web

[3] How Machine Learning Helps Predict Equipment Failure
https://www.brighttalk.com/webcast/9061/248601?utm_campaign=webcasts-search-results-feed&utm_content=case%20of%20use%20spark&utm_source=brighttalk-portal&utm_medium=web

[4] Apache® Spark™ MLlib: From Quick Start to Scikit-Learn
https://www.brighttalk.com/webcast/12891/189409?utm_campaign=webcasts-search-results-feed&utm_content=case%20of%20use%20spark&utm_source=brighttalk-portal&utm_medium=web

[5] Apache Spark™ for Machine Learning and AI https://www.brighttalk.com/webcast/12891/313221?utm_campaign=webcasts-search-results-feed&utm_content=case%20of%20use%20spark&utm_source=brighttalk-portal&utm_medium=web
