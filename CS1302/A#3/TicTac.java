/*Student Name: Yang Li					Data:06/28/2017				Program Name:Tic-Tac-Toe
 * Description:
 * Write a program of a game of Tic-Tac-Toe that represents the board by using of 2D Array.
-	Play the game 1 time for 2 players;
-	Show who the winner is (Player 1, Player 2, or Draw)
-	Name the program as TicTac.java, a screen output will be similar to the following.
 */


import java.util.Scanner;

public class TicTac {

	public static int rowIndex;
	public static int colIndex;

	
	public static void main(String[] args) {
		
		
		String[][] ticTac = new String[3][3];
		Scanner inputRow = new Scanner(System.in);
		Scanner inputCol = new Scanner(System.in);
		
		System.out.println("-------");
		for(int i= 0; i < ticTac.length; i++){
			for(int j = 0; j < ticTac.length; j++){
				ticTac[i][j] = "-";
				
				System.out.print("|"+ticTac[i][j]);
			}
			
			System.out.println("|");
			
			System.out.println("-------");
		}

		boolean match = false;
		int count = 0;
		int c=0;
		
		while(match != true){
			
			if(count%2 == 0){
				System.out.print("Enter the row index: ");
				rowIndex = inputRow.nextInt();
				System.out.print("Enter the column index: ");
				colIndex = inputCol.nextInt();
				System.out.println("-------");
				for(int i= 0; i < ticTac.length; i++){
					for(int j = 0; j < ticTac.length; j++){
						ticTac[rowIndex][colIndex] = "x";
						System.out.print("|"+ticTac[i][j]);
					}
					
					System.out.println("|");
					System.out.println("-------");
					
				}
				
				
	//----------------------------------------Player X
				//Check Row
				if(ticTac[0][0].equals("x") && ticTac[0][1].equals("x") && ticTac[0][2].equals("x")){
					System.out.println("Player 1 \"x\" won!");
					break;
				}
				
				else if(ticTac[1][0].equals("x") && ticTac[1][1].equals("x") && ticTac[1][2].equals("x")){
					System.out.println("Player 1 \"x\" won!");
					break;
				}
				
				else if(ticTac[2][0].equals("x") && ticTac[2][1].equals("x") && ticTac[2][2].equals("x")){
					System.out.println("Player 1 \"x\" won!");
					break;
				}	
				//Check Column
				else if(ticTac[0][0].equals("x") && ticTac[1][0].equals("x") && ticTac[2][0].equals("x")){
					System.out.println("Player 1 \"X\" won!");
					break;
				}	
				else if(ticTac[0][1].equals("x") && ticTac[1][1].equals("x") && ticTac[2][1].equals("x")){
					System.out.println("Player 1 \"x\" won!");
					break;
				}
				else if(ticTac[0][2].equals("x")  && ticTac[1][2].equals("x") && ticTac[2][2].equals("x")){
					System.out.println("Player 1 \"x\" won!");
					break;
				}
				//Cross
				else if (ticTac[0][0].equals("x") && ticTac[1][1].equals("x") && ticTac[2][2].equals("x")){
					System.out.println("Player 1 \"x\" won!");
					break;
				}
				else if(ticTac[0][2].equals("x") && ticTac[1][1].equals("x") && ticTac[2][0].equals("x")) {
					System.out.println("Player 1 \"x\" won!");
					break;
				}else{
					
				}
				count++;
				c=c+1;
			}
			
			else if(count%2 != 0){
				System.out.print("Enter the row index: ");
				rowIndex = inputRow.nextInt();
				System.out.print("Enter the column index: ");
				colIndex = inputCol.nextInt();
				System.out.println("-------");
				for(int i= 0; i < ticTac.length; i++){
					for(int j = 0; j < ticTac.length; j++){
						ticTac[rowIndex][colIndex] = "o";
						System.out.print("|"+ticTac[i][j]);
					}
					
					System.out.println("|");
					System.out.println("-------");
				}
				
				
	//----------------------------------------Player X
				//Check Row
				
				if(ticTac[0][0].equals("o") && ticTac[0][1].equals("o") && ticTac[0][2].equals("o")){
					System.out.println("Player 2 \"o\" won!");
					break;
				}
				
				else if(ticTac[1][0].equals("o") && ticTac[1][1].equals("o") && ticTac[1][2].equals("o")){
					System.out.println("Player 2 \"o\" won!");
					break;
				}
				
				else if(ticTac[2][0].equals("o") && ticTac[2][1].equals("o") && ticTac[2][2].equals("o")){
					System.out.println("Player 2 \"o\" won!");
					break;
				}	
				//Check Column
				else if(ticTac[0][0].equals("o") && ticTac[1][0].equals("o") && ticTac[2][0].equals("o")){
					System.out.println("Player 2 \"o\" won!");
					break;
				}	
				else if(ticTac[0][1].equals("o") && ticTac[1][1].equals("o") && ticTac[2][1].equals("o")){
					System.out.println("Player 2 \"o\" won!");
					break;
				}
				else if(ticTac[0][2].equals("o")  && ticTac[1][2].equals("o") && ticTac[2][2].equals("o")){
					System.out.println("Player 2 \"o\" won!");
					break;
				}
				//Cross
				else if (ticTac[0][0].equals("o") && ticTac[1][1].equals("o") && ticTac[2][2].equals("o")){
					System.out.println("Player 2 \"o\" won!");
					break;
				}
				else if(ticTac[0][2].equals("o") && ticTac[1][1].equals("o") && ticTac[2][0].equals("o")) {
					System.out.println("Player 2 \"o\" won!");
					break;
				}
			count++;
			c=c+1;
			
			}
			
			if(c == 9){
				
				System.out.println("Draw");
				break;
			}
			
		}
		
	}

}
