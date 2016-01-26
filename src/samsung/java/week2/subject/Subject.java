package samsung.java.week2.subject;
/** This class service information with 4 attributes : id, name, MaxRegister and CurrentRegister
 * 
 * @author Nam Tien
 * @since 25/1/2016
 * 
 */
public class Subject {
	private String subjectID;
	private String subjectName;
	private int quota;
	private int currentEnrolment;
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getQuota() {
		return quota;
	}
	public void setQuota(int quota) {
		this.quota = quota;
	}
	public int getCurrentEnrolment() {
		return currentEnrolment;
	}
	public void setCurrentEnrolment(int currentEnrolment) {
		this.currentEnrolment = currentEnrolment;
	}
	/** 
	 *  Add a student with this subject
	 */
	public void addAnEnrolment(){			
		this.currentEnrolment += 1 ;
	}
	/** 
	 *  reject a student with this subject
	 */
	public void rejectAnEnrolment(){
		this.currentEnrolment -= 1 ;
	}
	
	
	
}
