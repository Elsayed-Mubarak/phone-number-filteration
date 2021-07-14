package com.phone.checkphonenumber.utils;

import com.phone.checkphonenumber.logging.ConsoleLogger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Countries {
    static Map<String, Country> countries = new HashMap<String, Country>();

    /*
     * Static Block Will Excute First.
     *
     * */
    static {
        countries.put("+237", new Country("Cameroon", "+237",
                "\\(237\\)\\ ?[2368]\\d{7,8}$"));
        countries.put("+251", new Country("Ethiopia", "+251",
                "\\(251\\)\\ ?[1-59]\\d{8}$"));
        countries.put("+212", new Country("Morocco", "+212",
                "\\(212\\)\\ ?[5-9]\\d{8}$"));
        countries.put("+258", new Country("Mozambique", "+258",
                "\\(258\\)\\ ?[28]\\d{7,8}$"));
        countries.put("+256", new Country("Uganda", "+256",
                "\\(256\\)\\ ?\\d{9}$"));
    }

    /*
     * Get All Countries.
     * @return list of countries names
     * */
    public static List<String> getAllCountriesNames() {
        ConsoleLogger logger = new ConsoleLogger();
        List<String> listCountries = new LinkedList<>();
        countries.values().forEach(x -> {
            listCountries.add(x.getName());
            logger.writeData("countries.values :", countries.values());
        });
        return listCountries;
    }

    public static String getCountryName(String countryCode) {
        Country country = countries.get(countryCode);
        if (country != null) {
            return country.getName();
        }
        return "";
    }

    public static Boolean isValidNumber(String countryCode, String phone) {
        Country country = countries.get(countryCode);
        if (country != null) {
            if (country.isValidNumber(phone)) {
                return true;
            }
        }
        return false;
    }
}
