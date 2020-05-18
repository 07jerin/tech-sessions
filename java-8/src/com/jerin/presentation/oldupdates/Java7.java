package com.jerin.presentation.oldupdates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java7 {

	public static void main(String[] args) {
	
		
		List<String> strList = new ArrayList<>(); // Diamond Operator
		Map<String, Map<String, Integer> > map = new HashMap<>();
		
		
		int tenThousand = 10_00_00_000; // integer with underscore
		
	}
	
	private void b4Java7(){
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader("C:\\testing.txt"));
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException npe){
			npe.printStackTrace();
		}
		
		finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private void tryWithResource(){
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\testing.txt"))) // Try with resources
		{

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException  | NullPointerException ex) { // Nesting of exception
			ex.printStackTrace();
		}
	}
		
}
