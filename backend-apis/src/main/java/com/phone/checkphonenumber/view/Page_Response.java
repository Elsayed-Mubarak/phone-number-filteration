package com.phone.checkphonenumber.view;

import com.phone.checkphonenumber.entity.Customer;
/*
* Response
* */
import java.util.List;
public class Page_Response {
    public int page;
    public int numberPages;
    public List<Customer> listCustomers;

    public Page_Response(int page, int numberPages, List<Customer> listCustomers) {
        this.page = page;
        this.numberPages = numberPages;
        this.listCustomers = listCustomers;
    }
}
