package com.phone.checkphonenumber.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryTest {

    Country country = new Country("Cameroon", "+237",
            "\\(237\\)\\ ?[2368]\\d{7,8}$");
    Country country1 = new Country("Uganda", "+256",
            "\\(256\\)\\ ?\\d{9}$");

    @Test
    public void testGetNames() {
        assertEquals("Cameroon", country.getName());
        assertEquals("Uganda", country1.getName());
    }

    @Test
    public void testGetCountryCode() {
        assertEquals("+237", country.getCountryCode());
        assertEquals("+256", country1.getCountryCode());
    }

    @Test
    public void testIsValidNumber() {
        // valid
        assertEquals(true, country.isValidNumber("(237) 697151594"));
        assertEquals(true, country1.isValidNumber("(256) 775069443"));

        // invalid
        assertEquals(false, country.isValidNumber("373 37"));
        assertEquals(false, country.isValidNumber("(237) 838383"));
        assertEquals(false, country.isValidNumber("jsfjsf fhdfh"));
        assertEquals(false, country.isValidNumber("(258) 823747618"));
        assertEquals(false, country.isValidNumber("(237) 6A0311634"));

        assertEquals(false, country1.isValidNumber("(237) 6A0311634"));
        assertEquals(false, country1.isValidNumber("dfgdgf"));
    }
}
