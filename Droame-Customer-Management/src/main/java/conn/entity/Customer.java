package conn.entity;

public class Customer {
	private int id;
	private String CusName;
	private String email;
	private String number;
	private String address;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", CusName=" + CusName + ", email=" + email + ", number=" + number + ", address="
				+ address + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCusName() {
		return CusName;
	}
	public void setCusName(String cusName) {
		CusName = cusName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Customer(String cusName, String email, String number, String address) {
		super();
		
		this.CusName = cusName;
		this.email = email;
		this.number = number;
		this.address = address;
	}
	public Customer(int id, String cusName, String email, String number, String address) {
		super();
		this.id = id;
		this.CusName = cusName;
		this.email = email;
		this.number = number;
		this.address = address;
	}
	
	
	

}
