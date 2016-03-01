package samsung.java.sms;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ScoreBoard {
	private Subject subject;
	private StudentScore[] studentScoreList = new StudentScore[100];
	private int n = 0;
	private String semesterID;
	private int numberStudent;
	private static String path = ""; // create a empty path for creating a new file
	/** Constructor create a new Score Board 
	 * 
	 * @param subject
	 * @param semesterID
	 * @param numberStudent
	 */
	public ScoreBoard(Subject subject, String semesterID, int numberStudent) {
		setSubject(subject);
		setSemesterID(semesterID);
		path = "src/samsung/java/database/" + subject.getSubjectID()
				+ "_" + semesterID + ".txt";
		try {
			File file = new File(path);
			if (file.createNewFile()) {
				System.out.println("File is created!");
				setNumberStudent(numberStudent);
				writeFile();
			} else {
				 System.out.println("File already exists.");
				 readFile();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * 
	 * @return Subject 
	 */
	public Subject getSubject() {
		return subject;
	}
	/** Setter: Set subject for ScoreBoard
	 * 
	 * @param subject
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	/** Get Semester ID
	 * 
	 * @return
	 */
	public String getSemesterID() {
		return semesterID;
	}
	/**
	 *  Set Semester ID
	 * @param semesterID
	 */
	public void setSemesterID(String semesterID) {
		this.semesterID = semesterID;
	}
	/**  Get number of students .
	 * 
	 * @return
	 */
	public int getNumberStudent() {
		return numberStudent;
	}
	/** Set number of student
	 * 
	 * @param numberStudent
	 */
	public void setNumberStudent(int numberStudent) {
		this.numberStudent = numberStudent;
	}
	/** Get index of student on list Score Board.
	 * 
	 * @param studentID
	 * @return
	 */
	public int getIndexStudent(String studentID) {
		for (int i = 1 ; i <= n; i++ )
			if (studentScoreList[i].getStudentID().equals(studentID)) 
				return i;
		return 0;

	}
	/**
	 *  Enter String id
	 * @return
	 */
	public String enterID(){
		Scanner input = new Scanner(System.in);
		String ID = input.nextLine();
		return ID;
	}
	public double enterNumber(){
		Scanner input = new Scanner(System.in);
		double number = 0;
		try {		
			number = Integer.parseInt(input.nextLine());
		}
		catch (NumberFormatException nfe){
			System.out.println(nfe.getMessage());
		}
		return number;
	}
	/** Read File ....
	 * 
	 */
	private void readFile(){
		try(FileReader fr = new FileReader(path)){
			BufferedReader br = new BufferedReader(fr);	
			String line ="";
			StringTokenizer readData;
			// subject ID
			line = br.readLine();
			// subject Name
			line = br.readLine();
			readData = new StringTokenizer(line,"|");
			readData.nextToken();
			String subjectName = readData.nextToken();
			getSubject().setSubjectName(subjectName);
			// subject rate.
			line = br.readLine();
			readData = new StringTokenizer(line,"|");
			readData.nextToken();
			getSubject().setPointProcessRate(Double.parseDouble(readData.nextToken()));
			// semester
			line = br.readLine();
			// number of student
			line = br.readLine();
			readData = new StringTokenizer(line,"|");
			readData.nextToken();
			setNumberStudent(Integer.parseInt(readData.nextToken()));
			while ( (line=br.readLine()) != null){
				readData = new StringTokenizer(line,"|");
				readData.nextToken();
				String studentID = readData.nextToken();
				String studentLastName = readData.nextToken("| ");
				String studentMidName = readData.nextToken("| ");
				String studentFirstName = readData.nextToken();
				double pointProcess = Double.parseDouble(readData.nextToken(" | "));
				double finalPoint = Double.parseDouble(readData.nextToken(" | "));			
				n++;
				studentScoreList[n] = new StudentScore(studentLastName, studentMidName,
						studentFirstName, studentID, pointProcess, finalPoint);
			}
			br.close();
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	/** Write File
	 * 
	 * @param subject
	 * @param semesterID
	 * @param numberStudent
	 */
	private void writeFile(){
		try (FileWriter wr = new FileWriter(path)) {
			BufferedWriter bw = new BufferedWriter(wr);	
			bw.write("SubjectID|" + getSubject().getSubjectID());
			bw.newLine();
			bw.write("Subject|"+getSubject().getSubjectName());
			bw.newLine();
			bw.write("F|"+getSubject().getPointProcessRate() + "|" + getSubject().getFinalPointRate());
			bw.newLine();
			bw.write("Semester|"+ getSemesterID());
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * 
	 */
	public void updateFile(){
		writeFile();
		try(FileWriter wr = new FileWriter(path)){
			BufferedWriter bw = new BufferedWriter(wr);
			bw.write("StudentCount|"+ getNumberStudent());
			bw.newLine();
			for ( int i = 1 ; i <= n ; i++ ){
				bw.write(studentScoreList[i].getMarkLine(getSubject().getPointProcessRate(),getSubject().getFinalPointRate()));
				bw.newLine();
			}
			bw.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	} 
	public int addScoreInfor(){
		System.out.println(" Enter Student ID");
		String studentID = enterID();
		int j = getIndexStudent(studentID);
		if ( j != 0 ) {
			// if have student on list
			System.out.println(" This student is existed on list");
			System.out.println(" Do you want change student data? ");
			System.out.println(" 1. Yes");
			System.out.println(" 2. No ");
			int c = (int)enterNumber();
			if ( c == 2) return 0; // Nothing to do
			else if ( c == 1){
				// Change values
				System.out.println(" Enter point process");
				double pointProcess = enterNumber();
				System.out.println(" Enter final point");
				double finalPoint = enterNumber();
				studentScoreList[n].changeScore(pointProcess, finalPoint);
			}
		}		
		else {
			// If student is not on list
			System.out.println(" The list not have this id, append new student");
			System.out.println(" Enter Student last name");
			String lastName = enterID();	
			System.out.println(" Enter Student middle name");
			String midName = enterID();	
			System.out.println(" Enter Student first name");
			String firstName = enterID();	
			System.out.println(" Enter point process");
			double pointProcess = enterNumber();
			System.out.println(" Enter final point");
			double finalPoint = enterNumber();	
			
			n++;
			studentScoreList[n] = new StudentScore(lastName, midName, firstName, studentID, pointProcess, finalPoint);
		}
		return 1;	
	}
	/** Erase score of a student on list
	 *  
	 * @param studentID
	 */
	public void eraseStudentScore(String studentID){
		int i = getIndexStudent(studentID);
		if ( i == 0 ) System.out.println(" Sorry. This student is not on list");
		else {
			studentScoreList[i].changeScore(0.0,0.0);
			updateFile();
		}
	}
	/** Get score of student
	 * 
	 * @param studentID
	 * @return
	 */
	public String getScore(String studentID){
		int i = getIndexStudent(studentID);
		if ( i == 0 ) System.out.println(" Sorry. This student is not on list");
		else return studentScoreList[i].getMarkLine(getSubject().getPointProcessRate(),getSubject().getFinalPointRate() );
		return null;
	}
}
