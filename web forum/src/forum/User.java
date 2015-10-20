package forum;

public class User implements Comparable<User> {
	
	private String nick, first, last, email, password;
    private Long submitted = new Long(0);
	
    public void setSubmitted() {
		this.submitted+=1;
	}

	public User(String nick, String first, String last, String email,
			String password) {
    	this.nick = nick;
    	this.first = first;
    	this.last = last;
    	this.email = email;
    	this.password = password;
    }

	public String getPassword() {
		return password;
	}

	public String getNick(){
        return nick;
    }

    public String getFirst(){
        return first;
    }

    public String getLast(){
        return last;
    }

    public String getEmail(){
        return email;
    }
    
    public void newSubmit(){
    	this.submitted+=1;
    }
    
    public long numSubmitted(){
        return submitted;
    }

    public int compareTo(User arg0) {
        return (this.submitted.intValue() - new Long (arg0.numSubmitted()).intValue());
    }
}
