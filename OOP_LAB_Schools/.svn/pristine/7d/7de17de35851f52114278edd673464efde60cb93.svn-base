

import it.polito.utility.files.CsvParser;

import java.util.Map;

import schools.Branch;
import schools.Community;
import schools.Municipality;
import schools.Region;
import schools.School;
import static java.util.stream.Collectors.*;


public class Example {

	public static void main(String[] args) throws Exception {
		
		
		Region region = new Region("Piemonte");
		
		Community cc = region.newCommunity("PoliTo Hills", Community.Type.COLLINARE);
		
		Municipality to =region.newMunicipality("Torino", "TO", "99", "none",cc);
		 region.newMunicipality("Cuneo", "CN", "99", "none");

		for(Municipality m : region.getMunicipalies()){
			System.out.println("Created municipality " + m.getName() + 
							" part of community " + m.getCommunity().map(Community::getName).orElse("<none>"));
		}
		
		School s = region.newSchool("Liceum","TOLC01", 4, "Liceum school", "statal", "none");
		region.newBranch(1234, "main", to, "C.so Duca", 10129, "none", "0110901234", "0110901234", s);
		
		System.out.println("Created school " + s.getName() + " with branches " +
							s.getBranches().stream().collect(mapping(Branch::getAddress,joining(",")))
				);
		
		
		String urlDatiPiemonte = "http://www.dati.piemonte.it/catalogodati/scarica.html?idallegato=252";

		CsvParser parser = CsvParser.createInstance();
		Map<String,Long> cont =
		parser.openNamedRowsUrl(urlDatiPiemonte)
		.collect(groupingBy( row -> row.get("Provincia"),counting()))
		;
		System.out.println(cont);

		Region r = new Region("Piemonte");
		
		r.readData(urlDatiPiemonte);
		
		System.out.println("Loaded " + r.getSchools().size() + " schools");
		
		System.out.println("Numero scuole per descrizione");
		r.countSchoolsPerDescription().forEach( (k,v) -> System.out.println(k + ":" + v));

		System.out.println("Numero sedi per comune");
		r.countBranchesPerMunicipality().forEach( (k,v) -> System.out.println(k + ":" + v));

		System.out.println("Media sedi per comune calcolato ciascuna per provincia");
		r.averageBranchesPerMunicipality().forEach( (k,v) -> System.out.println(k + ":" + v));

		System.out.println("Numero scuole per comune");
		r.countSchoolsPerMunicipality().forEach( System.out::println);

		System.out.println("Numero scuole per comunità");
		r.countSchoolsPerCommunity().forEach( System.out::println);
	}

}
