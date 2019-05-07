import java.util.*;
import java.util.Random;
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
public class ArrayList {
		//declare all the varibles that will be needed for this program.
	   private final int defaultsize = 10;
	   private int num; 
	   private Object[] list; // Arraylist itslef
//Constructors
	   public ArrayList(){
	       num = 0;
	       list = new Object[defaultsize];
	   }
	   
	   public ArrayList(int n){
	       num = 0;
	       list = new Object[n];
	   }   
	  //this method use to add values and will also gives list length as well
	   public void add(Object x){
	       if(size() == list.length)
	           additional();
	      
	       list[num] = x;
	       num++;
	   }
	  //takes in an number and palces th value at a given location in arraylist
	   public void add(int index, Object x){
	       if(index < 0 || index > num)
	       {
	           System.out.println(index + " is an invalid index to add.");
	           return;
	       }
	              
	       if(size() == list.length)
	           additional();
	      
	       for(int i = num; i > index; i--)
	           list[i] = list[i - 1];
	      
	       list[index] = x;
	                  
	       num++;
	      
	       System.out.println("The number " + x + " is added at the index " + index+".");
	   }
	  //setters and getters
	   
	   public int size(){
	       return num;
	   }
	  
	  //test if the list is empty
	   public boolean isEmpty(){
	       return (num == 0);
	   }
	  //checks if particular object already exist in array list
	   public boolean isIn(Object n){
	       if(find(n) >= 0)
	           return true;
	       else
	           return false;
	   }
	  
	   public int find(Object n){
	       for(int i = 0; i < num; i++)
	       {
	           if(n.equals(list[i]))
	               return i;
	       }
	      
	       return -1;      
	   }
	  // takes in an number and removes the 1st occurrence of an object starting from location 0
	   public void remove(Object x){          
	       int index = find(x);

	       if(index < 0){
	           System.out.println(x + " is not found.");
	           return;
	       }

	       num--;      
	      
	       for(int i = index; i < num; i++){
	           list[i] = list[i + 1];
	       }

	       list[num] = null;
	       System.out.println("The number " + x + " is removed.");
	   }
	  

	  //more values need to added to the array list. it creates a new array to implement user's input.
	   private void additional(){
	       Object[] newarray = new Object[list.length * 2];

	       for(int i = 0; i < list.length; i++){
	           newarray[i] = list[i];
	       }

	       list = newarray;
	   }
//takes in an integer for the index and retrieves then returns a value from a given location.
	   public Object get(int index){      
	       if(index < 0 || index > num)
	           return null;
	       else
	           return list[index];
	   }
	   //display result
	   public String toString(){
	       String result = "";

	       for(int i = 0; i < num; i++)
	       {
	           result = result + list[i].toString() + " ";
	       }
	       return result;
	   }       
	}