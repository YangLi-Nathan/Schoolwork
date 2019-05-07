package phonedir;

import java.util.*;
import java.io.*;
/*Documentation:

Purpose:
	 * Write a program name phonedir.java that maintains a list of records containing names and phone numbers. 
	 * The program will prompt the user for a command, execute the command, then prompt the user for another commands. 
	 * The program will only stop when user selected q command. 
	 *
	 *The commands must be chosen from the following possibilities:
	 *
	 *a) Show all record
	 *b) Delete the current record
	 *f) Change the first name in the current record
	 *l) Change the last name in the current record
	 *n) Add a new record
	 *p) Change the phone number in the current record
	 *q) Quit
	 *s)Select a record from the record list to become the current record
	 *
	 *Assume that phone number contains no spaces.
	 *After a deletion, there is no record currently selected
	 *Each record(first name, last name and phone number) must be store as an object. These objects must be sorted in a Linked List.
	 *The list must be kept sorted at all times-based on the last name. Sorting is to be achieved when an insertion or modification is done.
	 *No Sorting routine is allowed. Always insert a new record or edited record into its correct place in the list.
	 *Note: Changing the last name will require resorting.
	 

Solution and Algorithms:
	
	*create all the command constructions 
	*use switch to set up the menu and command options
	*link all the command options to the main method 
	*
	*command option methods:
	*option a:display all the record
	*option d:delete current record and display all the record
	*option f and option l:change the current record's first name need to make sure capital first letter
	*option n need to make sure capital first letter of first and last name
	*option p need to create a check to make sure same number is not valid
	*option s need to make sure if the user make any changes to the current record the linked list is sorted
	*
	*extra methods that was used:
	*create a sort method to make sure linked list is sorted at all time
	*create a menu method to display all the commands that user can use
	*linked list index method: index is used when we change current record
	*display current record method
	*check existed number method:check if input number is existed or not
	*
	*
	*Switch
	*Linked list
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
	Program Name: phonedir  				Date:10/16/2017	
	*/


public class phonedir {

//declare linked list and other variables
	
	LinkedList<directory> list= new LinkedList<directory>();
	
	private int currentRecord=0;
	private Scanner input;
	
	public phonedir(){
		input=new Scanner(System.in);
	}

//display menu
	public static void Menu(){
		System.out.println("A program to keep a Phone Directory:");
		System.out.println();
		System.out.println("a\tShow all records \nd\tDelete the current record \nf\tChnage the first name in the current record "
				+ "\nl\tChange the last name in the current record \nn\tAdd a new record \np\tChange the phone number in the current record"
				+ " \nq\tQuit \ns\tSelect a record from the record list to become the current record");
	}

//show all records	
	public void optionA(){
		//check if nothing inside the list then prompt user that there is no current record
		System.out.println("");
		if(list.size()==0||this.currentRecord==-1){
			System.out.println("No Current Record");
			System.out.println("");
			return;
		}
		
//display linked list 
		System.out.println("First Name\tLast Name\t\tPhone Number");
		System.out.println("----------------------------------------------------");
		
		for(directory person: this.list){
			//get first name from directory
			System.out.print(person.getFirstName());
			for(int i=person.getFirstName().length();i<20;i++){
				System.out.print(" ");
			}
			
			System.out.print(person.getLastName());
			//get last name from directory
			for(int i=person.getLastName().length();i<20;i++){
				System.out.print(" ");
			}
			//get phone number from directory
			System.out.print(person.getPhoneNumber());
			for(int i=person.getPhoneNumber().length();i<20;i++){
				System.out.print(" ");
			}	
			System.out.println("");
			System.out.println("");
		}
		System.out.println("");
	}
	
//delete the current record
	public void optionD(){
		if(list.size()==0||this.currentRecord==-1){
			System.out.println("No Current Record");
			return;		
		}
		//remove current record from directory
		this.list.remove(this.currentRecord);
		System.out.println("Current Record has been Removed");
		optionA();
		return;
	}
//change the first name in the current record
	public void optionF(){
		if(list.size()==0||this.currentRecord==-1){
			System.out.println("No current record");
			System.out.println("");
			return;
		}
		
		System.out.print("Enter First Name: ");
		String newfirstname=input.next();
		directory current=list.get(currentRecord);
		list.remove(current.getFirstName());
		//make first letter as capital letter
		String f1=newfirstname.substring(0,1).toUpperCase();
		newfirstname=f1+newfirstname.substring(1);
		current.setFirstName(newfirstname);
		//prompt user f command is executed		
		System.out.println("\nFirst Name has been changed\n");	
		displaycurrentrecord();
		System.out.println("");
	}
	
//change last name in the current record
	public void optionL(){
		if(list.size()==0||this.currentRecord==-1){
			System.out.println("No Current Record");
			return;
		}
		System.out.print("Enter Last Name: ");
		String newlastname=input.next();
		//make first letter as capital letter
        String s1 = newlastname.substring(0, 1).toUpperCase();
        newlastname = s1 + newlastname.substring(1);
		
		directory current=list.get(currentRecord);
		//remove current record 
		list.remove(currentRecord);
		
		current.setLastName(newlastname);
		//sort list
		Order(current);
		this.list.add(this.currentRecord,current);
		//prompt user l command is executed
		System.out.println("\nLast Name has been changed\n");
		displaycurrentrecord();
		System.out.println("");
	}
	
//add a new record
	public void optionN(){
		System.out.print("Enter First Name:");
		String first =input.next();
		//make first letter as capital letter
		String captialfl=first.substring(0,1).toUpperCase();
		first=captialfl+first.substring(1);
		System.out.print("Enter Last Name:");
		String last=input.next();
		//make first letter as capital letter
		String captiallf=last.substring(0,1).toUpperCase();
		last=captiallf+last.substring(1);
		
//check if the phone number that user entered exists or not
		String phonenumber=null;
	
		boolean numExist=true;
		
		while(numExist){
			System.out.print("Enter Phone Number: ");
			phonenumber=input.next();		
		
		numExist=checknumbers(phonenumber);
		if(numExist){
			System.out.println("Number is already existed, Enter another phone number: ");
			System.out.println();
			}
		}
		
		//format phone number as xxx-xxx-xxxx
		phonenumber=String.valueOf(phonenumber).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");

		directory person = new directory (first, last, phonenumber);
		Order(person);
		this.list.add(this.currentRecord, person);
		System.out.println("");
		
		displaycurrentrecord();
		System.out.println("");
	}

//change the phone number in the current record
	public void optionP(){
		if(list.size()==0||this.currentRecord==-1){
			System.out.println("No Current Record");
			return;	
		}
		
		String newphonenumber = list.get(currentRecord).getPhoneNumber();
		
		//check phone number if it is exists or not
		boolean numExist=true;
		while(numExist){
			System.out.println("Enter Phone Number: ");
			newphonenumber=input.next();
				
		numExist=checknumbers(newphonenumber);
		if(numExist){
			System.out.println("Number is already existed, Enter another phone number: ");
			}
		}
		directory current=this.list.get(currentRecord);
		this.list.remove(current.getPhoneNumber());
		newphonenumber=String.valueOf(newphonenumber).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
		current.setPhoneNumber(newphonenumber);
		System.out.println("");
		System.out.println("Current Record's phone number has been changed.");
		System.out.println("");
		displaycurrentrecord();
		System.out.println("");
	}
//quit the program
	public void optionQ(){
		System.out.println("You are succussfully quitted the program.");
	}
//select a record from the record list to become the current record
	public void optionS(){
		if(list.size()==0||this.currentRecord==-1){
			System.out.println("No Current Record");
			System.out.println("");
			return;
		}
		optionA();
		System.out.print("Enter First Name: ");
		//capitalized first letter
		String first=input.next();
		String f1=first.substring(0,1).toUpperCase();
		first=f1+first.substring(1);
			
		System.out.print("Enter Last Name: ");
		String last=input.next();
		//capitalized first letter
		String l1=last.substring(0,1).toUpperCase();
		last=l1+last.substring(1);
		
		//check if number is correct
		String number=null;
		boolean numbercorrect=false;
		
		while(!numbercorrect){
			System.out.print("Enter Phone Number: ");
			number=input.next();
			if(number.equals("q")){
				System.exit(-1);
			}
			
			//use regular expression to format phone number
			number=String.valueOf(number).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
			
			 String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";

	            if (!number.matches(regex)) {
	                System.out.println("Invalid Phone Number, Please Enter Again");
	            } else {
	                numbercorrect = true;
	            }			
		}
		int indexperson=Index(new directory(first,last, number));
		
		if(indexperson==-1){
			System.out.println("");
			System.out.println("No matching record found.");
			System.out.println("");
			return;
		}
		else if(indexperson>=0){
			this.currentRecord=indexperson;
			System.out.println("");
			System.out.println("Current Record has been changed.");
			System.out.println("");
		}		
		System.out.println("");
		displaycurrentrecord();
		System.out.println("");
	}
	
//main method to execute the program
	public static void main(String[] args) {
		phonedir phonedirectory = new phonedir();
		String decision=null;
		Scanner sc= new Scanner(System.in);

		//use do while loop to repeat ask user to input command until input command is q
		do{
			Menu();
			System.out.println("");
			System.out.println("Enter a command from the list above (q to quit): ");
			decision=sc.nextLine();
			//display menu and let user input commands 
			switch(decision.toLowerCase()){
			case "a":			
				phonedirectory.optionA();
				break;				
			case "d":
				phonedirectory.optionD();
				break;				
			case "f":
				phonedirectory.optionF();				
				break;				
			case "l":
				phonedirectory.optionL();
				break;				
			case "n":
				phonedirectory.optionN();
				break;				
			case "p":
				phonedirectory.optionP();
				break;				
			case "q":
				phonedirectory.optionQ();
				break;				
			case "s":
				phonedirectory.optionS();
				break;				
			default:
				System.out.println("");
				System.out.println("Illegal Command.");
				System.out.println("");
				break;
			}	
		}while(!decision.equalsIgnoreCase("q"));
	}
	
//check if entered number is exist or not
	private boolean checknumbers(String phoneNumber){
		for(directory person : this.list){
			//phoneNumber=phoneNumber.replaceAll("-", "");
			if(person.getPhoneNumber().equals(phoneNumber)){
				return true;
			}
		}
		return false;
	}

//directory index
	private int Index(directory directory){
		String currentdicrectory=directory.getFirstName()+" "+directory.getLastName()+" "+directory.getPhoneNumber();
		
		for(int i=0;i<list.size();i++){
			String compare=list.get(i).getFirstName()+" "+list.get(i).getLastName()+" "+list.get(i).getPhoneNumber();
		
			if(currentdicrectory.toLowerCase().compareTo(compare.toLowerCase())==0){
				return i;
			}
		}
		return -1;
	}	
	
//sort linked list
	private void Order(directory current){
		String currentorder=current.getLastName()+" "+current.getFirstName()+" "+current.getPhoneNumber();

		//use compare to keep linked list sorted 
		for(int i=0; i<list.size();i++){
			String comparecurrent=list.get(i).getLastName()+" "+list.get(i).getFirstName()+" "+list.get(i).getPhoneNumber();
			
			if(currentorder.toLowerCase().compareTo(comparecurrent.toLowerCase())<0){
				this.currentRecord=i;
				return;
			}else{
				this.currentRecord=i+1;
			}
		}
	}
	//display current record
	private void displaycurrentrecord(){
		System.out.println("Current record is: "+list.get(currentRecord).getFirstName()
				+" "+list.get(currentRecord).getLastName()+" "+list.get(currentRecord).getPhoneNumber());
	}
}

