//--- COMPILE ---//
///usr/local/opt/scala@2.11/bin/scalac -classpath (find /usr/local/Cellar/apache-spark/2.4.4/libexec/jars -name "*.jar" -type f | paste -sd ":" -) QuestoesLogNASA.scala -d QuestoesLogNASA.jar
//--- RUN ---//
//spark-submit --class mvrpl.me.QuestoesLogNASA --master "local[*]" QuestoesLogNASA.jar 2> /dev/null

package mvrpl.me

import org.apache.spark.sql.SparkSession
import org.apache.spark.rdd.RDD
import scala.util.Try

object QuestoesLogNASA{
	def main(args: Array[String]){
		val spark = SparkSession.builder.appName("AnalisesLogNASA").getOrCreate()
		val sc = spark.sparkContext

		val dataset: RDD[String] = sc.textFile("./NASA_access_log_*95.txt")

		val linhas = dataset.map(_.split("(\\s)(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)(?=(?:[^\\[|\\]]*\\[[^\\[|\\]]*\\])*[^\\[|\\]]*$)"))

		//1. Hosts Unicos
		val totalHostsUnicos = linhas.map(linha => linha.lift(0)).distinct.count
		println(s"HOSTS UNICOS: ${totalHostsUnicos}\n")

		//2. Total Erros 404
		val totalErros404 = linhas.filter(linha => Try(linha.lift(5).get.toInt).getOrElse(0) == 404).count
		println(s"TOTAL ERROS 404: ${totalErros404}\n")

		//3. Top 5 URLs 404
		val top5URL404 = linhas.filter(linha => Try(linha.lift(5).get.toInt).getOrElse(0) == 404).map(linha => (linha.lift(0).getOrElse(null), 1)).countByKey.toSeq.sortWith(_._2 > _._2).take(5).mkString("\n")
		println(s"TOP 5 URLs 404:\n${top5URL404}\n")

		//4. QTD ERRO 404 POR DIA
		val formatoIn = new java.text.SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]", java.util.Locale.ENGLISH)
		val formatoOut = new java.text.SimpleDateFormat("yyyy-MM-dd")
		val qtdErro404Dia = linhas.filter(linha => Try(linha.lift(5).get.toInt).getOrElse(0) == 404).map(linha => 
			(formatoOut.format(formatoIn.parse(linha.lift(3).get).getTime), 1)
		).groupByKey.mapValues(_.sum).sortBy(_._1, false).collect.mkString("\n")
		println(s"QTD ERRO 404/DIA:\n${qtdErro404Dia}\n")

		//5. Total Bytes
		val totalBytes = linhas.map(linha => Try(linha.lift(6).get.toInt).getOrElse(0)).sum
		println(s"TOTAL BYTES: ${totalBytes}")
	}
}