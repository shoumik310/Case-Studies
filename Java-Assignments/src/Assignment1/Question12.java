package Assignment1;

import java.util.Scanner;


//Q.WAP to check weather the no entered by user is prime or not.
public class Question12 {

	
	static Boolean checkPrime(int n){
		if(n<=1) return false;
		if(n<=3) return true;
		
		if(n%2==0 || n%3==0) return false;
		
		for(int i=5;i*i<n;i+=6) {
			if(n%i==0||n%(i+2)==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int x;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		x = sc.nextInt();
		if(checkPrime(x)) {
			System.out.println(x +" is a Prime");
		}
		else {
			System.out.println(x +" is not a Prime");
		}
		sc.close();
	}
}
