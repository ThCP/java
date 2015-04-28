package examples.collections;

public class Person {
	
	public int getId() {
		return id;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	private int id;
	private String first;
	private String last;
	
	public Person(int id, String first, String last){
		this.id=id;
		this.first = first;
		this.last = last;
	}
	
	
	@Override
	public String toString(){
		return "(" + id + ")" + last + ", " + first;
	}
	
	@Override
	public boolean equals(Object o){
		if(o==null) return false;
		if(! (o instanceof Person)) return false;
		
		return ((Person)o).id == this.id;
	}

}
