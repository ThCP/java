package trail;

public class Runner {
	int bib;
	String name;
	String surname;
	private Passage lastPassage;
    
    public Runner(int i, String name, String surname) {
		this.bib = i;
		this.name = name;
		this.surname = surname;
	}

	public int getBibNumber(){
        return bib;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }
    
    int lastLocationOrderNumber(){
    		return lastPassage.location.getOrderNum();
    }

    long lastPassageTime(){
    	  return lastPassage.timestamp;
    }

	 void setLastPassage(Passage p) {
		lastPassage = p;
	}
	 
	 boolean hasLastPassage(){
		 return lastPassage != null;
	 }
}



