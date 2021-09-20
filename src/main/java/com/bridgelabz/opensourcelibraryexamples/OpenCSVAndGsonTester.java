package com.bridgelabz.opensourcelibraryexamples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVAndGsonTester 
{
	private static final String SAMPLE_CSV_FILE_PATH="./users.csv";
	private static final String SAMPLE_JSON_FILE_PATH="./users.json";
	
	public static void main(String[] args) 
	{	
		
		try
		{
			Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
			CsvToBeanBuilder<CSVUser> csvToBeanBuilder = new CsvToBeanBuilder<CSVUser>(reader);
			csvToBeanBuilder.withType(CSVUser.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVUser> csvToBean =csvToBeanBuilder.build();
			List<CSVUser> csvUsers = csvToBean.parse();
			Gson gson= new Gson();
			String json =gson.toJson(csvUsers);
			FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
			writer.write(json);
			writer.close();
			BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
			CSVUser[] usrObj =gson.fromJson(br, CSVUser[].class);
			List<CSVUser> csvUserlist = Arrays.asList(usrObj);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}
}
