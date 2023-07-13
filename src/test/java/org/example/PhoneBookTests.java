package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PhoneBookTests {
    PhoneBook phoneBook;

    @BeforeEach
    public void beforeEach() {
        phoneBook = new PhoneBook();
    }

    @AfterEach
    public void afterEach() {
        phoneBook = null;
    }

    @Test
    public void addTestNotNull() {
        String name = "name", number = "123456";
        int expected = 1;
        int result = phoneBook.add(name, number);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void addTestNameNull() {
        String name = null, number = "123456";
        Class<IllegalArgumentException> expected = IllegalArgumentException.class;
        Assertions.assertThrows(expected, () -> phoneBook.add(name, number));
    }

    @Test
    public void addTestNumberNull() {
        String name = "name", number = null;
        Class<IllegalArgumentException> expected = IllegalArgumentException.class;
        Assertions.assertThrows(expected, () -> phoneBook.add(name, number));
    }

    @Test
    public void addTestSameName() {
        String name = "name", number = "123456";
        Class<IllegalArgumentException> expected = IllegalArgumentException.class;
        Assertions.assertThrows(expected, () -> {
            phoneBook.add(name, number);
            phoneBook.add(name, number);
        });
    }

    @Test
    public void findByNumberNotNull(){
        String name = "name1", number = "123455";
        phoneBook.add(name, number);
        String expected = "name1";
        String result = phoneBook.findByNumber(number);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findByNumberNull(){
        String name = "name2", number1 = "123455", number2 = "123444";
        phoneBook.add(name, number1);
        Class<NullPointerException> expected = NullPointerException.class;
        Assertions.assertThrows(expected,() -> phoneBook.findByNumber(number2));
    }
    @Test
    public void findByNameNotNull(){
        String name = "name3", number = "111111";
        phoneBook.add(name, number);
        String expected = "111111";
        String result = phoneBook.findByName(name);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findByNameNull(){
        String name1 = "name4", number1 = "222222", name2 = "name5";
        phoneBook.add(name1, number1);
        Class<NullPointerException> expected = NullPointerException.class;
        Assertions.assertThrows(expected,() -> phoneBook.findByName(name2));
    }

    @Test
    public void printAllTest(){
        phoneBook.add("name4", "222222");
        phoneBook.add("name3", "333333");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        phoneBook.printAll();
        String result = outputStream.toString().replace("\r\n", "");
        String expected = "name3-333333name4-222222";
        Assertions.assertEquals(expected, result);
    }


}
