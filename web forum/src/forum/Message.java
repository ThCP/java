package forum;

public class Message {
	
	private String title, body;
	private User user;
	private Topic topic;
	
    public Message(User user, String title, String body, Topic topic) {
    	this.title = title;
    	this.body = body;
    	this.user = user;
    	this.topic = topic;
    }

	public String getTitle(){
        return title;
    }
    
    public String getBody(){
        return body;
    }
    
    public User getUser(){
        return user;
    }
    
    public Topic getTopic(){
        return topic;
    }
    
    public long getTimestamp(){
        return System.currentTimeMillis();
    }
}
