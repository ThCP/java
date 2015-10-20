package applications;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Applicant {
	private String name;
	public String getName() {
		return name;
	}

	private Map<String, Integer> capabilities = new HashMap<>();
	
	public Applicant(String name, Map<String, Integer> applicantCapabilites) throws ApplicationException {
		super();
		this.name = name;
		this.capabilities = applicantCapabilites;
	}

	public Collection<String> getCapabilities() {
		Collection<String> capabilitiesSorted = new LinkedList<>();
		capabilities.keySet().stream().sorted().forEach(k -> {
			capabilitiesSorted.add(toStringCapabilities(k, capabilities.get(k)));
		});
		return capabilitiesSorted;
				
	}
	
	public Map<String, Integer> getCapabilitiesMap() {
		return capabilities;
	}
	
	String toStringCapabilities (String key, Integer value){
		return key+":"+value;
	}
}
