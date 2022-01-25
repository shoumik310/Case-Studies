package Assignment1;

import java.util.Scanner;

//Q.Swap the nos in Array.
public class Question10 {
	
	static void swap(Integer[] arr, int a,int b) {
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Array size: ");
		int n = sc.nextInt();
		System.out.println("Enter array elements: ");
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		
		for(int i=0;i<n;i+=2) {
			if(i+1<n) {
				swap(arr,i,i+1);
			}
		}
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		sc.close();
	}
}
