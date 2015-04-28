package processor;

public interface Processor {

	void handle(Object o);
	
	default boolean isValid(Object o){
		return true;
	}
	
}
