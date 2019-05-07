package phonedir;
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
	 *



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
	Program Name: phonedir 				Date:10/16/2017	
	*/
public class directory {
	//delcare variables that might be used in this program
		private String FirstName;
		private String LastName;
		private String PhoneNumber;
		
		
		//directory format: first name , last name, phone number
		public directory (String fname, String lname, String pnumber){
			this.FirstName=fname;
			this.LastName=lname;
			this.PhoneNumber=pnumber;
		}
		
		//getters and setters
		public String getLastName(){
			return LastName;
		}
		public void setLastName(String lastname){
			this.LastName=lastname;
		}
		public String getFirstName(){
			return FirstName;
		}
		public void setFirstName(String firstname){
			this.FirstName=firstname;
		}
		public String getPhoneNumber(){
			return PhoneNumber;
		}
		public void setPhoneNumber(String phonenumber){
			this.PhoneNumber=phonenumber;
		}
}
