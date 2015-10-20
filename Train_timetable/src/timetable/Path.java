package timetable;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Path {

	private String code;
	private String category;
	boolean isExtraordinary = false;
	
	private Collection<TrainStop> stops = new LinkedList<>();
	private Collection<Train> trains = new LinkedList<>();
	
  public Path(String code, String category) {
		this.code = code;
		this.category = category;
	}

  public String getCode() {
    return code;
  }

  public String getCategory() {
    return category;
  }

  public boolean isExtraordinary() {
    return isExtraordinary;
  }

  public void setExtraordinary(boolean b) {
    isExtraordinary = b;
  }

  public TrainStop addStop(String stationName, int hour, int minutes) {
	  TrainStop ts = new TrainStop (stationName, hour, minutes);
	  stops.add(ts);
	  return ts;
  }

  public List getTrainStops() {
	  return stops.stream().sorted(comparing(TrainStop::getHour).thenComparing(TrainStop::getMinutes)).collect(toList());
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

  public void addTrain(Train t){
	  trains.add(t);
  }
  
  public Collection <Train> getTrains(){
	  return trains.stream().sorted(comparing(Train::getYear).thenComparing(Train::getMonth).thenComparing(Train::getDay)).collect(toList());
  }
  
}
