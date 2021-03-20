package fileservices;

import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import model.ModelLog;

public class WriteFileParquet {
	private List<ModelLog> listModelLog;
	
	public WriteFileParquet(List<ModelLog> listModelLog) {
		setListModelLog(listModelLog);
	}

	public List<ModelLog> getListModelLog() {
		return listModelLog;
	}

	public void setListModelLog(List<ModelLog> listModelLog) {
		this.listModelLog = listModelLog;
	}
	
	public void writeDataToPath() {
		SparkSession spark = SparkSession.builder().appName("Write file parquet to HDFS").master("local").getOrCreate();
		
		Dataset<Row> listModelLogDF = spark.createDataFrame(listModelLog, ModelLog.class);
		listModelLogDF.write().parquet("hdfs://127.0.0.1:9000/usr/trannguyenhan/pageviewlog");
	}
}
