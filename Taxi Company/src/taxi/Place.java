package taxi;

public class Place {

	private String address, district;
	
	public Place(String ind, String quart) {
		this.address = ind;
		this.district = quart;
	}
	
	public String toString(){
		return address;
	}
	
}
