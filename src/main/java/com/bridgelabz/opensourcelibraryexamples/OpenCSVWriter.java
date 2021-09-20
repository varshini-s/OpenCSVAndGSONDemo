package com.bridgelabz.opensourcelibraryexamples;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class OpenCSVWriter 
{

	private static final String OBJECT_LIST_SAMPLE="./object-list-sample.csv";

	public static void main(String[] args) throws IOException,CsvDataTypeMismatchException,
	CsvRequiredFieldEmptyException
	{

		try
		(Writer writer =Files.newBufferedWriter(Paths.get(OBJECT_LIST_SAMPLE))
		)
		{
			StatefulBeanToCsv<MyUser> beanToCsv= new StatefulBeanToCsvBuilder(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
					.build();

			List<MyUser> myUsers = new ArrayList<>();
			myUsers.add(new MyUser("Sundar Pichai", "sundar.pichai@gmail.com", "+1-123455555", "India"));
			myUsers.add(new MyUser("Satya Nadella", "satya.nadella@outlook.com", "+1-1232323", "India"));

			beanToCsv.write(myUsers);
		}
	}
}
