import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

import com.shareMarket.ParseCSVFile;
import com.sharePrices.dao.CompanyShare;


public class CompanyShareTest {

	private String inputFilePath = "output.csv";
	
	@Test
	public void testInputFileFormat() {
		
		//Test for null file path
		try {
			Assert.assertNull(ParseCSVFile.read(null));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testInvalidFilePath() throws FileNotFoundException, IOException{
		//Test for invalid file Path
		ParseCSVFile.read("");
	}

	@Test
	public void testParsedData() {
		
		try {
			HashMap<String, TreeSet<CompanyShare>> companyMap = ParseCSVFile.read(inputFilePath);
			int totalCompanies = companyMap.size();
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader(inputFilePath));
			String line = reader.readLine();
			int totCompaniesFile = line.split(",").length - 2;
			Assert.assertEquals(totalCompanies, totCompaniesFile);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testInvalidFile(){
		try {
			Assert.assertNull(ParseCSVFile.read("d:\\invalid.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}