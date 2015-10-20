package social;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;



public class Social {

	private Map<String, Person> users = new HashMap<>();
	private Map<String, Group> groups = new HashMap<>();
	
	public void addPerson(String code, String name, String surname)
			throws PersonExistsException {
//			try {
				if (users.containsKey(code)) throw new PersonExistsException();
				else {
					Person pp = new Person(code, name, surname);
					users.put(code, pp);
					
				}
//			} catch (PersonExistsException ex) {
//				System.out.println(ex.getMessage());
//			}
	}

	public String getPerson(String code) throws NoSuchCodeException {
				
		if (!users.containsKey(code)) {
			throw new NoSuchCodeException(); // exception
		}
		
		return users.get(code).toString(); // returns the string version of the user
		
	}

	public void addFriendship(String codePerson1, String codePerson2)
			throws NoSuchCodeException {
		if (!users.containsKey(codePerson1) || !users.containsKey(codePerson2)){
			throw new NoSuchCodeException();
		}
		
		users.get(codePerson1).AddFriend(codePerson2, users.get(codePerson2));
		users.get(codePerson2).AddFriend(codePerson1, users.get(codePerson1));
		
	}

	public Collection<String> listOfFriends(String codePerson)
			throws NoSuchCodeException {
		
		if (!users.containsKey(codePerson)) throw new NoSuchCodeException(); // exception
		
		Collection<String> p = users.get(codePerson).getFriends().stream().map(Person::getId).collect(toList());
		return p;
//		return users.get(codePerson).getFriends();
	}

	public Collection<String> friendsOfFriends(String codePerson)
			throws NoSuchCodeException {
		
		if (!users.containsKey(codePerson)) throw new NoSuchCodeException();
		
		return users.get(codePerson).getFriends().stream()
		.map(Person::getFriends)
		.flatMap(Collection::stream)
		.map(Person::getId)
		.collect(toList());
	}

	public Collection<String> friendsOfFriendsNoRepitition(String codePerson)
			throws NoSuchCodeException {
//		Collection<String> p = users.get(codePerson).getFriends().stream().map(Person::getId).collect(toList());
		return users.get(codePerson).getFriends().stream()
		.map(Person::getFriends)
		.flatMap(Collection::stream)
		.distinct()
		.filter(u -> ! u.getId().equals(codePerson))
		
		.map(Person::getId)
		.collect(toList());
	}

	public void addGroup(String groupName) {
		if (groupName.contains(" ")) {
			System.out.println("The group name should be a single word.");
		} else{
			Group gg = new Group (groupName);
			groups.put(groupName, gg);
		}
	}

	public Collection<String> listOfGroups() {
		if (groups.size() > 0){
			return groups.values().stream().map(Group::getName).collect(toList());
		}
		else return new LinkedList<String>();
	}

	public void addPersonToGroup(String codePerson, String groupName) {
		groups.get(groupName).addPerson(codePerson);
		users.get(codePerson).addGroup(groupName);
	}

	public Collection<String> listOfPeopleInGroup(String groupName) {
		return groups.get(groupName).getUsers();
	}

	public String personWithLargestNumberOfFriends() {
		return users.values().stream().max(comparing (u -> u.getFriends().size())).get().getId();
	}
	
	class FriendsOfFriendsExtractor implements Function <Person, Integer>{
		
		@Override
		public Integer apply(Person user) {
			Integer i = new Integer(0);
			try {
				i = friendsOfFriendsNoRepitition(user.getId()).size();
			} catch (NoSuchCodeException e) {
				System.out.println(e.getMessage());
			}
			return i;
		}
		
	}
	
	public String personWithMostFriendsOfFriends() {
		Map<String, Integer> friendsOfFriendsOfUser = new HashMap<>();
		users.values().stream()
				.forEach(u -> {
					String id = u.getId();
					int count;
					try {
						count = friendsOfFriendsNoRepitition(id).size();
					} catch (Exception e) {
						count = 0;
					}
					friendsOfFriendsOfUser.put(id, count);
				});
		
		return friendsOfFriendsOfUser.entrySet().stream().max(comparing (Entry<String,Integer>::getValue)).get().getKey();
//		return null;
	}

	public String largestGroup() {
		return groups.values().stream().max(comparing (g -> g.getUsers().size())).get().getName();
	}

	public String personInLargestNumberOfGroups() {
		return users.values().stream().max(comparing(u ->  u.getGroups().size())).get().getId();
	}

}