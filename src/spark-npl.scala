import com.johnsnowlabs.nlp.base._
import org.apache.spark.sql.SparkSession
import com.johnsnowlabs.nlp.pretrained.pipelines.en.SentimentPipeline

// Extract the tweets from the previously created table in hive
val tweets = spark.sql("select text from tweets where lang = 'en'")

// Transform the DataFrame using the sentiment analysis pipeline from spark-npl
val result = SentimentPipeline().pretrained().transform(tweets)

// Extract the results from the previous transformation and count by results
val result2 = result.select(explode($"sentiment"))
result2.select('col.getItem("result") as "result").groupBy("result").count().show