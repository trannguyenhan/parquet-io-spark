# spark-base
### Read file text and write them to parquet file from HDFS
Push 5 file .dat in folder sample_text to HDFS with path /usr/trannguyenhan (you can modify path, but you must modify path in code too)
```
  hdfs dfs -mkdir /usr
  hdfs dfs -mkdir /usr/trannguyenhan
  hdfs dfs -copyFromLocal <file_push> <path>
```
Later, go to folder project and open terminal and run : 
```
  mvn clean package
```
was build file jar, file jar was born located in target folder. Run jar file with spark-submit : 
```
  spark-submit --class main.Main --master local[2] target/<file>-V1.jar
```
One folder pageviewlog was born in HDFS. Open HDFS with chorme browser and see it.
