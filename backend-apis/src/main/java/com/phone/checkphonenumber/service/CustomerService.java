package com.phone.checkphonenumber.service;

import com.phone.checkphonenumber.entity.Customer;
import com.phone.checkphonenumber.repository.CustomerRepository;
import com.phone.checkphonenumber.view.Page_Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAll();
    public Page_Response findPage(int page, List<String> countries, List<String> states);
    private boolean isValidList(List<String> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        return true;
    }
}
