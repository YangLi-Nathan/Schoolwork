
/*Student Name: Yang Li			Data:06/14/2017
 *
 * Write a program called Swap.java, in the main method, the program first asks user to
 * input a number and call a method swapDigitPairs to swap the number as shown in the following figure*/
import java.lang.reflect.Array;
import java.util.Scanner;

public class Swap {

	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input a number to be swapped: ");
		num = Integer.parseInt(sc.nextLine());
		//print this 
		swapDigitPairs(num);
		System.out.println(swapDigitPairs(num));
		System.out.print("Please input a string to be swapped: ");
		String swapPairs = sc.nextLine();
		//print this 
		swapLetterPairs(swapPairs);
		
		System.out.println(swapLetterPairs(swapPairs));	
	}	
	private static String swapLetterPairs(String str) {
		
		char[] input = str.toCharArray();
		int even=0;
		int odd=1;
		//odd
		if(input.length%2==1){
			for(int i=odd;i<input.length;i+=2){
				char temp=input[i];
				input[i]=input[i+1];
				input[i+1]=temp;
			}	
		}		
		//even
		if(input.length%2==0){
			for(int i=even;i<input.length;i+=2){
				char temp=input[i];
				input[i]=input[i+1];
				input[i+1]=temp;
			}
		}
		str = new String(input);
		return str;
		//return the string			
	}	
	private static int swapDigitPairs(int n) {
		int c=0;
		int word=0; 
		int i;
		int j;
		while(n>=10){
			
		i=n%10;
		n/=10;
		
		j=n%10;
		n/=10; 
		
		word+=j*Math.pow(10,c);
		c++;
		word+=i*Math.pow(10,c);
		c++;
		}
		if (n!=0){
		word+=n*Math.pow(10,c);
		}
		return word;
		}
}
