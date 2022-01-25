package Assignment1;

import java.util.Scanner;

//Q.WAP to calculate and display the factorial of a no entered by user.
public class Question11 {

	static long factorial(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return n;
		}
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int n = sc.nextInt();
		System.out.println("Factorial of " + n + " = " + factorial(n));
		sc.close();
	}
}
