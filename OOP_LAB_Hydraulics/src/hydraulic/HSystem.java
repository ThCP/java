package hydraulic;

import java.util.ArrayList;

/**
 * Main class that act as a container of the elements for
 * the simulation of an hydraulics system 
 * 
 */
public class HSystem {
	
	ArrayList<Element> elements = new ArrayList<Element>(); // Definition of arraylist, I use a list because I don't know how many elements are present
	
	/**
	 * Adds a new element to the system
	 * @param elem
	 */
	public void addElement(Element elem){
		elements.add(elem);
	}
	
	/**
	 * returns the element added so far to the system
	 * @return an array of elements whose length is equal to the number of added elements
	 */
	public Element[] getElements(){
		Element [] e = new Element[elements.size()];
		for (int i = 0; i < elements.size(); i++){
			e[i] = (Element) elements.get(i);
		}
		return e;
	}
	
	/**
	 * Prints the layout of the system starting at each Source
	 */
	public String layout(){
		
		StringBuffer sb = new StringBuffer();
		
		for (Element i : getElements()){
			if (i instanceof Source){
				i.toLayout(i);
				break;
			}
		}
		
		for (Element i : getElements()){
			if (i instanceof Split){
			}
			sb.append(i.toLayout(getElements()[0]));
		}
		return sb.toString();
	}
	
	/**
	 * starts the simulation of the system
	 * 
	 * For each possible element, the function prints a string which describes name, input flow, output flow of the element
	 * 
	 */
	
	public void simulate(){
		
		for (Element i : getElements()){
			if (i instanceof Source){
				i.setFlowRecursive(i);
				break;
			}
		}
		
		for (Element i : getElements()){
			System.out.println (
					"Name: " + i.getName() + 
					" Input Flow: " + i.getInputFlow() + 
					" Output Flow: " + i.getOutputFlow()				
					);
		}
		
		
	}
	
	public void printElementList(){
		for (Element i:getElements()){
			System.out.println( i.getName() );
		}
	}
}
