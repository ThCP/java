package taxi;

public class Passenger {

	private Place userPosition;
	
	public void setUserPosition(Place userPosition) {
		this.userPosition = userPosition;
	}

	public Passenger(Place pos) {
		userPosition = pos;
	}
	
	public Place getPlace() {
		return userPosition;
	}

}
