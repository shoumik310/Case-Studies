package Assignment1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//WAP to find the greatest between the 3 nos and display the output. (Take input from user)

public class Question3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer[] nums = new Integer[3];
		for(int i=0;i<3;i++) {
		System.out.print("Enter number "+(i+1)+": ");
		nums[i] = sc.nextInt();
		}
		System.out.println("Greatest value is "+Collections.max(Arrays.asList(nums)));
		sc.close();
	}
}
