package main;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import fileservices.ReadFileText;
import fileservices.WriteFileParquet;
import model.ModelLog;

public class Main {
	public static void writeParquetFile() throws IOException, ParseException {
		System.out.println("START PROCESSING........");

		ReadFileText reader = new ReadFileText();
		List<ModelLog> listModelLog = reader.getListModelLog();

		for (ModelLog model : listModelLog) {
			System.out.println(model);
		}

		WriteFileParquet writer = new WriteFileParquet(listModelLog);
		writer.writeDataToPath();
		
		System.out.println("END PROCESSING.....");
	}
	
	public static void exe1(SparkSession spark, Dataset<Row> parquetFile) {
		Dataset<Row> data1 = parquetFile.groupBy("guid", "domain").count();
		data1.show();
		Dataset<Row> data2 = data1.groupBy("guid").max("count");
		data2.show();
		
		Dataset<Row> data3 = data1
				.join(data2,
						data1.col("guid").equalTo(data2.col("guid"))
								.and(data1.col("count").equalTo(data2.col("max(count)"))))
				.select(data1.col("guid"), data1.col("domain"));//.where(data1.col("guid").equalTo("7845282841953047717"));

		data3.show();

	}
	
	public static void exe2(SparkSession spark, Dataset<Row> parquetFile) {
		Dataset<Row> data1 = parquetFile.groupBy("guid", "ip").count();
		Dataset<Row> data2 = data1.groupBy("ip").count();
		data2 = data2.orderBy(data2.col("count").desc());
		data2.show();
	}
	
	public static void exe3(SparkSession spark, Dataset<Row> parquetFile) {
		parquetFile.createOrReplaceTempView("tableDataset");
		parquetFile.printSchema();
	}
	
	public static void main(String[] args) throws IOException, ParseException{
		writeParquetFile();
		
		SparkSession spark = SparkSession.builder().appName("Read file parquet to HDFS").master("local").getOrCreate();
		Dataset<Row> parquetFile = spark.read().parquet(
				"hdfs://127.0.0.1:9000/usr/trannguyenhan/pageviewlog");
		
		//exe1(spark, parquetFile);
		//exe2(spark, parquetFile);
		exe3(spark, parquetFile);
	}
}
