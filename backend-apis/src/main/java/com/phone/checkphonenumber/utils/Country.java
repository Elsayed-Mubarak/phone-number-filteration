package com.phone.checkphonenumber.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
@Getter
@Setter
public class Country {

    private String name;
    private Pattern pattern;
    private String countryCode;

    public Country(String name, String countryCode, String pattern) {
        this.name = name;
        this.countryCode = countryCode;
        this.pattern = Pattern.compile(pattern);
    }

    /*
     * @Params (phone)
     * return (true) or (false)
     * */
    public boolean isValidNumber(String phone) {
        Matcher r = pattern.matcher(phone);
        if (r.matches()) {
            return true;
        }
        return false;
    }
}
