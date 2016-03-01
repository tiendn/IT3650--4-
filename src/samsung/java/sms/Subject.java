package samsung.java.sms;

public class Subject {
	private String subjectID;
	private String subjectName;
	private double pointProcessRate;
	private double finalPointRate;
	/**
	 * Subject constructor 
	 * @param ID
	 * @param name
	 * @param pointProcessRate
	 */
	public Subject(String ID, String name, double pointProcessRate){
		setSubjectID(ID);
		setSubjectName(name);
		setPointProcessRate(pointProcessRate);
		setFinalPointRate();
	}
	protected String getSubjectID() {
		return subjectID;
	}
	protected void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	protected String getSubjectName() {
		return subjectName;
	}
	protected void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	protected double getPointProcessRate() {
		return pointProcessRate;
	}
	protected void setPointProcessRate(double pointProcessRate) {
		if (pointProcessRate <= 50)
			this.pointProcessRate = pointProcessRate;
	}
	protected double getFinalPointRate() {
		return finalPointRate;
	}
	/**
	 * Set final point rate in 100 level.
	 */
	protected void setFinalPointRate() {
		this.finalPointRate = 100 - getPointProcessRate();
	}
	
}
