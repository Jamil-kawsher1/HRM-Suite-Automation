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
    public static void addJosnList (String username, String password, String firstname, String lastname) throws IOException, ParseException {
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

    public static void main (String[] args) throws IOException, ParseException {
        addJosnList("jamil0777", "123", "Jamil", "Kawsher");
    }
}
