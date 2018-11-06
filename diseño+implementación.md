# Diseño

# Implementación

La ingesta de datos fue implementada con flume. Se realizó un archivo de configuración que especifica las palabras clave a buscar en los tweets, donde se almacena el resultado, el tamaño de los archivos a almacenar y la conexión con el API de Twitter. Para fácil manejo de los datos se utilizo una biblioteca de flume que permite descargar los datos como JSON. Para la lectura de datos, éstos fueron insertados a una tabla de Hive utilizando una biblioteca llamada serDes para fácil inserción de JSON a tablas. Para el análisis de datos se utilizo Spark, con SparkSQL para fácil acceso a la tabla y Spark-NLP  para el análisis de sentimientos.
