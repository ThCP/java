package hydraulic;

/**
 * Represents the sink, i.e. the terminal element of a system
 *
 */
public class Sink extends Element {

	double inputFlow;
	
	public double getInputFlow() {
		return inputFlow;
	}

	public void setInputFlow(double inputFlow) {
		this.inputFlow = inputFlow;
		this.outputFlow = inputFlow;
	}
	
	/**
	 * Constructor
	 * @param name
	 */
	public Sink(String name) {
		super(name);
	}
	
	public void connect(Element elem){
		System.out.println ("No elements can have " + this.name + " as an input.");
	}
	
	public Element getOutput(){
		return this;
	}
	
	
	
}
