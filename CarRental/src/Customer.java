public class Customer {
	private String customer_id;
	private String customer_name;
	private String phone_number;

	public Customer(String customer_id, String customer_name, String phone_number) {
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.phone_number = phone_number;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public String getPhone_number() {
		return phone_number;
	}
	
	
}
