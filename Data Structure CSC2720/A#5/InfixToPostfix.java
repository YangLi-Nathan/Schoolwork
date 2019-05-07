
public class InfixToPostfix {
	private Stacks theStacks;
	private String input;
	private String output="";
	
	
	public InfixToPostfix(String s){
	
		input=s;
		int stackSize=input.length();
		theStacks= new Stacks(stackSize);
	}
	
   
	
	
	
	public String convertion(){	
		//------------
		int right=0;
		int left=0;
		
		String postfix="";
		String pfix="";
		
		char previous=input.charAt(0);
		
		

		char prevch='\0';
		
		for(int i=0;i<input.length();i++){
			
			char c = input.charAt(i);
			

			
			//differentiate
			switch(c){
			//parentheses
			case '(':
				theStacks.push(c);
				break;
			case ')':
				parentheses(c);
				break;
			//precedence level 1 operator
			case '^':
				operator(c,1);
			//precedence level 2 operator
			case '*':
			case '/':
				operator(c,2);
				break;
			//precedence level 3 operator
			case '+':
			case '-':
				operator(c,3);
				break;
			//operand
			default:
				output=output+c;
				break;
			}
		}
		while(!theStacks.isEmpty()){
			output=output+theStacks.pop();
		}
		return output;
	}
	
	
	//(x + 1) * (x – 2) / 4
	//transfer operator to stack
	public void operator(char op, int prec){
		/*precedence level list:
		 * 
		 * level 1: '^'
		 * level 2: '*' or '/'
		 * level 3: '+' or '-'
		 */
		while(!theStacks.isEmpty()){
			
			char ptop=theStacks.pop();

			if(ptop=='('){
				theStacks.push(ptop);
				break;
			}else{
				int preclvl;
				
				if(ptop=='+'||ptop=='-'){
					preclvl=3;
				}else if (ptop=='^'){
					preclvl=1;
					}else{
					preclvl=2;
					
					}
				if(preclvl>prec){
					theStacks.push(ptop);
					break;
				}else{
					output=output+ptop;
				}
			}	
		}
		
		theStacks.push(op);
	}

	//parentheses
	public void parentheses(char c){
		while(!theStacks.isEmpty()){
			char cp=theStacks.pop();

			if(cp=='('){
				break;
			}else{
				
				output=output+cp;
			}
		}
	}
	
}
