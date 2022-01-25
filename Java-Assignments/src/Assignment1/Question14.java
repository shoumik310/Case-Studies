package Assignment1;

import java.util.Scanner;

//Q.WAP to generate the reverse of a given number N. Print the corresponding reverse number.
public class Question14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		long n = sc.nextLong();
		long t = n;
		String op= "";
		while(t!=0) {
			op+=t%10;
			t/=10;
		}
		
		System.out.println(n+" reversed is "+op);
		sc.close();
	}
}
