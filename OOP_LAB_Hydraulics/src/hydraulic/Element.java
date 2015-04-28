package hydraulic;

/**
 * Represents the generic abstract element of an hydraulics system.
 * It is the base class for all elements.
 *
 * Any element can be connect to a downstream element
 * using the method {@link #connect(Element) connect()}.
 */
public class Element {
	
	String name = new String(); 
	Element downstream;
	double inputFlow, outputFlow;
	
	
	public double getInputFlow() {
		return inputFlow;
	}

	public void setInputFlow(double inputFlow) {
		this.inputFlow = inputFlow;
	}

	public double getOutputFlow() {
		return outputFlow;
	}

	public void setOutputFlow(double outputFlow) {
		this.outputFlow = outputFlow;
	}

	/**
	 * Constructor
	 * @param name the name of the element
	 */
	public Element(String name){
		this.name = name;
	}

	/**
	 * getter method
	 * @return the name of the element
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Connects this element to a given element.
	 * The given element will be connected downstream of this element
	 * @param elem the element that will be placed downstream
	 */
	public void connect(Element elem){
		this.downstream = elem;
	}
	
	/**
	 * Retrieves the element connected downstream of this
	 * @return downstream element
	 */
	
	public Element getOutput(){
		return this.downstream;
	}
		
	public void setFlowRecursive(Element e){
		
		if (e instanceof Sink){
			// this is a sink
			//System.out.println ( "Name: " + e.getName() + " Input Flow: " + e.getInputFlow());
			return;
		} else {
			// check the element type
			if (e instanceof Source){ //this is a source
				e.getOutput().setInputFlow(e.getOutputFlow());
				e.setFlowRecursive(e.downstream);
			}else if ( e instanceof Tap){//this is a tap
				e.setOutputFlow(e.getInputFlow());
				e.getOutput().setInputFlow(e.getOutputFlow());
				e.setFlowRecursive(e.downstream);
			} else if (e instanceof Split){// this is a split
				e.setOutputFlow(e.getInputFlow());
				((Split) e).getOutputs()[0].setInputFlow(e.getOutputFlow());// I must access both ends and set their flows
				((Split) e).getOutputs()[1].setInputFlow(e.getOutputFlow());
				e.setFlowRecursive(((Split) e).getOutputs()[0]);
				e.setFlowRecursive(((Split) e).getOutputs()[1]);
			}
			else {
				System.out.println("Element not known."); // I should never end here, the method breaks down
			}
		}
	}
	
	
	public String toLayout(Element e){
		if (e instanceof Sink){
			String s = new String("[" + this.name + "]" + " -> ");
			return s;
		} else {
			if (e instanceof Source){ //this is a source
				e.toLayout(e.downstream);
			}else if ( e instanceof Tap){//this is a tap
				e.toLayout(e.downstream);
			} else if (e instanceof Split){// this is a split
				e.toLayout(((Split) e).getOutputs()[0]);
				e.toLayout(((Split) e).getOutputs()[1]);
			}
			else {
				System.out.println("Element not known."); // I should never end here, the method breaks down
			}
		
			String s = new String("[" + this.name + "]" + " -> ");
			
			return s;
			
		}
		
	}
	
}
