package samsung.java.hw1;
/// Not done.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Problem4 {
	private static Scanner input;
	private static String choose;
	private static double x;
	private static void print() {
		System.out.println("Function: f(x) = sin(2x) + x²");
		System.out.println("1. Calculate f(x) at x");
		System.out.println("2. Calculate f'(x) at x");
		System.out.println("3. Solve equation f(x) = 0 at [a,b]");
		System.out.println("Press another key to quit");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			choose = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		makeChoose(choose);
	}
	private static double f(double x){
		return Math.sin(2*x) + x*x;
//		System.out.println(" f(x) = " + (Math.sin(2*x) + x*x)); 
	}
	private static void df(double x){
		double x1 = f(x + Math.pow(10, -6)); // Calculate f(x+ delta(x)) 
		double x2 = f(x);
		double y1 = Math.pow(10, -6);
		System.out.println(" f'(x) = "+ (x1/y1 - x2/y1) ); 
	}
	private static void f( double a, double b){
		double c = 0d;
////		double x1 = 0;
		if (f(a)*f(b)>0) System.out.println(" This equation have zero or more results");
		do {
			c = (a+b)/2;
			if (f(a)*f(c) < 0 ) b = c;  
			else if (f(a)*f(c)>0) a =c ;
//			else {
//				System.out.println(c + " ");
//				
//			}
		}
//		do{
//			c = (a+b)/2.0;
//			if (f(c)==0) {
//				System.out.println(" x = "+ c);
//				break;
//			}
//			else{
//				if (f(a)*f(b)<0) b=c;
//				else if (f(a)*f(b)<0) a=c;
//			}
//		}
		while ( (Math.abs(a-b))/2 > Math.pow(10, -9));
//		if (c != 0) System.out.println(" No result ");
		System.out.println(c);

	}
	private static void makeChoose(String choose) {
		switch(choose){
		case "1" :  // If choose 1 
			System.out.println(" Enter x : ");
			input = new Scanner(System.in); //
			x = input.nextDouble();	
			f(x);
			System.out.println(" f(x) = " + f(x));
			print();
			break;
		case "2": 
			System.out.println(" Enter x : ");
			input = new Scanner(System.in);
			x = input.nextDouble();
			df(x);
			print();
			break;
		case "3":
//			System.out.println(" Enter x : ");
			input = new Scanner(System.in);
//			x = input.nextDouble();
			System.out.println(" Enter a and b : ");
			double a = input.nextDouble();
			double b = input.nextDouble();
			f(a,b);
			print();
			break;
		default: break;	
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print();
		
			
		
		
		
	}

}
