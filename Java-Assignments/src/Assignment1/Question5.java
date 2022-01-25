package Assignment1;

//Q.WAP to print even nos from 1-50 using while loop.
public class Question5 {
	public static void main(String[] args) {
		int i=1;
		while(i++<=50) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
	}
}
