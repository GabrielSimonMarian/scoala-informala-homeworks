package ro.sci.shop;

public interface CustomerDao {

	void getCustomerById(int custormerId);

	void getAllCustomers();

	void createCustomer(int index, String name, String email);

	void readAll();

}
