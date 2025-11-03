package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {

    private Map<String, Contact> data = new HashMap<>();


     public Map<String, Contact> getData(){
        return data;
             }
     public void addContact(Contact c) {
        data.put(c.getCode(), c);
     }

     public void deleteContact(String code) {
         data.remove(code);
     }

     public void showPhonebook() {
        for (Contact c : data.values()) {
            c.showContactDetails();
                 }
     }
}



