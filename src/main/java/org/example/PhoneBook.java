package org.example;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class PhoneBook {

    private static int countContacts = 0;
    private static Map<String, String> phoneBook = new TreeMap<>();

    public int add(String name, String phoneNumber) {
        if (name == null) {
            throw new IllegalArgumentException("В параметре name введено недопустимое значение null");
        }
        if (phoneNumber == null) {
            throw new IllegalArgumentException("В параметре phoneNumber введено недопустимое значение null");
        }
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, phoneNumber);
            countContacts++;
        } else {
            throw new IllegalArgumentException("Такое имя уже существует");
        }
        return countContacts;
    }

    public String findByNumber(String number) {
        Optional<String> result = phoneBook.entrySet()
                .stream()
                .filter(entry -> number.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new NullPointerException("Нет такого номера");
        }
    }

    public String findByName(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        }
        throw new NullPointerException("Нет такого имени");
    }

    public void printAll() {
    }
}
