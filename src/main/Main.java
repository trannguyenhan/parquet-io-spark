package main;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import fileservices.ReadFileText;
import fileservices.WriteFileParquet;
import model.ModelLog;

public class Main {
	public static void main(String[] args) throws IOException, ParseException {
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
}
