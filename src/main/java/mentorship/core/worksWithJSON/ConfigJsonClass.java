package mentorship.core.worksWithJSON;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;

public  class ConfigJsonClass {


    //https://crunchify.com/how-to-read-json-object-from-file-in-java/

    public JSONArray readJSON() throws  IOException, ParseException {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/resources/files/readJSON.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String nameFromJSON = (String) jsonObject.get("Name");
            System.out.println("Name : " + nameFromJSON);

            JSONArray companyValuesList = (JSONArray) jsonObject.get("Company List");
            System.out.println(companyValuesList + "company values list");
            Iterator<JSONObject> iterator = companyValuesList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

         return companyValuesList;
//            System.out.println("Users List-> "+usersList); //This prints the entire json file
//            for(int i=0;i<usersList.length;i++) {
//                JSONObject users = (JSONObject) usersList.get(i);
//                System.out.println("Users -> "+users);//This prints every block - one json object
//                JSONObject user = (JSONObject) users.get("users");
//                System.out.println("User -> "+user); //This prints each data in the block
//                String username = (String) user.get("username");
//                step(username);
              //  String password = (String) user.get("password");
//                String result = login(username,password);
//                user.put("result", result);
        } catch (FileNotFoundException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
//https://dzone.com/articles/selenium-data-parameterization-using-json
    public  void writeIntoJSON() throws  IOException, ParseException {

        //First Employee
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Lokesh");
        employeeDetails.put("lastName", "Gupta");
        employeeDetails.put("website", "howtodoinjava.com");

        JSONObject employeeObject = new JSONObject();
        employeeObject.put("Person info", employeeDetails);

        //Second Employee
        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("adress", "MyHomeAdress");


        JSONObject employeeObject2 = new JSONObject();
        employeeObject2.put("Custom information", employeeDetails2);

        //Add employees to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        employeeList.add(employeeObject2);

        try (FileWriter file = new FileWriter("src/test/resources/files/createdJSON.json")) {
            file.write(employeeList.toJSONString());
            file.write(readJSON().toJSONString());

           // file.append(readJSON().toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
