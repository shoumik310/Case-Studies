package Assignment1;

import java.util.Scanner;

//Q.WAP to swap the values of 2 nos.(Take input from user)

public class Question2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number 1: ");
		int num1 = sc.nextInt();
		System.out.print("Enter number 2: ");
		int num2 = sc.nextInt();

		num1+=num2;
		num2=num1-num2;
		num1-=num2;
		
		System.out.println("Swapped num1="+num1+" and num2="+num2);
		sc.close();
	}

}
