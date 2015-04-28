package hydraulic;

/**
 * Represents a source of water, i.e. the initial element for the simulation.
 *
 * The status of the source is defined through the method
 * {@link #setFlow(double) setFlow()}.
 */
public class Source extends Element {
	
	/**
	 * Constructor method
	 * 
	 * @param name
	 */
	
	public Source(String name) {
		super(name);
		//flow = 0.0;
	}

	public void setFlow(double flow){
		this.inputFlow = flow;
		this.outputFlow = flow;
	}

	public double getOutputFlow() {
		return outputFlow;
	}
}
