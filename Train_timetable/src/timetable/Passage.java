package timetable;


public class Passage {

	String nameStation;
	int hour, minutes, delay;
	
  public Passage(String string, int i, int j) {
	  nameStation = string;
	  hour = i;
	  minutes = j;
		// TODO Auto-generated constructor stub
	}

public String getStation() {
    return nameStation;
  }

  public int getHour() {
    return hour;
  }

  public int getMinutes() {
    return minutes;
  }

  public int delay() {
    return delay;
  }

}
