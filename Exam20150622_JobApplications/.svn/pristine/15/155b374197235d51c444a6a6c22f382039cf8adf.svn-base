package applications;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.*;


public class Skill {

	private String name;
	private Collection<Position> positions = new LinkedList<>();
	
	public Skill(String name) {
		super();
		this.name = name;
	}
	public void addPosition(Position p){
		positions.add(p);
	}
	
	public String getName() {return name;}
	public List<Position> getPositions() {
		return positions.stream().sorted(comparing(Position::getName)).collect(toList());
	}
}