package com.phone.checkphonenumber.service.service_impl;

import com.phone.checkphonenumber.entity.Customer;
import com.phone.checkphonenumber.repository.CustomerRepository;
import com.phone.checkphonenumber.service.CustomerService;
import com.phone.checkphonenumber.utils.CustomersList;
import com.phone.checkphonenumber.view.Page_Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page_Response findPage(int page, List<String> countries, List<String> states) {
        Pageable pageable = PageRequest.of(page - 1, 20);
        Page<Customer> page1 = customerRepository.findAll(pageable);
        CustomersList list = new CustomersList(customerRepository.findAll());
        list.selectStates(states);
        list.selectCountries(countries);
        return new Page_Response(page, page1.getTotalPages(), list.getElementsPage(page, page1.getSize()));
    }

}