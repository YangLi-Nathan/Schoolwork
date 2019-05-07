import java.io.IOException;
import java.util.*;
/*Documentation:

Purpose:
	 * Write a program name calc.java that evaluates an infix expression entered by the user.
	 * The expression may contain the following tokens:
	 * 
	 *1) Integer constants (a series of decimal digits). 
	 *2) x (representing a value to be supplied later).
	 *3) Binary operators (+,-,*,/ and %).
	 *q) Parentheses
	 *
	 * Spaces between tokens are allowed but not required. The program will convert the expression
	 * to postfix (RPN) form and display the converted expression. The program will must also solve
	 * the postfix expression producing a final answer. The must run again and again
	 * repeatedly prompting the user for the value of x, displaying the value of the expression each time.
	 * When the user the letter q instead of a number, the program terminates.
	 *
	 *Additional requirements:
	 *1) You must use stack objects during the translation from infix to postfix and during the evaluation
	 *of the postfix expression.
	 *2) Operators must have the correct precedence and associativity.

Solution and Algorithms:
	*Switch
	*Stacks
	*boolean
	*Array
	*if,if else statement
	*for loop
	*Scanner
	*do while loop
	*while loop
	

	 *Description of how to use this program:
	 *Run this program output follow the instructions that displayed in the console window.

	 
	Class:2720 								Data Structures	
	CRN:86473
	Student Name: Yang Li		
	Program Name: calc.java 				Date:11/02/2017	
	*/
public class calc {

	public static void main(String[] args) throws IOException{
		String repeat="a";
		String input="";
		String output;
	
		do{
			Scanner userdec=new Scanner(System.in);
		
			input=getString();		
			
			//convert infix to postfix
	
			InfixToPostfix convert = new InfixToPostfix(input);
			output=convert.convertion();
			System.out.println("\nConverted expression: "+output+"\n");

		

		//repeat the program until user input "q" to quit this program
			System.out.println("Enter \"q\" to quite the program or Enter \"yes\" to repeat the program.");
			repeat=userdec.next();
		}while(!repeat.equalsIgnoreCase("q"));
		
	
	}
	

	public static String getString() throws IOException{
		
		Scanner sc = new Scanner(System.in);
		String r;
		//check errors
		while(true){
			String s="";
			
			System.out.println("Enter infix expression: ");
			s=sc.nextLine().replaceAll("\\s+","");	
			s.toLowerCase();
			r=s.replaceAll("\\s", "");
			
			
			String infixString=s;
			char infix[]=infixString.toCharArray();
			if(s.contains(".")){
				System.out.println("Error in expression!! Cannot accpet floating point numbers. ");
				System.exit(-1);
				
			}else if(infix[infix.length-1] == '/' || infix[infix.length-1] == '*' || infix[infix.length-1] == '%' ||
			           infix[infix.length-1] == '+' || infix[infix.length-1] == '-'){
				System.out.println("Error in expression!! No operator between operands." +
			            "Also last token must be an operand or closed parenthesis.");
				System.exit(-1);
				
			}else if(infix[0] == '/' || infix[0] == '*' || infix[0] == '%' || infix[0] == '+' || infix[0] == '-'){
				System.out.println("Error in expression!! First token must be an"
		                   + " operand or open paranthesis.");
				System.exit(-1);
			}
			
		    else{
		    	r=s.replaceAll("\\s", "");
				break;
			}
			
			
			
		}
		return r;

	}

	


	
	
	
	
	
	
	
	
	
	
	
}