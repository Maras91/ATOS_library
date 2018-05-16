package library;

import java.util.ArrayList;
import java.util.List;

public class CustomersList {

	private List<Customer> allCustomers;

	public CustomersList() {
		allCustomers = new ArrayList<Customer>();
	}

	public void addCustomer(String name, String surname) {
		allCustomers.add(new Customer(name, surname));
	}

	public Customer findCustomerkById(int id) {
		for (Customer customer : allCustomers) {
			if (customer.getId() == id) {
				return customer;

			}
		}
		throw new IllegalArgumentException("The customer with id: " + id + " not exist");
	}
}
