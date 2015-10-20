package timetable;


public class Train {
	
	private boolean isExtraordinary = false;
	
	private Path path;
	String code;
	int day, month, year;
	String category;
	private Passage lastPassage;
	
  public Train(String code, int day, int month, int year, Path path) {
		this.code = code;
		this.day = day;
		this.month = month;
		this.year = year;
		this.path = path;
	}

  public boolean isExtraordinary() {
	  return isExtraordinary;
  }
  
  public void setExtraordinary(boolean isExtraordinary) {
	  this.isExtraordinary = isExtraordinary;
  }
  
  public Path getPath() {
    return path;
  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }

  public Passage registerPassage(String string, int i, int j) 
  	throws InvalidStop {
	  if (!path.getTrainStops().contains(string)) throw new InvalidStop();
	  Passage p = new Passage (string, i, j);
	  this.lastPassage = p;
	  return this.lastPassage;
  }

  public boolean arrived() {
    // TODO Auto-generated method stub
    return false;
  }

  public int maxDelay() {
    // TODO Auto-generated method stub
    return 0;
  }
  public int minDelay() {
    // TODO Auto-generated method stub
    return 0;
  }
  public int totalDelay() {
    // TODO Auto-generated method stub
    return 0;
  }

}
