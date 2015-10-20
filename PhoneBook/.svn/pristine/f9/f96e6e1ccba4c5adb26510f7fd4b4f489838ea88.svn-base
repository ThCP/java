package phonebook;

public class PhoneBook {
	
	//public static final PhoneBook thePhoneBook = new PhoneBook("The Phone book");
	// OR
//	public static final PhoneBook thePhoneBook;
//	static {
//		thePhoneBook = new PhoneBook("The Phone Book");
//		thePhoneBook.add("John", "SMith", "555 123456" );
//	}
	// OR BETTER
	private static PhoneBook singleton;
	public static PhoneBook getInstance(){
		if(singleton == null){
			singleton = new PhoneBook("The Phone Book");
			// ....
		}
		return singleton;
	}
	

	private String label;
	
	private final static int MAX = 100;
	private Contact[] contacts;
	private int next=0;

  /**
   * Create a new phonebook with given name
   */
  public PhoneBook(String name) {  
	  label = name;
	  contacts = new Contact[MAX];
  }

  /**
   * Return the phonebook label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Insert a new contact at the end
   */  
  public void add(String first, String last, String number){
	  Contact c = new Contact(first,last,number,this);
	  
	  contacts[next++] = c;
  }

  /**
   * Return the first contact
   */  
  public String first() {
//	  Contact f = contacts[0];
//	  return f.getFirst() + " " + f.getLast() + " " + f.getPhone();
	  return contacts[0].asString();
  }

  /**
   * Return the i-th contact (supposing that first 
   * index is 1)
   */
  public String get(int i) {
	  return contacts[i-1].asString();
  }

  /**
   * Return a string containing the list of textual 
   * representation of all contacts.
   * The elements are separated by  ", " and the
   * list starts with "("and ends with ")" 
   */
  public String toString() {
//	  String result = "(";
//	  
//	  for( int i=0; i<contacts.length; ++i){
//		  if(contacts[i] != null){
//			  if(i>0) result += ", ";
//			  result += contacts[i].asString();
//		  }
//	  }
//	  // OR
//	  boolean first=true;
//	  for( Contact c : contacts){
//		  if(c != null){
//			  if(!first) result += ", ";
//			  else first=false;
//			  result += c.asString();
//		  }
//	  }
//	  
//	  result += ")";
//	  return result;
//	  
	  
	  // OR
	  StringBuffer result = new StringBuffer("(");
	  boolean first=true;
	  for( Contact c : contacts){
		  if(c != null){
			  if(!first) //result += ", ";
				  		 result.append(", ");
			  else first=false;
			  //result += c.asString();
			  result.append(c.asString());
		  }
	  }

	  result.append(")");
	  return result.toString();
  }

  /**
   * Return the textual representation of first
   * contact containing "needle"
   */
  public String find(String needle) {
	  //TODO: to be implemented 
	  return null;
  }
  
  int positionOf(Contact c){
	  for(int i=1; i<contacts.length; ++i){
		  if( c == contacts[i] )
			  return i;
	  }
	  return -1;
  }
  
  
  
  
}
