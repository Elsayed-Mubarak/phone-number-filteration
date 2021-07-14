package com.phone.checkphonenumber.entity;

import com.phone.checkphonenumber.utils.Countries;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private String name;
    private String phone;

    /*
    * EX : phone_num = (212) 6007989253
    * */
    public String getCode() {
        // spPhone = (212)
        String[] spPhone = phone.split(" ");
        if (spPhone.length == 2) {
            return spPhone[0].replace("(", "+").replace(")", "");
        }
        return null;
    }

    public String getNumber() {
        // EX : 6007989253
        String[] spPhone = phone.split(" ");
        if (spPhone.length == 2) {
            return spPhone[1];
        }
        return null;
    }

    public String getCountryName() {
        return Countries.getCountryName(getCode());
    }

    public Boolean getState() {
        return Countries.isValidNumber(getCode(), getPhone());
    }
}
