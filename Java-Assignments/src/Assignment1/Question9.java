package Assignment1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//Q.Reverse an Array.
public class Question9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Array size: ");
		int n = sc.nextInt();
		System.out.println("Enter array elements: ");
		Integer[] arr = new Integer[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		Collections.reverse(Arrays.asList(arr));
		for(int i:arr) {
			System.out.print(i+" ");
		}
		sc.close();
	}
}
