package Assignment1;

import java.util.Scanner;

//Q.WAP to find weather the no entered by user is even or odd.
public class Question1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int input = sc.nextInt();
		if(input%2==0) {
			System.out.println(input+" is even.");
		}else {
			System.out.println(input+" is odd.");
		}
		sc.close();
	}

}
