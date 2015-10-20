package trail;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import static java.util.stream.Collectors.*;

public class Location {
	private String name;
	private int pos;
	private Collection<Delegate> delegates = new LinkedList<>();
	private Collection<Passage> passages = new LinkedList<>();

    public Location(String location, int size) {
		this.name = location;
		this.pos = size;
	}

	public String getName(){
        return name;
    }

    public int getOrderNum(){
        return pos;
    }

	public void assignDelegate(Delegate d) {
		delegates.add(d);
	}

	public Collection<Delegate> getDelegates() {
		return delegates;
	}

	 void addPassage(Passage p) {
		passages.add(p);
	}

	 long getPassage(int bibNumber) {
		return
		passages.stream()
			.filter( p -> p.runner.getBibNumber()==bibNumber)
			.mapToLong( p -> p.timestamp)
			.findFirst()
			.orElse(-1);
	}

	 List<Runner> getRanking() {
		return passages.stream().map( p -> p.runner).collect(toList());
	}

	public boolean hasDelegate(Delegate d) {
		return delegates.contains(d);
	}
}
