package samsung.java.hw1;

import java.util.Scanner;

// Enter list name and search name in list
public class Problem9 {
	private static Scanner input;
	private static String[] s;
	private static boolean searchName(String s1){
		// search name in list
		boolean rs = false;
		for ( int i = 1 ; i <= s.length; i++ ) // What happened ??? "Dead code???"
			if(s1.equalsIgnoreCase(s[i]) ){
				rs=true;
				break;
			}
		return rs;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new Scanner(System.in);
		int n;
		// enter length of list
		do{
			System.out.println(" Enter length of list name ");
			n = input.nextInt();
			if ( n <= 0) continue;
			else
				s = new String[n+1]; 
		} 
		while ( n <= 0 );
		// enter list
		System.out.println(" Enter list name ");
		for ( int i = 0 ; i <= n; i++){
			s[i] = new String(input.nextLine());
			s[i]=s[i].toUpperCase();
		}		
		// Show list name		
		System.out.println(" List name :");
		for ( int i = 1 ; i <= n; i++)
			System.out.println(s[i]+ " ");
		System.out.println(" Enter a student name ");
		String s1 = input.nextLine();
		
		// Search a name is on database list
		if (searchName(s1)) System.out.println("Yes");
		else System.out.println("No");
	}

}
