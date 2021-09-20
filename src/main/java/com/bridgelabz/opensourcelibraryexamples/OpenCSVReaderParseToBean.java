package com.bridgelabz.opensourcelibraryexamples;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVReaderParseToBean 
{

	private static final String SAMPLE_CSV_PATH="./users-with-header.csv";
	
	public static void main(String[] args) throws IOException
	{
		try
		(Reader reader=Files.newBufferedReader(Paths.get(SAMPLE_CSV_PATH));

		)
		{
			CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
					.withType(CSVUser.class)
					.withIgnoreLeadingWhiteSpace(true)
					.build();
			
			Iterator<CSVUser> csvUserIterator =csvToBean.iterator();
			
			while(csvUserIterator.hasNext())
			{
				CSVUser csvUser =csvUserIterator.next();
				System.out.println("Name: "+csvUser.getName());
				System.out.println("Email: "+csvUser.getEmail());
				System.out.println("PhoneNumber: "+csvUser.getPhoneNumber());
				System.out.println("Country: "+csvUser.getCountry());
				System.out.println("=======================");
				
				
			}
			
			 csvToBean = new CsvToBeanBuilder(reader)
					.withType(CSVUser.class)
					.withIgnoreLeadingWhiteSpace(true)
					.build();
						
			List<CSVUser> csvUsers=csvToBean.parse();
			for(CSVUser csvUser:csvUsers)
			{
				
				System.out.println("Name: "+csvUser.getName());
				System.out.println("Email: "+csvUser.getEmail());
				System.out.println("PhoneNumber: "+csvUser.getPhoneNumber());
				System.out.println("Country: "+csvUser.getCountry());
				System.out.println("=======================");
				
			}
			
		}
		
	}
}
