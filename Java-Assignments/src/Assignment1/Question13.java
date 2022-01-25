package Assignment1;

import java.util.Scanner;

//Q.Given an integer N, print all the prime numbers that lie in the range 2 to N (both inclusive).
public class Question13 {
	
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
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		int n = sc.nextInt();
		for(int i=2;i<=n;i++) {
			if(checkPrime(i)) {
				System.out.println(i);
			}
		}
		sc.close();
	}

}
