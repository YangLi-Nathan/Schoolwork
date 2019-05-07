
public class Stacks {
	private int maxSize;
	private char[] stackarray;
	private int top;
	
	
	//constructor
	public Stacks(int size){
		maxSize=size;
		stackarray= new char[maxSize];
		top=-1;
	}
	//check if stack if empty
	public boolean isEmpty(){
		return (top==-1);
	}
	
	//put item on top of the stack
	public void push(char i){
		stackarray[++top]=i;
	}
	
	//take item from top of the stack
	public char pop(){
		return stackarray[top--];
	}
	
	//stack size
	public int size(){
		return top+1;
	}
	public char peek(){
		return stackarray[top];
	}
	public char peekN(int n){ 
		return stackarray[n]; 
		}
	
}
