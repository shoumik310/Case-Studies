package Assignment1;

//Q.WAP to print odd nos from 50-100 using do while loop.
public class Question6 {
	public static void main(String[] args) {
		int i=50;
		do{
			if(i%2!=0) {
				System.out.println(i);
			}
		}while(++i<=100);
	}
}
