# BigDataProject

## Flume
### Instalar y Configurar Flume

1. Descargar Flume [Aqui](http://flume.apache.org/download.html).

2. Mover [flume-sources-1.0-SNAPSHOT.jar](https://github.com/lmarinl1/BigDataProject/blob/master/lib/flume-sources-1.0-SNAPSHOT.jar) al  classpath, y ubicar dicho fichero en **conf/flume-env.sh**.

```
$ EXPORT JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64`
$ EXPORT FLUME_CLASSPATH=/usr/hdp/current/flume-server/lib/flume-sources-1.0-SNAPSHOT.jar
```
Este .jar contiene todas las clases necesarias de java para extraer los Tweets e incertarlos en un lugar de HDFS.


### Archivo de configuración de un agente de Flume

El archivo se llama [twitter.conf](https://github.com/lmarinl1/BigDataProject/blob/master/twitter.conf) el cual debe tener todas las configuraciones del agente (flume, memory and hdfs) y se define de la siguiente manera:

**Parte 1:** Nombrar los componentes del agente a configurar
```
TwitterAgent.sources = Twitter  
TwitterAgent.channels = MemChannel 
TwitterAgent.sinks = HDFS    
```

**Parte 2:** Descripcion y configuracion de la fuente
```
TwitterAgent.sources.Twitter.type = com.cloudera.flume.source.TwitterSource 
TwitterAgent.sources.Twitter.consumerKey = <CustomerKey>
TwitterAgent.sources.Twitter.consumerSecret = <ConsumerSecret> 
TwitterAgent.sources.Twitter.accessToken = <AccessToken>
TwitterAgent.sources.Twitter.accessTokenSecret = <AccessTokenSecret>
TwitterAgent.sources.Twitter.keywords = Pepsi, Coca-cola
```

**Parte 3:** Descripcion de la sincronizacion
```
TwitterAgent.sinks.HDFS.type = hdfs  
TwitterAgent.sinks.HDFS.hdfs.path = hdfs://sandbox-hdp.hortonworks.com:8020/user/<userName>/twitter
TwitterAgent.sinks.HDFS.hdfs.fileType = DataStream  
TwitterAgent.sinks.HDFS.hdfs.writeFormat = Text  
TwitterAgent.sinks.HDFS.hdfs.batchSize = 1000 
TwitterAgent.sinks.HDFS.hdfs.rollSize = 0  
TwitterAgent.sinks.HDFS.hdfs.rollCount = 10000 
```

**Parte 4:** Configuracion del canal
```
TwitterAgent.channels.MemChannel.type = memory  
TwitterAgent.channels.MemChannel.capacity = 10000  
TwitterAgent.channels.MemChannel.transactionCapacity = 100 
TwitterAgent.sources.Twitter.channels = MemChannel 
TwitterAgent.sinks.HDFS.channel = MemChannel
```

Los componentes de <consumerKey>, <consumerSecret>, <accessToken> y <accessTokenSecret> deben ser reemplazados con los elementos obtenidos desde una app de twitter ([Obten una App](https://dev.twitter.com/apps)). y TwitterAgent.sinks.HDFS.hdfs.path should point to the NameNode and the location in HDFS where the tweets will go to.


The TwitterAgent.sources.Twitter.keywords value can be modified to get the tweets for some other topic like football, movies etc.

Add following to .bashrc file

$ gedit ~/.bashrc
### FLUME VARIABLES START

export FLUME_HOME=/home/ultron/work/apache-flume-1.6.0-bin
export FLUME_CONF_DIR=$FLUME_HOME/conf
export FLUME_CLASSPATH=$FLUME_CONF_DIR
export PATH=”$FLUME_HOME/bin:$PATH”
### FLUME VARIABLES END

Run following command to reload new .bashrc file

$source ~/.bashrc
— — — — — — — — — — — — — — — — — — — — — — — — — — — — — — —

Run Flume and collect data into HDFS.

Start Hadoop first. $start-all.sh
Start flume using the below command
(Assuming you are inside ‘/home/ultron/work/apache-flume-1.6.0-bin’ )

$bin/flume-ng agent — conf ./conf/ -f conf/flume.conf -Dflume.root.logger=DEBUG,console -n TwitterAgent
After a couple of minutes the Tweets should appear in HDFS.

Visit localhost:50070 in your browser
Navigate to localhost:50070/explorer.html#/user/flume/tweets/
