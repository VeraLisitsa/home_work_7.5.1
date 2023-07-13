package org.example;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PhoneBookTests {
    PhoneBook phoneBook;

    @BeforeEach
    public void beforeEach() {
        phoneBook = new PhoneBook();
        phoneBook.add("name", "111111");
    }

    @AfterEach
    public void afterAll() {
        phoneBook = null;

    }

    @Test
    public void addTestNotNull() {
        String name = "name1", number = "222222";
        int expected = 2;
        int result = phoneBook.add(name, number);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void addTestNameNull() {
        String name = null, number = "333333";
        Class<IllegalArgumentException> expected = IllegalArgumentException.class;
        Assertions.assertThrows(expected, () -> phoneBook.add(name, number));
    }

    @Test
    public void addTestNumberNull() {
        String name = "name2", number = null;
        Class<IllegalArgumentException> expected = IllegalArgumentException.class;
        Assertions.assertThrows(expected, () -> phoneBook.add(name, number));
    }

    @Test
    public void addTestSameName() {
        String name = "name", number = "444444";
        Class<IllegalArgumentException> expected = IllegalArgumentException.class;
        Assertions.assertThrows(expected, () -> {
            phoneBook.add(name, number);
            phoneBook.add(name, number);
        });
    }

    @Test
    public void findByNumberNotNull() {
        String number = "111111";
        String expected = "name";
        String result = phoneBook.findByNumber(number);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findByNumberNull() {
        String number = "555555";
        Class<NullPointerException> expected = NullPointerException.class;
        Assertions.assertThrows(expected, () -> phoneBook.findByNumber(number));
    }

    @Test
    public void findByNameNotNull() {
        String name = "name";
        String expected = "111111";
        String result = phoneBook.findByName(name);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findByNameNull() {
        String name = "name3";
        Class<NullPointerException> expected = NullPointerException.class;
        Assertions.assertThrows(expected, () -> phoneBook.findByName(name));
    }

    @Test
    public void printAllTest() {
        PhoneBook phoneBook1 = new PhoneBook();
        phoneBook1.add("bName", "111111");
        phoneBook1.add("aName", "222222");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        phoneBook1.printAll();
        String result = outputStream.toString().replace("\r\n", "");
        String expected = "aName-222222bName-111111";
        Assertions.assertEquals(expected, result);
    }


}
