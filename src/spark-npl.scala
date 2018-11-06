import com.johnsnowlabs.nlp.base._
import org.apache.spark.sql.SparkSession
import com.johnsnowlabs.nlp.pretrained.pipelines.en.SentimentPipeline

// Extract the tweets from the previously created table in hive
val tweets = spark.sql("select text from tweets where lang = 'en'")

// Transform the DataFrame using the sentiment analysis pipeline from spark-npl
val result = SentimentPipeline().pretrained().transform(tweets)

// Filter resuls by company (comparison between them that contains both
// words may overlap)
val pepsi = result.filter(lower($"text").contains("pepsi"))
val cola = result.filter(lower($"text").contains("coca-cola"))

// Extract the results from the previous transformation and count by results
val pepsi2 = pepsi.select(explode($"sentiment"))
val pepsi_result = pepsi2.select('col.getItem("result") as "result").groupBy("result").count()


val cola2 = cola.select(explode($"sentiment"))
val cola_result = cola2.select('col.getItem("result") as "result").groupBy("result").count()

// Create temporal views in Apache Spark to manipulate them later with SparkSQL
pepsi_result.createOrReplaceTempView("pepsi_results")
cola_result.createOrReplaceTempView("cola_results")