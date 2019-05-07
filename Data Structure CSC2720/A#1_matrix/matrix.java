
package matrix;
/*Purpose:
 * You program should prompt the user for the dimensions of the two matrices,then check for compatibility. 
 * you could prompt for ONE dimension and build two square matrices(minimum dimension of matrix must be 25).
 * If the above is not met, prompt the user for new and compatible dimensions. Generate random integer numbers
 * ranging from 1 to 30 to fill both matrices.display these two matrices on the screen. Multiply the two 
 * matrices and display the result on the screen.Insert a clock to see how long it would take to multiply these two
 * matrices and display the time(with a message to this effect). Now add the two matrices and display the result on the screen. */

/*Class:2720 							Data Structures	
CRN:86473
Student Name: Yang Li		
Program Name: Matrix					Date:09/01/2017	
*/
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class matrix {
	
	public static void main(String[] args) {
	//start with a do while loop because we need to ask user if the user wants to repeat the program or not. 
	String Word;
	do{
		Scanner in = new Scanner(System.in);
		int dimension;		
		//ask user to enter one dimension to build two square matrices. 
		do{
			System.out.println("\nMinimum dimension of matrix must be 25.\n");
			System.out.print("Enter the dimension to build two square matrix: ");
			dimension = in.nextInt();
		// the do while loop will repeat if user enter number less than 25.
		}while(dimension<25);
		
		System.out.println("");
		
		//generate random integer to fill both matrices.
		Random rand= new Random();		
		// create two 2d array then use random number fill both 2d array.
		int[][] matrix1 = new int[dimension][dimension];
		int[][] matrix2 = new int[dimension][dimension];
		
		System.out.println("");
		//use random number to fill the first matrix.
		System.out.println("This is the first matrix: \n");
		// use count1 and count2 to make the matrix
		int count1=0;
		int count2=0;
		
		while(count1<matrix1.length){
			int ranNumber= rand.nextInt(30)+1;
			
			matrix1[count1][count2]=ranNumber;
			count2++;
			
			if(count2==dimension){
				count1++;
				count2=0;
			}
		}
		//print out first matrix
		int breakLine=0;
		
		for(int i=0; i<dimension;i++){
			for(int j=0; j<dimension;j++){
				if(breakLine==dimension){
					System.out.print("\n");
					System.out.printf("%4d", matrix1[i][j]);
					breakLine=0;
				}
				else{
					System.out.printf("%4d",matrix1[i][j]);
				}
				breakLine++;
			}
		}		
		System.out.println("");
		
		//use random number to fill the second matrix
		System.out.println("\n\nThis is the second matrix: ");
				
		int count21=0;
		int count22=0;		
		
		while(count21<matrix2.length){
			int ranNumber= rand.nextInt(30)+1;
			
			matrix2[count21][count22]=ranNumber;
			count22++;
			
			if(count22==dimension){
				count21++;
				count22=0;
			}
		}
	
		//print out second matrix
		for(int i=0; i<dimension;i++){
			for(int j=0; j<dimension;j++){
				if(breakLine==dimension){
					System.out.print("\n");
					System.out.printf("%4d", matrix2[i][j]);
					breakLine=0;
				}
				else{
					System.out.printf("%4d",matrix2[i][j]);
				}
				breakLine++;
			}
		}
		
		//Multiply the two matrices and display the result with System operating time.		
		System.out.println("");
		System.out.println("");
		System.out.println("Multiply the two matrices: \n");
		//operating systems measure time in units of tens of milliseconds.
		long start = System.currentTimeMillis();
		
		int [][] multi=new int[dimension][dimension];
		
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				for(int k=0;k<dimension;k++){
					multi[i][j]+=matrix1[i][k]*matrix2[k][j];
				}
			}
		}
		//display multiplication result
				
		for(int i=0; i<dimension;i++){
			for(int j=0; j<dimension;j++){
				if(breakLine==dimension){
					System.out.print("\n");
					System.out.printf("%7d", multi[i][j]);
					breakLine=0;
				}
				else{
					System.out.printf("%7d",multi[i][j]);
				}
				breakLine++;
			}
		}		
		
		long end = System.currentTimeMillis();
		int timer=(int) (end-start);
		//display operating systems measure time for Multiplication.
		System.out.println("\n\nThe operating system time for multiply two matrices is: "+timer+" in milliseconds");
		
		System.out.println("");
		System.out.println("Add the two matrices: \n");
		
		//use matrix1 add matrix2
		//operating systems measure time in units of tens of milliseconds.
		long startAddition = System.currentTimeMillis();
		int [][]Addition=new int [dimension][dimension];
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				Addition[i][j]=matrix1[i][j]+matrix2[i][j];
			}
		}
		//display addition matrix
		for(int i=0; i<dimension;i++){
			for(int j=0; j<dimension;j++){
				if(breakLine==dimension){
					System.out.print("\n");
					System.out.printf("%6d", Addition[i][j]);
					breakLine=0;
				}
				else{
					System.out.printf("%6d",Addition[i][j]);
				}
				breakLine++;
			}
		}
		
		long endAddition = System.currentTimeMillis();
		int timerAddition=(int) (endAddition-startAddition);
		//display operating systems measure time for matrix addition.
		System.out.println("\n\nThe operating system time for Add the two matrices is: "+timerAddition+" in milliseconds");
		System.out.println("");
		System.out.println("If you want to repeat this program Enter \"yes\" or Enter \"no \"to end this program.");
		//ask user if the user wants to repeat the program or not. if the user wants to repeat the program enter "yes" if not enter "no".
		Word=in.next();
		
		}while(Word.equals("yes"));
	}
}
