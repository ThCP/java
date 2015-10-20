package forum; 

import java.util.Collection;
import java.util.LinkedList;

public class Topic {

	private String name, subject;
	private User creator;
	private Collection<Message> messages = new LinkedList<> ();
	
    public Topic(String name, String subject, User creator) {
    	this.name = name;
    	this.subject = subject;
    	this.creator = creator;
    }

	public String getName(){
        return name;
    }

    public String getSubject(){
        return subject;
    }

    public User getUser(){
        return creator;
    }
    
    public Message submitMessage(User user, String title, String body){
    	System.out.println(title + "\n" + body);
    	System.out.println(user);
    	Message m = new Message (user, title, body, this);
    	messages.add(m);
    	user.setSubmitted();
    	
        return m;
    }
    
    public Collection<Message> getMessagges(){
        return messages;
    }
    
    public long numMessages(){
        return messages.size();
    }
}
