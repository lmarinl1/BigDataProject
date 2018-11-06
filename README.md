# BigDataProject

### Install and Configure Flume

1. Descargar Flume [Aqui](http://flume.apache.org/download.html).

2. Mover [flume-sources-1.0-SNAPSHOT.jar](https://github.com/lmarinl1/BigDataProject/blob/master/lib/flume-sources-1.0-SNAPSHOT.jar) al  classpath, y ubicar dicho fichero en **conf/flume-env.sh**.

`$ EXPORT JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64`
`$ EXPORT FLUME_CLASSPATH=/usr/hdp/current/flume-server/lib/flume-sources-1.0-SNAPSHOT.jar`

Este .jar contiene todas las clases necesarias de java para extraer los Tweets e incertarlos en un lugar de HDFS.

The conf/flume-twitter.conf should have all the agents (flume, memory and hdfs) defined as below.

TwitterAgent.sources= Twitter
TwitterAgent.channels= MemChannel
TwitterAgent.sinks=HDFS
TwitterAgent.sources.Twitter.type = com.cloudera.flume.source.TwitterSource
TwitterAgent.sources.Twitter.channels=MemChannel
TwitterAgent.sources.Twitter.consumerKey=xxxxxxxxxxxxxxxxxxxxx
TwitterAgent.sources.Twitter.consumerSecret=xxxxxxxxxxxxxxxxxxx
TwitterAgent.sources.Twitter.accessToken=xxxxxxxxxxxxxxxxxxxxxxx
TwitterAgent.sources.Twitter.accessTokenSecret=xxxxxxxxxxxxxxxxx
TwitterAgent.sources.Twitter.keywords= INDvsNZ, cricket, T20
TwitterAgent.sinks.HDFS.channel=MemChannel
TwitterAgent.sinks.HDFS.type=hdfs
TwitterAgent.sinks.HDFS.hdfs.path=hdfs://localhost:9000/user/flume/tweets
TwitterAgent.sinks.HDFS.hdfs.fileType=DataStream
TwitterAgent.sinks.HDFS.hdfs.writeformat=Text
TwitterAgent.sinks.HDFS.hdfs.batchSize=1000
TwitterAgent.sinks.HDFS.hdfs.rollSize=0
TwitterAgent.sinks.HDFS.hdfs.rollCount=10000
TwitterAgent.sinks.HDFS.hdfs.rollInterval=600
TwitterAgent.channels.MemChannel.type=memory
TwitterAgent.channels.MemChannel.capacity=10000
TwitterAgent.channels.MemChannel.transactionCapacity=10000
The consumerKey, consumerSecret, accessToken and accessTokenSecret have to be replaced with those obtained from https://dev.twitter.com/apps. And, TwitterAgent.sinks.HDFS.hdfs.path should point to the NameNode and the location in HDFS where the tweets will go to.

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
