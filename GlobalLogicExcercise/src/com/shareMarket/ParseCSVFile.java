package com.shareMarket;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeSet;

import com.sharePrices.dao.CompanyShare;

public class ParseCSVFile {
	public static HashMap<String, TreeSet<CompanyShare>> read(
			String dataFilePath) throws FileNotFoundException, IOException {
		if(dataFilePath == null) return null;
		BufferedReader reader = null;
		HashMap<String, TreeSet<CompanyShare>> companyMap = new HashMap<String, TreeSet<CompanyShare>>();
		reader = new BufferedReader(new FileReader(dataFilePath));
		
		String line = reader.readLine();
		if(line == null)
			return null;
		if(!line.startsWith("Year") && !line.contains("Month")){
			return null;
		}
		String headers[] = line.split(",");
		while ((line = reader.readLine()) != null) {
			String sharePrices[] = line.split(",");
			CompanyShare share = null;
			for (int i = 2; i < sharePrices.length; i++) {
				share = new CompanyShare(headers[i],
						Integer.parseInt(sharePrices[i]), sharePrices[0],
						sharePrices[1]);
				if (companyMap.containsKey(headers[i])) {
					TreeSet<CompanyShare> companySet = companyMap
							.get(headers[i]);
					companySet.add(share);
				} else {
					TreeSet<CompanyShare> companySet = new TreeSet<CompanyShare>();
					companySet.add(share);
					companyMap.put(headers[i], companySet);
				}
			}
		}

		return companyMap;
	}
}
