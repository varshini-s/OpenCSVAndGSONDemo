package com.bridgelabz.opensourcelibraryexamples;

import java.io.BufferedReader;
import java.io.FileReader;

public class OpenCSVReaderWithGivenSeperator 
{

	private static final String SAMPLE_CSV_FILE_PATH ="./users_SeperatedBy_SpecialCharacter.csv";

	public static void main(String[] args)
	{

		BufferedReader fileReader = null;

		String Seperator = "#";
		try
		{
			String line = "";
			fileReader = new BufferedReader(new FileReader(SAMPLE_CSV_FILE_PATH));

			while ((line = fileReader.readLine()) != null) 
			{
				String[] records = line.split(Seperator);
				System.out.println("Name: "+records[0]);
				System.out.println("Email: "+records[1]);
				System.out.println("Phone: "+records[2]);
				System.out.println("Country: "+records[3]);
				System.out.println("=========================");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}



}
