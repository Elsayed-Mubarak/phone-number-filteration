package com.phone.checkphonenumber.controller;

import com.phone.checkphonenumber.logging.ConsoleLogger;
import com.phone.checkphonenumber.service.CustomerService;
import com.phone.checkphonenumber.utils.Countries;
import com.phone.checkphonenumber.view.Page_Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/countries")
    public ResponseEntity<List<String>> getAllCountries() {
        return new ResponseEntity<>(Countries.getAllCountriesNames(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customers")
    public ResponseEntity<Page_Response> getCustomers(
            @RequestParam(value = "countries", required = false) String countries,
            @RequestParam(value = "states", required = false) String states,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {

        ConsoleLogger logger = new ConsoleLogger();
        List<String> countriesList =null;

        List<String> statesList = null;

        if (countries != null) {
            String[] countriesStr = countries.split(",");
            if (countriesStr.length > 0) {
                countriesList = Arrays.asList(countriesStr);
            }
        }
        logger.writeData("Required Countries List", countriesList);
        if (states != null) {
            String[] statesStr = states.split(",");
            if (statesStr.length > 0) {
                statesList = Arrays.asList(statesStr);
            }
        }
        logger.writeData("Required State List", statesList);

        return new ResponseEntity<>(customerService.findPage(page, countriesList, statesList), HttpStatus.OK);
    }
}


