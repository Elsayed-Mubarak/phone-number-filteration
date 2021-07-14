package com.phone.checkphonenumber.utils;

import com.phone.checkphonenumber.entity.Customer;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CountriesListTest {

    List<Customer> customers1;
    List<Customer> customers2;
    List<Customer> customers3;

    public CountriesListTest() {
        Customer c1 = new Customer(1, "Ricardo Santos", "(237) 697151594");
        Customer c2 = new Customer(2, "Test1", "(258) 849181828");
        Customer c3 = new Customer(3, "Test1", "(251) 9119454961");
        Customer c4 = new Customer(4, "Test1", "(251)9119454961");
        Customer c5 = new Customer(5, "Test1", "(222) jfr");
        Customer c6 = new Customer(6, "Test1", "(258) 84330678235");
        customers1 = new LinkedList<Customer>();
        customers1.add(c1);
        customers1.add(c2);
        customers1.add(c3);
        customers1.add(c4);
        customers1.add(c5);
        customers2 = new LinkedList<Customer>();
        customers2.add(c2);
        customers2.add(c5);
        customers3 = new LinkedList<Customer>();
        customers3.add(c6);
    }

    @Test
    public void selectCountries() {
        CustomersList firstList = new CustomersList(customers1);
        List<String> countriesToSelect = new LinkedList<String>();
        countriesToSelect.add("portugal");
        countriesToSelect.add("cameroon");
        countriesToSelect.add("ethiopia");
        firstList.selectCountries(countriesToSelect);
        assertEquals(2, firstList.getList().size());
        CustomersList sacandList = new CustomersList(customers2);
        sacandList.selectCountries(countriesToSelect);
        assertEquals(0, sacandList.getList().size());
    }

    @Test
    public void selectStates() {
        CustomersList l1 = new CustomersList(customers1);
        List<String> statesToSelect = new LinkedList<String>();
        statesToSelect.add("valid");
        statesToSelect.add("notvalid");
        l1.selectStates(statesToSelect);
        assertEquals(5, l1.getList().size());

        CustomersList l2 = new CustomersList(customers1);
        List<String> statesToSelect1 = new LinkedList<String>();
        statesToSelect1.add("valid");
        l2.selectStates(statesToSelect1);
        assertEquals(2, l2.getList().size());

        CustomersList l3 = new CustomersList(customers2);
        l3.selectStates(statesToSelect1);
        assertEquals(1, l3.getList().size());
    }

    @Test
    public void getElementsPage() {

        CustomersList l1 = new CustomersList(customers1);
        assertEquals(customers1.subList(0, 2), l1.getElementsPage(1, 2));
        assertEquals(customers1.subList(2, 4), l1.getElementsPage(2, 2));
        assertEquals(customers1.subList(4, 5), l1.getElementsPage(3, 2));

        CustomersList l2 = new CustomersList(customers1);
        assertEquals(customers1.subList(0, 1), l2.getElementsPage(6, 1));
        assertEquals(customers1.subList(0, 1), l2.getElementsPage(1, 1));
        assertEquals(customers1.subList(1, 2), l2.getElementsPage(2, 1));
        assertEquals(customers1.subList(2, 3), l2.getElementsPage(3, 1));

        CustomersList l3 = new CustomersList(customers2);
        assertEquals(customers2.subList(0, 2), l3.getElementsPage(1, 20));
    }

}
