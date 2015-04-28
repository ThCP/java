package hydraulic;

/**
 * Represents a tap that can interrupt the flow.
 * 
 * The status of the tap is defined by the method
 * {@link #setOpen(boolean) setOpen()}.
 */

public class Tap extends Element {
	
	boolean status; 
	double inputFlow, outputFlow;
	/**
	 * Constructor method
	 * 
	 * @param name
	 */
	public Tap(String name) {
		super(name);
		status = false;
		inputFlow = 0.0;
	}
	
	public void setOpen(boolean open){
		status = open;
	}

	public double getInputFlow() {
		return inputFlow;
	}
	
	public double getOutputFlow() {
		return outputFlow;
	}
	
	public void setInputFlow(double inputFlow) {
		this.inputFlow = inputFlow;
	}
	
	/**
	 * Setter method for the output flow, the output depends on the value of status (tap open or closed)
	 * 
	 */
	
	public void setOutputFlow(double Flow) {
		this.inputFlow = Flow;
		if (this.status) {
			this.outputFlow = inputFlow;
		} else {
			this.outputFlow = 0.0;
		}
	}
	
}
