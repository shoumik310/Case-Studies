package Assignment1;

//Q. WAP to print the following patterns  
public class Question8 {
	public static void main(String[] args) {
		int n;
		
		n=4;
		System.out.println("Pattern a for n = "+n+":");
		for(int i=1;i<=n;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(i);
			}
			System.out.println("");
		}

		System.out.println(System.lineSeparator()+"Pattern b for n = "+n+":");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(n);
			}
			System.out.println("");
		}

		n=5;
		System.out.println(System.lineSeparator()+"Pattern c for n ="+n+":");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i;j++) {
				System.out.print(' ');
			}
			for(int j=0;j<=i;j++) {
				System.out.print('*');
			}
			System.out.println("");
		}
	}
}
