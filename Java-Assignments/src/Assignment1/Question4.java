package Assignment1;

import java.util.Scanner;

//Q.WAP to find whether the character entered by user is a vowel or not.(solve by using if..else and switch case)

public class Question4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter charachter: ");
		char input = sc.next().toUpperCase().charAt(0);
		switch (input) {
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U':
			System.out.println(input+" is a vowel.");
			break;
		default:
			System.out.println(input+" is not a vowel.");
		}

		sc.close();
	}
}
