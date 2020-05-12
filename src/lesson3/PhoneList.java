package lesson3;

import java.util.HashMap;
import java.util.Map;

public class PhoneList {
    HashMap<String, String> phoneList = new HashMap<>();

    public void add(String phoneNumber, String name) {

        phoneList.put(phoneNumber,name);
    }

    public void get(String name){
        for (Map.Entry person :phoneList.entrySet()) {
            if (name.equals(person.getValue())){
                System.out.println(person.getKey());
            }
        }

    }
}
