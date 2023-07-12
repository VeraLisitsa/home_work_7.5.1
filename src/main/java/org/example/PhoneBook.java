package org.example;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    public static int countContacts = 0;
    public static Map<String, String> phoneBook = new TreeMap<>();

    public int add(String name, String phoneNumber){
        if(name == null){
            throw new IllegalArgumentException("В параметре name введено недопустимое значение null");
        }
        if (phoneNumber == null){
            throw new IllegalArgumentException("В параметре phoneNumber введено недопустимое значение null");
        }
        if(!phoneBook.containsKey(name)) {
            phoneBook.put(name, phoneNumber);
            countContacts++;
        } else {
            throw new IllegalArgumentException("Такое имя уже существует");
        }
        return countContacts;
    }
}
