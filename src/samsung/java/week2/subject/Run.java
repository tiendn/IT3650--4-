package samsung.java.week2.subject;
import java.io.IOException;
import java.util.Scanner;

import samsung.java.week2.subject.Subject;
public class Run {
	public final static int MAX_SUB = 50 ;// Max list subject
	/**
	 *  Static Sub type of Subject class
	 */
	public static Subject[] Sub = new Subject[MAX_SUB]; // List Subject , begin with number 1
	public static int n = -1; // The number of Subject in list - 1
	
	/**
	 * Show Menu desktop
	 */
	public static void showMenu(){
		System.out.println(" Subject Management System ");
		System.out.println(" ----------------------------------------------- " );
		System.out.println(" 1. Append new Subject ");
		System.out.println(" 2. Update Subject ");
		System.out.println(" 3. Display the information of Subject ");
		System.out.println(" 4. Enrol new student ");
		System.out.println(" 5. Unenrol student ");
		System.out.println(" 6. Show all Subject ");
		System.out.println(" Your choice (1-5, other to quit) :");
		Scanner input1 = new Scanner(System.in);
		int c = input1.nextInt();	
		switch(c){
		case 1: 
			appendSubject();	
			showEnd(input1);
			showMenu();
			break;
		case 2: 	
			updateSubject();
			showEnd(input1);
			showMenu();
			break;
		case 3 :
			displaySubjectInfo();
			showEnd(input1);
			showMenu();
			break;
		case 4:
			enrolStudent();
			showEnd(input1);
			showMenu();
			break;
		case 5:	
			unEnrolStudent();
			showEnd(input1);
			showMenu();
			break;
		case 6: 
			showAllSubject();	
			showEnd(input1);
			showMenu();
			break;
			// To be continued ...	
		default : break;
		}
	}
	/**
	 *  Append new Subject
	 */
	public static void appendSubject(){	
		String id = enterID();
		if (n == -1 ) {
			n = 1;
			Sub[n] = new Subject();
			Sub[n].setSubjectID(id);
		}	
		else if ( n < MAX_SUB ){	
			if (isExist(id)){
				System.out.println(" This id have existed.");				
			}
			else {
				n++;
				Sub[n] = new Subject();
				Sub[n].setSubjectID(id);
			}	
		}
		else if ( n == MAX_SUB ){
			System.out.println(" The list subject is full. ");
		}
		
	}
	/**
	 * Update id, or name or the current, max register 
	 */
	public static void updateSubject(){	
		String id = enterID();
		int index = getIndex(id);
		if (isExist(id))
		{
			showMenuUpdate(index);
		}
		else {
			System.out.println(" This Subject id is not on the list ");
		}	
	}
	/**
	 *  Show all information of this Subject
	 */
	public static void displaySubjectInfo(){	
		String id = enterID();
		if (isExist(id)){
			int index = getIndex(id);
			System.out.println(" Subject id : " + Sub[index].getSubjectID());
			System.out.println(" Subject name : " + Sub[index].getSubjectName());
			System.out.println(" Subject quota : " + Sub[index].getQuota());
			System.out.println(" Current Enrolment is : " + Sub[index].getCurrentEnrolment());
		}
		else System.out.println(" This id is not on list Subject");
		
	}
	/**
	 * Register a student with this Subject
	 */
	public static void enrolStudent(){	
		String id = enterID();
		if (isExist(id)){
			int index = getIndex(id);
			if ( Sub[index].getCurrentEnrolment() < Sub[index].getQuota())
				Sub[index].addAnEnrolment();
			else System.out.println(" Can not add more students with this Subject because current enrolemnt is MAX");
		}
		else System.out.println(" This id is not on list Subject");
	}
	/**
	 *  Unregister a student with this Subject
	 */
	public static void unEnrolStudent(){	
		String id = enterID();
		if (isExist(id)){
			int index = getIndex(id);
			if ( Sub[index].getCurrentEnrolment() > 0 )
				Sub[index].rejectAnEnrolment();
			else System.out.println(" Can not reject more students with this Subject and Current Enrolment is zero ");
		}
		else System.out.println(" This id is not on list Subject");
	}
	
	/** Check this id have existed in list Subject ?
	 *  @param id : String input SubjectID 
	 */
	public static boolean isExist(String id){
		if (getIndex(id) != -1) 
			return true;		
		return false;
	}
	/** Get index of element have id as known as id input 
	 * @return 
	 * index if this id is on the list Subject 
	 * @see
	 * -1 if if this id isn't on the list Subject
	 */
	public static int getIndex(String id){
		for ( int i = 1 ; i <= n; i++ )
			if (Sub[i].getSubjectID().equals(id)) {
				return i;
			}	
		return -1;
	}
	/**
	 *  Enter String id from keyboard
	 */
	public static String enterID(){
		Scanner input2 = new Scanner(System.in);
		System.out.println(" Enter Subject id : ");
		String id =  input2.nextLine();
		return id;
	}
	/** 
	 *  Show continue sentence and continue this program
	 */
	public static void showEnd(Scanner input){	
		System.out.println("Press Enter to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		input.nextLine();
	}
	/** Show Menu Update and do it. This method is called by method updateSubject().
	 *  
	 * @param index : the position of this id on list Subject 
	 */
	public static void showMenuUpdate(int index){	
		System.out.println(" Update Subject Information ");
		System.out.println(" ----------------------------------------------- ");
		System.out.println(" 1. Change SubjectID ");
		System.out.println(" 2. Change Subject Name ");
		System.out.println(" 3. Change Quota ");
		System.out.println(" 4. Change Current Enrolment ");
		System.out.println(" Your choice (1-4, other number to back menu) :");
		Scanner input3 = new Scanner(System.in);
		System.out.println(" Enter you choice : ");
		int c = input3.nextInt();
		switch(c){
			case 1: 
				Scanner input4 = new Scanner(System.in);
				System.out.println(" Enter new Subject ID ");
				String id = input4.nextLine();
				if (!isExist(id)){
					Sub[index].setSubjectID(id);
				}	
				else 
					System.out.println(" Update failed. This id is on the list");
				showMenuUpdate(index);
				break;
			case 2:
			    input4 = new Scanner(System.in);
				System.out.println(" Enter new Subject Name ");
				String name = input4.nextLine();
				Sub[index].setSubjectName(name);
				showMenuUpdate(index);
				break;
			case 3:
				input3 = new Scanner(System.in);
				System.out.println(" Enter new Quota: ");
				int quota = input3.nextInt();
				Sub[index].setQuota(quota);
				showMenuUpdate(index);
				break;
			case 4:
				input3 = new Scanner(System.in);
				System.out.println(" Enter Current Enrolment: ");
				int current = input3.nextInt();
				Sub[index].setCurrentEnrolment(current);
				showMenuUpdate(index);
				break;
			default : break;
		}
	}
	public static void showAllSubject(){
		for (int i = 1 ; i <= n ; i++ )
			System.out.println(Sub[i].getSubjectID());
	}
	/** 
	 *  Main display program
	 */
	public static void main(String[] args) {
		showMenu();
	}
}
