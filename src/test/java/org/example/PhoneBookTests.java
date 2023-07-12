package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
