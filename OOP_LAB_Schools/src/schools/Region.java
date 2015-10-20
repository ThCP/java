package schools;

import it.polito.utility.files.CsvParser;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;


public class Region {
	
	private String name;
	private Collection<Community> communities;
	private Map<String,Municipality> municipalities;
	private Map<String,School> schools;
	
	public Region(String name){
		this.name = name;
		communities = new LinkedList<>();
		municipalities = new HashMap<>();
	}
	
	public String getName(){
		return null;
	}
	
	public Collection<School> getSchools() {
		return null;
	}
	
	public Collection<Community> getCommunities() {
		return null;
	}
	
	public Collection<Municipality> getMunicipalies() {
		return null;
	}
	
	
	// factory methods
	
	public Community newCommunity(String name, Community.Type type){
		Community c = new Community (name, type);
		communities.add(c);
		return null;
	}

	public Municipality newMunicipality(String nome, String provincia, String codiceAF, String nomeAF){
		return null;
	}
	public Municipality newMunicipality(String nome, String provincia, String codiceAF, String nomeAF,Community comunita){
		return null;
	}
	
	public School newSchool(String name, String code, int grade,
			String description, String managementType, String legalPosition){
		return null;
	}
	
	public Branch newBranch(int regionalCode, String branchType, Municipality municipality, String indirizzo, int cap,
							String locality, String telephone, String fax,School school)	{
		return null;
	}
	
	public void readData(String url) throws IOException{
		
		CsvParser parser = CsvParser.createInstance();
		parser.openNamedRowsUrl(url)
			.forEach(
					row -> {
						String mountain = row.get("Comunita Montana");
						String hill = row.get("Comunita Collinare");
						Community comm = 
						communities.stream()
						.filter( c -> c.getName().equals(hill) ||
								c.getName().equals(hill)
								)
						// Instead of the following
//						
//						.findFirst().orElse(null);
						
//						if (comm == null) { //if the community is null, I create it
//							if (! hill.equals("NESSUNA COMUNITA' COLLINARE")){
//								// a valid name for the community is provided
//								newCommunity (hill, Community.Type.COLLINARE);
//							} else {
//								if ( ! mountain.equals ("NESSUNA COMUNITA' MONTANA")){
//									// a valid name for the mountain community is provided
//									newCommunity (mountain, Community.Type.MONTANA);
//								}
//							}
//						}
//						
//						I can use this
						.findFirst().orElseGet(
								() -> {
									if (! hill.equals("NESSUNA COMUNITA' COLLINARE")){
										return newCommunity (hill, Community.Type.COLLINARE);
									}
									if (! mountain.equals("NESSUNA COMUNITA' MONTANA")){
										return newCommunity (mountain,Community.Type.MONTANA);
									}
									return null;
								}
								);
						
//						Now  I need to create the municipality
						
//						Municipality m = municipalities.get(row.get("Comune"));
//						if ( m == null) {
//							newMunicipality (/*all the arguments*/);
//						}
//						OR
//						
						Municipality m = municipalities.computeIfAbsent(row.get("Comune"),
								// I provide a method able to create a new municipality
								name -> new Municipality (name, 
															row.get("Provincia"),
															row.get("Ambito Funzionale"),
															row.get("Denominazione Ambito Funzionale"),
															comm
										)
								);
						// Create or retrieve school
						
						// Create or retrieve branch
					});
		
	}


	public Map<String,Long>countSchoolsPerDescription(){
		return schools.values().stream()
//				.collect(groupingBy( school -> school.getDescription(),
//					counting()))
//				;
		
				.collect(groupingBy( School::getDescription, counting()));
				
	}

	

	public Map<String,Long>countBranchesPerMunicipality(){
		return schools.values().stream() // stream of School
				.map(School::getBranches) // stream of Collection<Branch>
				.flatMap(Collection::stream) // stream of Branch
				.collect(groupingBy( b -> b.getMuniciality().getName(), // Map<String,Collection<Branch>>
						counting()))// Map<String,Long>
				;
		
		// OR (having a collection of branches available)
		return branches.stream() // not available in this class
				.collect(groupingBy( b -> b.getMuniciality().getName(), // Map<String,Collection<Branch>>
						counting()))// Map<String,Long>
				;
	}

	

	public Map<String,Double>averageBranchesPerMunicipality(){
		
		municipalities.values().stream()
		//.map(m -> m.getBranches().size())
		.collect(averagingInt(m -> m.getBranches().size())); // averagingInt already contains the map function
		
		//OR
		
		municipalities.values().stream()
		.mapToInt( m-> m.getBranches().size())
		.average().orElse(0); // average has as an input an optional so I need orElse in order to account for the null cases
		
		return municipalities.values().stream()
				.collect(groupingBy( Municipality::getProvince, 
					averagingInt((Municipality m) -> m.getBranches().size())	// I need to put municipality because the compiler can't understand what is the type of m
					));
	}


	public Collection<String> countSchoolsPerMunicipality(){
		
		Map <String,Set<School>> step1 = 
				schools.values().stream().flatMap( s-> getBranches().stream())
				.collect(groupingBy(b -> b.getMunicipality().getName().toSet().
						mapping(Branch::getSchool, toSet())
						))
						;
		return step1.entrySet().stream().map(e -> e.getValue().size() + " - " + e.getKey() )
				.collect(toList());
	}
	

	public List<String> countSchoolsPerCommunity(){
		Map <String,Set<School>> step1 = 
				schools.values().stream().flatMap( s-> getBranches().stream())
				.filter(b -> b.getMunicipality().getCommunity().isPresent())
				.collect(groupingBy(b -> b.getMunicipality().getCommunity().get().getName().
						mapping(Branch::getSchool, toSet())
						))
						;
		return step1.entrySet().stream().map(e -> e.getValue().size() + " - " + e.getKey() )
				.collect(toList());
	}

	
}
