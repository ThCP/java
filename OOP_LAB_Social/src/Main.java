

import java.util.Collection;

import social.NoSuchCodeException;
import social.PersonExistsException;
import social.Social;
import social.SocialGui;

public class Main {

	public static void main(String[] args) {

		Social f = new Social();
		
		
		try {
			f.addPerson("Mario99", "Mario", "Rossi");
			f.addPerson("Mario88", "Mario", "Verdi");
			f.addPerson("Elena66", "Elena", "Aresti");
			f.addPerson("BigLupo", "Lupo", "Bianchi");
			f.addPerson("FFA", "Franca", "Rosetti");
			f.addPerson("Sally", "Sandra", "Sandroni");
			
			String s = f.getPerson("Mario99"); // "Mario99 Mario Rossi"
			System.out.println(s);
			
			try {
				String n = f.getPerson("dfg"); // No entry should be returned
			} catch (NoSuchCodeException ex){
				System.out.println(ex.getMessage());
			}
			
			f.addFriendship("Mario99", "BigLupo");
			f.addFriendship("Mario99", "Elena66");
			f.addFriendship("Elena66", "FFA");
			f.addFriendship("Elena66", "Sally");
			f.addFriendship("BigLupo", "FFA");
			
			Collection<String> friends = f.listOfFriends("Mario99"); // "Elena66" "BigLupo"    
				System.out.println("Friends of Mario99");
			System.out.println(friends);
			friends = f.listOfFriends("Elena66"); // "FFA" "Mario99" "Sally"			
			System.out.println(friends);
			friends = f.friendsOfFriends("Mario99"); // "FFA" "Sally"
			System.out.println("Friends of friends of Mario99");
			System.out.println(friends);
			friends = f.friendsOfFriendsNoRepitition("Mario99"); // "FFA" "Sally"
			System.out.println("Friends of friends of Mario99 no rep");
			System.out.println(friends);
			
			String id = f.personWithLargestNumberOfFriends();
			System.out.println(id);
			
			id = f.personWithMostFriendsOfFriends(); // "FFA"
			System.out.println(id);
			
			f.addGroup("non va");
			f.addGroup("va");
			
			String g = f.largestGroup();
			System.out.println(g);
			
			new SocialGui(f);
		} catch (PersonExistsException e) {
		} catch (NoSuchCodeException e) {
		
		}
	}
}