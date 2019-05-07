/*Student Name: Yang Li			Data:06/20/2017           Title:Print2DArray Program
 * Description:
 * Write a program called Print2DArray.java which will ask the user to enter the number of rows
 * and the number of column for a 2-dimension array. Then the program generates an integer 
 * number in the range of (100, 10000) for each element of the array. 
 */
import java.util.Random;
import java.util.Scanner;

public class Print2DArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// input row
		System.out.print("Enter the number of rows: ");
		int row = in.nextInt();
		//input columns
		System.out.print("Enter the number of columns: ");
		int col = in.nextInt();
		System.out.println("");
		System.out.println("Student Name: Yang Li	Panther ID: 001-79-6195");
		System.out.println("");

		int[][] matrix = new int[row][col];
		
		Random ran = new Random();
		
		int count = 0;
		int count2 = 0;
		//generate random number fill out the array
		while(count < matrix.length){
			int ranNumber = ran.nextInt(9901)+100;
			
			matrix[count][count2] = ranNumber;
			count2++;
			
			if(count2 == col){
				count++;
				count2 = 0;
			}
		}
		
		int breakLine = 0;
		for(int i = 0; i < row; i++){
			// system print out the array 
			for(int j =0; j < col; j++){
				if(breakLine == col){
					System.out.print("\n");
					// %8d will make number starts at right side-this is print col
					System.out.printf("%8d",matrix[i][j]);
					//after the number = col, then break into next row
					breakLine = 0;
					
				}else{
					//print row
					System.out.printf("%8d",matrix[i][j]);
				}
				breakLine++;
			}
		}		
		int max = matrix[0][0];
		//find the max number in the matrix
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(matrix[i][j]>max){					
					max = matrix[i][j];
				}			
			}	
		}		
		int min = matrix[0][0];
		//find the min number in the matrix
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(matrix[i][j]<min){					
					min = matrix[i][j];
				}				
			}			
		}		
		double sum = 0.0;//calculate sum
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				sum = sum + matrix[i][j];				
			}			
		}	
		double averge = sum/(row*col);//calculate averge	
		System.out.println("");
		System.out.println("\nMaximum number: "+max +"  Minimum number: "+min +" Averge: "+averge);
	}

}
