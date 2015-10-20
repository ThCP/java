package phonebook;

public class Contact {
	private String first;
	private String last;
	private String phone; 
	private PhoneBook owner;
	

	public Contact(String first, String last, String phone, PhoneBook owner) {
		this.first = first;
		this.last = last;
		this.phone = phone;
		this.owner = owner;
	}
	
	public String getFirst() {
		return first;
	}
	public String getLast() {
		return last;
	}
	public String getPhone() {
		return phone;
	}

	public String asString(){
		return owner.positionOf(this) + ": " + first + " " + last + " " + phone;
//		return (new StringBuffer(first)) . append(" ") . append(last)
//				.append(" ").append(phone).toString();
	}
	

}
