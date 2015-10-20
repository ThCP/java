package timetable;


public class TrainStop {
	
	private String stationName;
	private int hour, minutes;
	
  public TrainStop(String stationName, int hour, int minutes) {
	  this.stationName = stationName;
	  this.hour = hour;
	  this.minutes = minutes;
  }

  public String getStation() {
    return stationName;
  }

  public int getHour() {
    return hour;
  }

  public int getMinutes() {
    return minutes;
  }

}
