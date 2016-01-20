package samsung.java.inclass;

public class Student {
	private String studentID;
	private String fullName;
	private int level;
	private int maxRegisteredCredits;
	private int currentCredits;
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMaxRegisteredCredits() {
		return maxRegisteredCredits;
	}
	public void setMaxRegisteredCredits(int maxRegisteredCredits) {
		this.maxRegisteredCredits = maxRegisteredCredits;
	}
	public int getCurrentCredits() {
		return currentCredits;
	}
	public void setCurrentCredits(int numberCredits) {
		int n = numberCredits + currentCredits;
		if ( n < getMaxRegisteredCredits())
			this.currentCredits += numberCredits;
		else 
			System.out.println(" Cannot add this subject because over MaxRegisteredCredits");
	}
	public Student(String initStudentID, String initFullName, int initLevel, int initMaxRegisteredCredits, int initCurrentCredits){
		this.studentID = initStudentID;
		this.fullName = initFullName;
		this.level = initLevel;
		this.maxRegisteredCredits = initMaxRegisteredCredits;
		this.currentCredits = initCurrentCredits;
	}
	public void enrolSubject(int numberCredits){
		/** Java doc
		 *  Add subject for this student
		 */
		if (numberCredits > 0 && numberCredits < 15)
			setCurrentCredits(numberCredits);
	}
	public void unEnrolSubject(int numberCredits){
		if (numberCredits > 0 && numberCredits < 15)
			setCurrentCredits(-numberCredits);
	}
	public void displayStudentInfo(){
		System.out.println(" Student ID : " + getStudentID());
		System.out.println(" Full name : " +getFullName());
		System.out.println(" Level : " + getLevel());
		System.out.println(" Max Registered Credits : "+ getMaxRegisteredCredits());
		System.out.println(" Current Credits : "+ getCurrentCredits());
	}
	
	public static void main(String[] args){
		Student s1 = new Student("20133924","Dao Nam Tien",3,24,17);
		s1.displayStudentInfo();
		s1.enrolSubject(3);
		s1.displayStudentInfo();
		s1.unEnrolSubject(4);
		s1.displayStudentInfo();
	}
}
