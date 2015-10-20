package applications;

import java.util.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class Position {

	private Collection<Skill> skills = new LinkedList<>();

	private Map<String,Applicant> applicants = new HashMap<>();
	private String name;
	
	private String winner = null;
	
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public Collection<Skill> getSkills() {
		return skills;
	}
	public void setSkills(Collection<Skill> skills) {
		this.skills = skills;
	}

	
	public Position(String name, Collection<Skill> skills) {
		super();
		this.name = name;
		this.skills = skills;
	}

	public String getName() {return name;}
	
	public void addApplicant(String name, Applicant a){
		applicants.put(name, a);
	}
	
	public List<String> getApplicants() {
		return applicants.values().stream().sorted(comparing(Applicant::getName)).map(Applicant::getName).collect(toList());
	}
	
	public String getWinner() {
		
		return winner; 
	}
}