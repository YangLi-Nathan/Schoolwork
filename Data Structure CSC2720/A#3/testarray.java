import java.util.Random;
import java.util.Scanner;
/*Documentation:

Purpose:
	 * Write a program name ArrayList.java that build the ArrayList data Structure that exist in the java library.
	 * The class must be written to accept any type of Objects.  
	 *
	 *One default constructor that will create an ArrayList object with a default size (capacity) of 10 ------ public ArrayList();
	 *Another constructor that accepts a parameter of type int and sets the size to this parameter ---- public ArrayList(int n);
	 *A method that allows you to place a value at the end of the ArrayList ---- public void add(Object x);
	 *A method that allows you to place a value at a given location ---- public void add(int index, Object x);
	 *A method that allows you to retrieve a value from a given location ---- public Object get(int index);
	 *A method that allows you the number of elements in the the ArrayList ---- public int size();
	 *A method would test to see if the ArrayList is empty ---- public boolean isEmpty();
	 *A method that see if a particular object exist in the ArrayList --- public boolean isIn(Object ob);
	 *A method that will return the location of first occurrence of an Object starting from location 0 ----- public int find (Object n);
	 *A method that will remove the first occurrence of an Object starting from location 0 ----- public void remove (Object n);
	 *
Now, write a driver program (the class with the public static void main(String[] args) method) name testarray.java to test the ArrayList data structure you just created. 
That is, you must test all ten (including the default constructor) of the above methods. For those that are returning a value, print out the returned value to the screen and for those that are not returning a value, 
print a message that indicate if it successfully completed its task.

To test the ArrayList, you must randomly generate 15 integer numbers ranging from 1 to 25 and add to the two ArrayList you created 
(One using the no-parameter constructor and the other using the one-parameter constructor). 
Of course, to use the one-parameter constructor, you must prompt the user for an initial size of the ArrayList.
Remember --- The size function should be based upon the actual number of elements you have in the ArrayList at any given time.






Solution and Algorithms:
	
	*Fill up all the methods are given in the instruction. 
	*Set the array as size 10 and then making additional slots as the array growths.
	*Making sure the add and remove condition is correct. 
	*It uses a for loop to load the array list with given values. 
	*It then uses additional method to expand array list if needed. 
	*
	*
	*private final int
	*boolean
	*Array
	*if,if else statement
	*for loop
	*Scanner
	*Random number
	 

	 *Description of how to use this program:
	 *Run this program.output will be display all the method that mentioned in the instruction. 

	 
	Class:2720 								Data Structures	
	CRN:86473
	Student Name: Yang Li		
	Program Name: ArrayList					Date:10/02/2017	
	*/
public class testarray {

	public static void main(String[] args) {
		ArrayList xx=new ArrayList();
		Random rand = new Random();
		Scanner sc= new Scanner(System.in);
		int listrange=0;
		//ask user to input number for the list range must be greater thatn 15.
		while(listrange<15){
			System.out.println("Please enter the array list range (must be more than 15): ");
			listrange=sc.nextInt();
		}
		//fill up list with random number from 1-25.
		
		
		
		
		for(int i=0;i<listrange;i++){
			int randNum=1+rand.nextInt(25);
			xx.add(randNum);
		}
		
		System.out.println("List: "+xx);
		//given index number and get the value if the index existed in the array
		int index1=6;
		Object obj1=xx.get(index1);
		if(obj1==null){
			System.out.println(index1+" is not an valid element.");
		}
		else{
		System.out.println("The index number is: "+index1+" and the number is "+obj1+".");
		}
		int length = xx.size();
		//display the array list size
		System.out.println("The List size is: "+length+".");
		
		//given value and try to find the value exist in the array list or not .
		//if it exists then gives the index number
		Object v2=15;
		boolean find=xx.isIn(v2);
		//check if number is exist in the list or not.
		if(find){
			System.out.println("The number "+v2+ " is found.");
		}else{
			System.out.println("The number "+v2+" is not found.");
		}
		
		Object v3=7;
		int index2=xx.find(v3);
		if(index2>=0){
			System.out.println("The index of the number "+v3+" is "+index2+".");
		}else{
			System.out.println("The number "+v3+" is not found.");
		}
		//remove the value that founded
		Object v4=8;
		xx.remove(v4);
		System.out.println("List: "+xx);//display list with removed value
		//add the value that founded into the list
		int index3=9;
		Object obj5=5;
		xx.add(index3, obj5);
		//display list with added value
		System.out.println("List: "+xx);
	}

}
