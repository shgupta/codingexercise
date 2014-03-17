package com.shareMarket;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import com.sharePrices.dao.CompanyShare;


public class Main {
	private static HashMap<String, TreeSet<CompanyShare>> companyMap = null;

	static{
		try {
			companyMap = ParseCSVFile.read("output.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println("- Total Compinies:: " + companyMap.size());
		Set<String> companyKey = companyMap.keySet();
		System.out.println("Company Name" + "\t\t" + "Year" + "\t\t" + "Month" + "\t\t" + "Share Value");
		for (String string : companyKey) {
			TreeSet<CompanyShare> c =  companyMap.get(string);
			for (CompanyShare companyShare : c) {
				System.out.println(companyShare.getCompanyName().trim() + "\t\t" + companyShare.getYear() + "\t\t" + companyShare.getMonth() + "\t\t" + companyShare.getShareValue());
				break;
			}
		}
	}
}
