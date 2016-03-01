package samsung.java.sms;

public class StudentScore {
	private String lastName;
	private String midName;
	private String firstName;
	private String studentID;
	private double pointProcess;
	private double finalPoint;
	public StudentScore(String lastName, String midName, String firstName,
			String studentID, double pointProcess, double finalPoint) {
		setLastName(lastName);
		setMidName(midName);
		setFirstName(firstName);
		setStudentID(studentID);
		setPointProcess(pointProcess);
		setFinalPoint(finalPoint);
		
	}
	protected String getLastName() {
		return lastName;
	}
	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}
	protected String getMidName() {
		return midName;
	}
	protected void setMidName(String midName) {
		this.midName = midName;
	}
	protected String getFirstName() {
		return firstName;
	}
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	protected String getStudentID() {
		return studentID;
	}
	protected void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	protected double getPointProcess() {
		return pointProcess;
	}
	protected void setPointProcess(double pointProcess) {
		if ( pointProcess > 0 )
			this.pointProcess = pointProcess;
	}
	protected double getFinalPoint() {
		return finalPoint;
	}
	protected void setFinalPoint(double finalPoint) {
		if ( finalPoint > 0 )
			this.finalPoint = finalPoint;
	}
	public String getMark(double pointProcessRate, double finalPointRate ){
		double score = (pointProcessRate*getPointProcess() + finalPointRate*getFinalPoint())/100;
		if (score < 4.0 ) return "F";
		else if (score < 5.5) return "D";
		else if (score < 7.0) return "C";
		else if (score < 8.4) return "B";
		else return "A";
	}
	public String getMarkLine(double pointProcessRate, double finalPointRate ){
		String s="";
		s = " S|" + getStudentID()+"|"+getLastName()+" "+getMidName();
		s = s +"  |"+getFirstName()+ " | "+getPointProcess()+ " | "+getFinalPoint()+" | " + getMark(pointProcessRate,finalPointRate );
		return s;
	}
	public void changeScore(double pointProcess, double finalPoint){
		setPointProcess(pointProcess);
		setFinalPoint(finalPoint);
	}
}
