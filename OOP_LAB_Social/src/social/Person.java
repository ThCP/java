package social;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Person {

	private String name, surname, id;
	private Map<String,Person> friends = new HashMap<>();
	private Collection<String> groups = new LinkedList<>();
	
	public Collection<String> getGroups() {
		return groups;
	}

	public String getId() {
		return id;
	}

	public Person(String ID, String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = ID;
	}

	public void AddFriend (String ID, Person pp){
		friends.put(ID, pp);
	}
	
	@Override
	public String toString() {
		return id + " " + name + " " + surname;
	}
	
	public Collection<Person> getFriends (){
		return friends.values();
	}
	
	public void addGroup(String groupName) {
		groups.add(groupName);
	}

	
}
