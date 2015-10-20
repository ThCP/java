package forum;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;


public class Forum {
    
	private String url;
	private Map<String, User> users = new HashMap<>();
	private Collection<Topic> topics = new LinkedList<>();
	
    public Forum(String url){
		this.url = url;
    }
    
    public String getUrl(){
        return url;
    }

    public User registerUser(String nick, String first, String last, String email, String password)
        throws DuplicateNickname {
    	if (users.containsKey(nick)) throw new DuplicateNickname();
    	User u = new User(nick, first, last, email, password);
    	users.put(nick, u);
        return u;
    }
    
    public User login(String nick, String password){
        
    	if (users.containsKey(nick)){
    		if (users.get(nick).getPassword().equals(password)){
    			return users.get(nick);
    		}
    	}
    	return null;
    }
    
    public Topic createTopic(String name, String subject, User creator){
    	Topic t = new Topic (name, subject, creator);
    	topics.add(t);
        return t;
    }
    
    public Collection<Topic> listTopic(){
        return topics;
    }
    
    public List<User> rankUsers(){
        return users.values().stream().sorted(comparing(User::numSubmitted).reversed()).collect(toList());
    }
    
    public double averageMessages(){
        double totalMessages = topics.stream().flatMap(m -> m.getMessagges().stream()).count();
        return totalMessages/topics.size();
    }
    
}
