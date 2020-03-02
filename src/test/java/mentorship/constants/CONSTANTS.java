package mentorship.constants;

import java.util.HashMap;

public class CONSTANTS {

    public static final String EMAIL = "admin@phptravels.com";
    public static final String PASSWORD = "demoadmin";

    static HashMap<String, String> hashMap = new HashMap<String, String>();

    public static HashMap<String, String> setConstantInHashMap(String key, String value) {
        hashMap.put(key, value);
        return hashMap;
    }

    public static String getFromHashMapByKey(String keyValue) {
//        iterate existing values in hashmap for info
//       for (Map.Entry<String, String> entry : hashMap.entrySet()) {
//          String key = entry.getKey();
//          String value = entry.getValue();
//          System.out.println(key+ value);
//       }

        String value = hashMap.get(keyValue);
        return value;
    }


}
