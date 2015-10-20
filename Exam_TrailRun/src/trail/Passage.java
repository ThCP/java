package trail;

class Passage {

	long timestamp;
	Delegate delegate;
	Location location;
	Runner runner;
	
	public Passage(long timestamp, Delegate d, Location l, Runner r) {
		this.timestamp = timestamp;
		this.delegate = d;
		this.location = l;
		this.runner=r;
	}

}
