package applications;

import java.util.*;

import static java.util.Comparator.*;

public class HandleApplications {

	private Map<String, Skill> skills = new HashMap<>();
	private Map<String, Position> positions = new HashMap<>();
	private Map<String, Applicant> applicants = new HashMap<>();
	
	public void addSkills(String... names) throws ApplicationException {
		for (String s : names){
			if (skills.containsKey(s)){
				throw new ApplicationException("skill already present");
			}
			Skill ss = new Skill(s);
			skills.put(s, ss);
		}
	}
	public void addPosition(String name, String... skillNames) throws ApplicationException {
		if (positions.containsKey(name)) {
			throw new ApplicationException("position already present");
		}
		
		Collection<Skill> skillsList = new LinkedList<>();
		
		Position p = new Position (name, skillsList);
		for (String s : skillNames){
			if (!skills.containsKey(s)) {
				throw new ApplicationException("skill not present");
			}
			skillsList.add(skills.get(s));
			skills.get(s).addPosition(p);
		}
		p.setSkills(skillsList);
		positions.put(name, p);
	}
	
	public Skill getSkill(String name) {
		if (!skills.containsKey(name)) return null;
		return skills.get(name);
	}
	public Position getPosition(String name) {
		
		if (!positions.containsKey(name)) return null;
		
		return positions.get(name);
	}
	
	public void addApplicant(String name, String capabilities) throws ApplicationException {
		Applicant a;
		Map <String, Integer> applicantCapabilites = new HashMap<>();
		
		if (applicants.containsKey(name)) {
			throw new ApplicationException("applicant already present");
		}
		
		String[] splits1 = capabilities.split(",");
		for (String s : splits1){
			String[] splits2 = s.split(":");
			if (!skills.containsKey(splits2[0])) throw new ApplicationException("skill not present");
			Integer level = new Integer (splits2[1]);
			if (level < 1 || level >10) throw new ApplicationException("value not in range");
			
			applicantCapabilites.put(splits2[0], level);
		}
		
		a = new Applicant(name, applicantCapabilites);
		
		applicants.put(name, a);
	}
	public String getCapabilities(String applicantName) throws ApplicationException {
		if (! applicants.containsKey(applicantName)) throw new ApplicationException("applicant not present");
		StringBuffer sb = new StringBuffer();
		applicants.get(applicantName).getCapabilities().stream().forEach(s -> {
			sb.append(s).append(",");
		});
		sb.deleteCharAt(sb.lastIndexOf(","));
		System.out.println(sb);
		return new String(sb);
	}
	
	public void enterApplication(String applicantName, String positionName) throws ApplicationException {
		if (positions.get(positionName).getApplicants().contains(applicantName)) {
			throw new ApplicationException("applicant already applied for position");
		}
		for (Skill s : positions.get(positionName).getSkills()){
			if (!applicants.get(applicantName).getCapabilitiesMap().containsKey(s.getName())) {
				throw new ApplicationException("the applicant does not have the required skill");
			}
			positions.get(positionName).addApplicant(applicantName, applicants.get(applicantName));
		}
	}
	
	public int setWinner(String applicantName, String positionName) throws ApplicationException {
		if (!positions.get(positionName).getApplicants().contains(applicantName)){
			throw new ApplicationException("applicant did not apply");
		}
		if (positions.get(positionName).getWinner() != null){
			throw new ApplicationException("winner already present");
		}
		
		Applicant candidate = applicants.get(applicantName);
		Position requiredPosition = positions.get(positionName);
		
		int sum = 0;
		
		for (Skill s : requiredPosition.getSkills()){
			sum+= candidate.getCapabilitiesMap().get(s.getName());
		}
		if (sum < 6*requiredPosition.getSkills().size()){
			throw new ApplicationException("requirement not satisfied");
		}
		
		requiredPosition.setWinner(applicantName);
		
		return sum;
	}
	
	public SortedMap<String, Long> skill_nApplicants() {
		Map<String, Long> res = new TreeMap<>();
		int sum = 0;
		for (Skill s : skills.values()){
			for (Applicant a : applicants.values()){
				if (a.getCapabilitiesMap().containsKey(s.getName())){sum++;}
			}
			if (sum != 0) res.put(s.getName(), new Long (sum));
			sum = 0;
		}
		return (SortedMap<String, Long>) res;
	}
	public String maxPosition() {
		return positions.values().stream().max(comparing (p -> p.getApplicants().size())).get().getName();
	}
}

