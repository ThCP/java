package hydraulic;

/**
 * Represents a split element, a.k.a. T element
 * 
 * During the simulation each downstream element will
 * receive a stream that is half the input stream of the split.
 */

public class Split extends Element {
	
	double inputFlow, outputFlow;
	
	int nElements = 0;
	Element [] downstream = new Element[2];
	/**
	 * Constructor
	 * @param name
	 */
	public Split(String name) {
		super(name);
	}
    
	/**
	 * returns the downstream elements
	 * @return array containing the two downstream element
	 */
    public Element[] getOutputs(){
        return downstream;
    }
    
	public void connect(Element elem, int noutput){
		downstream[noutput] = elem;
		nElements++;
	}
	
	public double getOutputFlow() {
		return outputFlow;
	}

	public void setOutputFlow(double inputFlow) {
		if (nElements != 0) {
			this.outputFlow = inputFlow/nElements;
		} else {
			this.outputFlow = inputFlow;
		}
	}
	
	public String toLayout(){
		String s = new String("[" + this.name + "]" + " +-> ");
		return s;
	}
}
