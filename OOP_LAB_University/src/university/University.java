package university;

public class University {
	
	static final int ID_OFFSET = 10000;
	static final int COURSE_OFFSET = 10;
	static final int MAX_STUDENTS = 1000;
	static final int MAX_COURSES = 50;
	
	private String name;
	private Rector rector;
	private int ID = ID_OFFSET;
	private int courseID = COURSE_OFFSET;
	private Student [] enrolled = new Student [MAX_STUDENTS];
	private Course [] courses = new Course[MAX_COURSES];
	
	public University(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setRector(String first, String last){
		rector = new Rector(first,last);
	}
	
	public String getRector(){
		return rector.toString();
	}
	
	public int enroll(String first, String last){
		enrolled[ID-ID_OFFSET] = new Student(first, last, ID); /* I subtract ID_OFFSET because the id of the 
																 student is used as an index for the array */
		return ID++;
	}
	
	/**
	 * This function receives an id as input and returns info about the selected student
	 * 
	 * @param id
	 * @return information about enrolled student
	 */
	
	public String student(int id){
		return enrolled[id-ID_OFFSET].toString();
	}
	
	public int activate(String title, String teacher){
		courses[courseID-COURSE_OFFSET] = new Course (title, teacher, courseID);
		return courseID++;
	}
	
	public String course(int code){
		return courses[code].toString();
	}
	
	/**
	 * Receives as input the ID of a student and of a course and registers in the respective
	 * array the corresponding reciprocal values.
	 * 
	 * @param studentID
	 * @param courseCode
	 */
	
	public void register(int studentID, int courseCode){
		enrolled[studentID-ID_OFFSET].setCourse(courseCode);
		courses[courseCode-COURSE_OFFSET].setStudent(studentID);
	}
	
	/**
	 * 
	 * 
	 * @param courseCode
	 * @return a string which contains all the students who attend the course
	 */
	
	public String listAttendees(int courseCode){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < courses[courseCode-COURSE_OFFSET].getAttending(); i++){
			sb.append(enrolled[courses[courseCode-COURSE_OFFSET].getStudent(i)-ID_OFFSET].toString() + "\n");
			
		}
		
		String s = new String(sb);
		return s;
	}

	public String studyPlan(int studentID){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < enrolled[studentID-ID_OFFSET].getAttending(); i++){
			sb.append(courses[enrolled[studentID-ID_OFFSET].getCourse(i)-COURSE_OFFSET].toString() + "\n");
		}
		
		String s = new String(sb);
		return s;	
	}
}
