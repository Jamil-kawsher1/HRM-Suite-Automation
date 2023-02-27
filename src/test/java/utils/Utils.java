package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    //This Method will use to store User data as json object List
    public static void addJsonList (String username, String password, String firstname, String lastname) throws IOException, ParseException {
        String fileName = "./src/test/resources/EmployeeList.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject employeelist = new JSONObject();
        employeelist.put("username", username);
        employeelist.put("password", password);
        employeelist.put("firstname", firstname);
        employeelist.put("lastname", lastname);
        jsonArray.add(employeelist);
        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();


    }

    public static int randomNumber(){
        return (int) Math.round(Math.random()*5000);
    }

    public static JSONObject readJSONFile(String filename,int index) throws IOException, ParseException {


        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(filename));
        JSONArray jsonArray = (JSONArray) obj;
       int arraySize=jsonArray.size();
       int arrayIn=arraySize-index;

        JSONObject    arryObject= (JSONObject) jsonArray.get(arrayIn);

        
        return arryObject;



    }

    public static void updateJSONFileObjectProperty(String filename,int index,String propertyname,String updatedvalue) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(filename));
        JSONArray jsonArray = (JSONArray) obj;
        int arraySize=jsonArray.size();
        int arrayIn=arraySize-index;
        // Get the JSON object at the specific index
        JSONObject jsonObject = (JSONObject) jsonArray.get(arrayIn);


        // Update the property value of the object
        jsonObject.put(propertyname, updatedvalue);
        // Convert the JSON array back to a JSON string

        String updatedJsonString = jsonArray.toJSONString();
        // Write the updated JSON string back to the original JSON file
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(updatedJsonString);
        }
    }

    public static void main (String[] args) throws IOException, ParseException {

        System.out.println( readJSONFile("./src/test/resources/EmployeeList.json",2));
//        updateJSONFileObjectProperty("./src/test/resources/EmployeeList.json",1,"username","badhontest");
    }
}
