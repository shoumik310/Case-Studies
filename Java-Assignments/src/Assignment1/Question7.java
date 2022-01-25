package Assignment1;

import java.util.Scanner;

//Q.Given a number N, print sum of all even numbers from 1 to N.
public class Question7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int input = sc.nextInt();
		int sum=input*(input+1)/2;
		System.out.println("Sum of all even numbers from 1 to "+input+" is "+sum);
		sc.close();
	}
}
