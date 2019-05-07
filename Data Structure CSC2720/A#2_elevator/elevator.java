package elevator;

import java.util.*;
import java.util.concurrent.TimeUnit;
/*Documentation:
 
   Purpose:
 * Write a program name elevator.java that simulates one elevator services in a 12-floor building. 
 * There is only one elevator working this building. The floors of the building are numbered from 1 to 12.
 * Elevator going up has 8 requests.
 * Elevator going down has 5 requests.
 * Fill out two Arraylist with random number as going up and going down elevator.
 * Each time you stop at a floor, you must stay there for 3 seconds.
 * (allowing the people to either enter the elevator or leave the elevator). 
 * Display this time in a counting format as well as an appropriate message. 
 * The elevator must take 2 seconds to move from one floor to another.
 * The direction in which the elevator is going must be known at all times and the floor to which it is going. 
 * Ask user if the user wants to run the program again and again.
 

 *First declare all the variables.
 *use random to fill out two arraylists(going up and going down).
 *create a method that sorts both arraylists(going up and going down).
 *In the main method display going up and going down arraylist with sorted going up and going down arraylist.
 *Create Multiple for loop and if loop to make functional elevator.
 *Create a new method to ask if the user wants to repeat the program.

 *for loop
 *arraylist
 *if statement
 *boonlean
 *Random 
 *Scanner
 *while loop
 *TimeUnit sleep

 *Description of how to use this program:
 *Run this program
 *If the user wants to repeat this program input "Y" or "y", then the program will be repeat.
 
 
Class:2720 								Data Structures	
CRN:86473
Student Name: Yang Li		
Program Name: Elevator					Date:09/15/2017	
*/

public class elevator {
	//declare variables that will be used in this program.
	Random r= new Random();
	int upstops=8;
	ArrayList <Integer> uprequest= new ArrayList<Integer>(upstops);
	int downstops=5;
	ArrayList <Integer> downrequest= new ArrayList<Integer>(downstops);
	ArrayList<Integer> sortrequest=new ArrayList<Integer>();
	int rnum;
	int rn;
	boolean GoingUp;
	int StartingFloor;

	/*
	create two arraylist, first uprequest arraylist fill with 8 random numbers,
	second downrequest arraylist fill with 5 random numbers. 
	
	for going up requests random number range between 2 to 12. randomly pick 8 numbers
	for going down requests random number range between 11 to 1. randomly pick 5 numbers
	*/
public void fillrequests(){
	//clear all the arraylist to making sure no values in the arraylist.	
	uprequest.removeAll(uprequest);
	downrequest.removeAll(downrequest);
	sortrequest.removeAll(sortrequest);
	Random r= new Random();
	rnum = 0;

	//Fill out Going up requests arraylist with random number that has no duplicate values. 
   for (int j = 0; j < upstops; j++) {
	   rnum = r.nextInt(11) + 2;
       for (int i = 0; i < 8; i++) {
    	   //check duplicate values
           if (uprequest.contains( rnum)) {
               while (uprequest.contains( rnum)) {
               	rnum = r.nextInt(11) + 2;
                   i = 0;
               }
               continue;
           } else {
               continue;
           }
       }    
      uprequest.add(j, rnum);
   }
	//Fill out Going down requests arraylist with random number that has no duplicate values.
	rn = 0;

   for (int j = 0; j < downstops; j++) {
   	rn = r.nextInt(11) + 1;
       for (int i = 0; i < 5; i++) {

           if (downrequest.contains( rn)) {
               while (downrequest.contains( rn)) {
               	rn = r.nextInt(11) + 1; //random number between 1-11.
                   i = 0;
               }
               continue;
           } else {
               continue;
           }
       }    
       downrequest.add(j,rn);
   }
   //Display going up and going down arraylist.
   	System.out.println("Up_ArrayList: ");
	System.out.println(uprequest);
   	System.out.println("Down_ArrayList: ");
	System.out.println(downrequest);
}
//elevator floor and direction setting.
public elevator(){
	GoingUp=true;
	StartingFloor=1;
}
//sort going up and going down requests, and also combine going up and down to build a sorted arraylist.
public void sortrequest(){
	//sort going up arraylist in Ascending order.
	Collections.sort(uprequest);
	sortrequest.addAll(uprequest);
	//sort going down arraylist in descending order.
	Collections.sort(downrequest, Collections.reverseOrder());
	sortrequest.addAll(downrequest);
}
//boolean method to determine if the user wants to repeat the program or not.
public boolean repeat(){
    Scanner sc =new Scanner(System.in);
    String input = sc.nextLine().trim().toLowerCase();
    boolean repeat= ("y".equals(input));
    return(repeat);
}
//main method
public static void main(String[] args) throws InterruptedException {
	//create new elevator and fill out request arraylists.
	elevator elevator = new elevator();
	elevator.fillrequests();
	Thread th = new Thread(); // timer that counts seconds
	
    //Elevator is going up and also displays sorted going up and going down arraylist.
	while(elevator.GoingUp){ 
		elevator.sortrequest();
		System.out.println("Sorted Going_Up_ArrayList: ");
		for (int i = 0; i < elevator.upstops; i++) {
			System.out.print(elevator.uprequest.get(i) + " ");
	   }
		System.out.println("");
       System.out.println("Sorted Going_Down_ArrayList: ");
       for (int i = 0; i < elevator.downstops; i++) {
           System.out.print(elevator.downrequest.get(i) + " ");
       }
       System.out.println("");
       System.out.println("Sorted_Request: ");
       for (int i = 0; i<1; i++){
           System.out.print(elevator.sortrequest+ " ");
       }
       System.out.println("");
       int i = 0;
       elevator.StartingFloor=1;
       System.out.println("");
       System.out.println("Starting at floor 1");
       System.out.println("");
       /*elevator is going up.The elevator stops 3 seconds for each requests and the elevator takes 2 seconds to move 
       from one floor to another.
       */
       while(elevator.GoingUp){
           if(elevator.StartingFloor==elevator.sortrequest.get(i)){
        	   TimeUnit.SECONDS.sleep(2);
        	   System.out.println("");
               System.out.print("Stopping at floor " + elevator.StartingFloor+" for 3 seconds");
               TimeUnit.SECONDS.sleep(1);
               System.out.print(" \u2192 1");
               TimeUnit.SECONDS.sleep(1);
               System.out.print(",2");
               TimeUnit.SECONDS.sleep(1);
               System.out.print(",3");
               System.out.println("");
               i++;
           }
           //determine if the elevator is going up or down.
           else if(elevator.StartingFloor>elevator.sortrequest.get(i)){
        	   	elevator.GoingUp=false;
           }
           //The action of elevator is going down.
           else{
        	   System.out.println("");
        	   System.out.print("Next floor in 2 seconds.");
        	   TimeUnit.SECONDS.sleep(2);
               System.out.println("\nGoing up:now at floor " + (elevator.StartingFloor+1));
               elevator.StartingFloor++;
           }
    }
       //elevator is going down.
       while(!elevator.GoingUp){
    	   //Ask the user if the user wants to repeat this program again and again.
    	   if(elevator.StartingFloor==1){
               System.out.println("\nDo you want to run the elevator again? Type \"Y or y \" to continue. \"N or n\" to stop.");
               if(elevator.repeat()){
            	   elevator.fillrequests();
                   elevator.GoingUp=true;          
                   break;
               }
               //program stops if the user did not enter y or Y.
               else{
                   System.exit(1);
               }
               /*elevator is going down.The elevator stops 3 seconds for each requests and the elevator takes 2 seconds to move 
               from one floor to another.
               */
           } if(i<elevator.sortrequest.size() && elevator.StartingFloor==elevator.sortrequest.get(i)){
        	   System.out.println("");
        	   System.out.print("Stopping at floor:"+elevator.StartingFloor+" for 3 seconds ");
               TimeUnit.SECONDS.sleep(1);
               System.out.print(" \u2192 1");
               TimeUnit.SECONDS.sleep(1);
               System.out.print(",2");
               TimeUnit.SECONDS.sleep(1);
               System.out.print(",3");
               System.out.println("");
               i++;
           }
           		//The action of elevator is going down.
           		else {
           		System.out.print("Next floor in 2 seconds.");
             	   TimeUnit.SECONDS.sleep(2);
             	   System.out.println("\nGowing down: now at floor "+ (elevator.StartingFloor-1));
             	   elevator.StartingFloor--;
           		}
         	}
		}	
  	}
}