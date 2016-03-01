package samsung.java.sms;

import java.io.IOException;
import java.util.Scanner;

public class ScoreManagement {
	private Scanner input;
	private ScoreBoard[] scoreBoard = new ScoreBoard[100];
	private int n = 0;
	/**
	 * String input
	 * @return
	 */
	public String enterID() {
		input = new Scanner(System.in);
		String ID = input.nextLine();
		return ID;
	}
	/**
	 *  Number input
	 * @return
	 */
	public double enterNumber() {
		input = new Scanner(System.in);
		double number = 0.0;
		try {
			number = Double.parseDouble(input.nextLine());
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
		}
		return number;
	}
	/**
	 *  Add new subject
	 * @return 
	 */
	public Subject addNewSubject() {
		// input = new Scanner(System.in);
		System.out.println(" Enter Subject ID");
		String ID = enterID();
		System.out.println(" Enter Subject name ");
		String name = input.nextLine();

		System.out.println(" Enter point process rate ");
		double ppr = enterNumber();
		Subject subject = new Subject(ID, name, ppr);
		return subject;
	}
	/**
	 *  Case 1 :add new Score board
	 */
	public void addNewScoreBoard() {
		Subject subject = addNewSubject();
		System.out.println(" Enter semester ID ");
		String semesterID = enterID();
		System.out.println(" Enter the number of student ");
		int number = (int)enterNumber();
		n++;
		scoreBoard[n] = new ScoreBoard(subject, semesterID, number);
		
	}
	/**
	 *  Get index of score board is list
	 * @param subjectID
	 * @param semesterID
	 * @return 
	 */
	public int getIndexScoreBoard(String subjectID, String semesterID) {
		for (int i = 1; i <= n; i++)
			if (scoreBoard[i].getSubject().getSubjectID().equals(subjectID)
					&& scoreBoard[i].getSemesterID().equals(semesterID)) {
				return i;
			}
		return 0;
	}
	/** 
	 *  Case 2 : Add new score student and about student information
	 */
	public void addNewScoreStudent() {
		System.out.println(" Enter subject ID");
		String subjectID = enterID();
		System.out.println(" Enter semester ID ");
		String semesterID = enterID();
		int i = getIndexScoreBoard(subjectID, semesterID);
		if (i == 0)
			System.out.println(" Sorry. The database don't have subject "
					+ subjectID + " on semester " + semesterID);
		else {
			scoreBoard[i].addScoreInfor();
			scoreBoard[i].updateFile();
		}

		//
	}
	/**
	 *  Case 3:  Remove Score
	 */
	public void removeScore() {
		System.out.println(" Enter subject ID");
		String subjectID = enterID();
		System.out.println(" Enter semester ID ");
		String semesterID = enterID();
		int i = getIndexScoreBoard(subjectID, semesterID);
		if (i == 0)
			System.out.println(" Sorry. The database don't have subject. "
					+ subjectID + " on semester " + semesterID);
		else {
			System.out.println(" Enter Student ID");
			String studentID = enterID();
			scoreBoard[i].eraseStudentScore(studentID);
//			scoreBoard[i].updateFile();
		}

	}
	/**
	 * Case 4: Search score 
	 *  
	 */
	public void searchScore() {
		System.out.println(" Enter subject ID");
		String subjectID = enterID();
		System.out.println(" Enter semester ID ");
		String semesterID = enterID();
		int i = getIndexScoreBoard(subjectID, semesterID);
		if (i == 0)
			System.out.println(" Sorry. The database don't have subject "
					+ subjectID + " on semester " + semesterID);
		else {
			System.out.println(" Enter Student ID");
			String studentID = enterID();
			System.out.println(scoreBoard[i].getScore(studentID));
			scoreBoard[i].updateFile();
		}

	}
	/**
	 * Case 5: Display all information about score board.
	 */
	public void displayScoreBoard(){
		
	}
	public void displayNext() {
		System.out.println(" Press enter to contiune ");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input.nextLine();
	}

	public void displayMenu() {
		System.out.println(" Learning management system ");
		System.out.println(" ---------------------------------------------- ");
		System.out.println(" 1. Add a new score board ");
		System.out.println(" 2. Add score ");
		System.out.println(" 3. Remove score ");
		System.out.println(" 4. Search score ");
		System.out.println(" 5. Display score board and score report ");
		System.out.println(" Your choice (1-5, other to quit): ");
		int c = (int)enterNumber();
		switch (c) {
		case 1:
			addNewScoreBoard();
			displayNext();
			displayMenu();
			break;
		case 2:
			addNewScoreStudent();
			displayNext();
			displayMenu();
			break;
		case 3:
			removeScore();
			displayNext();
			displayMenu();
			break;
		case 4:
			searchScore();
			displayNext();
			displayMenu();
			break;
		case 5:
			displayScoreBoard();
			displayNext();
			displayMenu();
			break;
		default:
			break;

		}
	}
}
