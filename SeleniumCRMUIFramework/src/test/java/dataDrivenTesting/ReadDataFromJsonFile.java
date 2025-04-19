package dataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadDataFromJsonFile {

	public static void main(String[] args) throws FileNotFoundException, Exception, Exception {
		
		// step 1: parse jason physical file into java object using JSonparser class
		JSONParser parser = new JSONParser();
		Object obj =  parser.parse(new FileReader("C:\\Users\\hp\\OneDrive\\Desktop\\New folder\\appCommonData.json"));
		
		//Sep 2 : Convert java object into json object using downcasting
		
		JSONObject map = (JSONObject)obj;
		
		// step 3: get the value from json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeOuts"));
	}
}
