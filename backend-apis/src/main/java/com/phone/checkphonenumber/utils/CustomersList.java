package com.phone.checkphonenumber.utils;

import com.phone.checkphonenumber.entity.Customer;

import java.util.List;

public class CustomersList {
    private List<Customer> customers;

    public List<Customer> getList() {
        return customers;
    }

    public CustomersList(List<Customer> customers) {
        this.customers = customers;
    }

    public void selectCountries(List<String> countries) {
        if (countries != null)
            customers.removeIf(x -> !countries.contains(x.getCountryName().toLowerCase()));
    }

    public void selectStates(List<String> states) {
        if (states != null)
            customers.removeIf(x -> !states.contains((x.getState()) ? "valid" : "notvalid"));
    }

    public List<Customer> getElementsPage(int page, int size) {
        if ((page - 1) * size < customers.size()) {
            if (page * size <= customers.size()) {
                return customers.subList((page - 1) * size, page * size);
            } else {
                return customers.subList((page - 1) * size, customers.size());
            }
        } else {
            if (customers.size() > size) {
                return customers.subList(0, size);
            } else {
                return customers.subList(0, customers.size());
            }
        }
    }
}
