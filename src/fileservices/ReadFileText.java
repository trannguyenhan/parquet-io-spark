package fileservices;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import model.ModelLog;

public class ReadFileText {
	private String pathFile;
	private List<ModelLog> listModelLog;

	public ReadFileText() throws IOException, ParseException {
		this("hdfs://127.0.0.1:9000/usr/trannguyenhan/pt-v-1533869954405.dat");
	}

	public ReadFileText(String path) throws IOException, ParseException {
		setPathFile(path);
		listModelLog = new ArrayList<>();
		readDataFromPath();
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public List<ModelLog> getListModelLog() {
		return listModelLog;
	}

	public void setListModelLog(List<ModelLog> listModelLog) {
		this.listModelLog = listModelLog;
	}

	public void readDataFromPath() throws IOException, ParseException {
		SparkConf conf = new SparkConf().setAppName("Read file text from HDFS").setMaster("local");
		
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> lines = sc.textFile(pathFile);
		
		for(String line : lines.collect()) {
			ModelLog model = splitLine(line);
			listModelLog.add(model);
		}
	}

	public ModelLog splitLine(String line) throws ParseException {
		String[] tokenizer = line.split("\t");

		Date timeCreate = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse(tokenizer[0]);
		Date cookieCreate = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse(tokenizer[1]);
		int browserCode = Integer.parseInt(tokenizer[2]);
		String browserVer = tokenizer[3];
		int osCode = Integer.parseInt(tokenizer[4]);
		String osVer = tokenizer[5];
		long ip = Long.parseLong(tokenizer[6]);
		int locId = Integer.parseInt(tokenizer[7]);
		String domain = tokenizer[8];
		int siteId = Integer.parseInt(tokenizer[9]);
		int cId = Integer.parseInt(tokenizer[10]);
		String path = tokenizer[11];
		String referer = tokenizer[12];
		long guid = Long.parseLong(tokenizer[13]);
		String flashVersion = tokenizer[14];
		String jre = tokenizer[15];
		String sr = tokenizer[16];
		String sc = tokenizer[17];
		int geographic = Integer.parseInt(tokenizer[18]);
		String category = tokenizer[23];
		String osName = tokenizer[5];

		ModelLog tmpModelLog = new ModelLog(timeCreate, browserCode, browserVer, osName, osCode, osVer, ip, domain,
				path, cookieCreate, guid, siteId, cId, referer, geographic, locId, flashVersion, jre, sr, sc, category);

		return tmpModelLog;
	}
}
