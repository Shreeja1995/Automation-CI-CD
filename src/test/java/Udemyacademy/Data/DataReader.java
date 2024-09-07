package Udemyacademy.Data;

import java.io.File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

    // Method to read JSON data from a file and convert it to a List of HashMap
    public static List<HashMap<String, String>> getJsonDataToMap() throws IOException {
        // Define the path to the JSON file
    	
        String filePath = System.getProperty("user.dir")+ "src\\test\\java\\Udemyacademy\\Data\\Purchaseorder.json";
        // Read JSON file content to a String
      
     
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        
        // Convert JSON string to List of HashMap
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
        
        return data;
    }
}
