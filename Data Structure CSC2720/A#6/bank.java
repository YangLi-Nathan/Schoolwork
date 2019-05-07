import java.io.*;
import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/*Documentation:

Purpose:
	 * write a program name bank.java that simulates a bank.Note: use the array to store the 5 tellers.
	 *
	 *The execution phase run for 2 minutes (must invoke a clock in your program) during which time customers will arrive randomly between 2 - 6 seconds and be placed into a queue. 
	 *Each customer will have a property relating to the amount of time he/she wants to spend with a teller, which is to be randomly generated to be between 2 and 5 seconds.
	 *There would be a maximum of 5 tellers to attend to the customers. When you start the simulation, each teller is occupied.
	 *You will need to generate a random time for each of the first 5 customers occupying the tellers at the begining of the 2 minutes simulation.
	 *
	 *As they finish attending a customer (based upon the amount of time associated with each customer), that teller becomes available for the next customer in the queue. 
	 *As a customer is removed from the queue and sent to an "available" teller, then their availability is set to "False". 
	 *Customers are allocated to any one of the 5 tellers that becomes available, and so on... until the time of 2 minutes for the simulation is finished.
	 *
	 *
	 *If after 2 minutes, there are still customers in the queue, we would discard them, but still count them in the total count of customers that visited the bank. 
	 *Also add into the total count of customer the first five customers that the tellers started out with as well as to the individual teller's total.
	 *
	 *
	 *Finally display on the screen (at the end of each execution):
	 *
	 *
	 *1. The total amount of customers that visited the bank for that 2 minutes.
	 *2. The total amount of customers that each teller helped.
	 *3. The total amount of time that each teller was occupied.
	 *4.The total amount of customers that did not get to see a teller.
	 *

Solution and Algorithms:
	*Queue
	*boolean
	*Array
	*if,if else statement
	*for loop
	*Scanner
	*do while loop
	*while loop
	*System.exit()
	*ScheduledExecutorService
	
	


	 *Description of how to use this program:
	 *Run this program output follow the instructions that displayed in the console window.

	 
	Class:2720 								Data Structures	
	CRN:86473
	Student Name: Yang Li		
	Program Name: bank.java 				Date:11/19/2017	
	*/
public class bank{
	
    public static void main(String[] args){
      
       Scanner sc = new Scanner(System.in);
       
       String input;
       while(true){
           System.out.println("Do you want to run this program? Enter \"yes\" or \"no\"");
           System.out.println("");
           input = sc.nextLine();  
     
       if (input.equalsIgnoreCase("yes")){  

           Random rand = new Random();
    	   
    	   Runnable Runnable = new Runnable(){

           Queue<Integer> bankQueue = new LinkedList<Integer>();
           int t1=1;
           int t2=1;
           int t3=1;
           int t4=1;
           int t5=1;
           int tt1, tt2, tt3, tt4, tt5;

           int RUNTIME = 0;
           int customerA, customerB, customerC, customerD, customerE = 0;
           int ServerT1, ServerT2, ServerT3, ServerT4, ServerT5 = 0;
//use boolean to check tellers availability          
           boolean TellerA,TellerB,TellerC,TellerD,TellerE = false;
           boolean[] tellerArray = {TellerA, TellerB, TellerC, TellerD, TellerE};
//customer with teller time is 2-5 second 
           int[] TellerOccupiedTime = {(rand.nextInt(4) + 2),(rand.nextInt(4) + 2),(rand.nextInt(4) + 2),(rand.nextInt(4) + 2),(rand.nextInt(4) + 2)};
           public void run(){
//this program will run for 2 mins
        			if(RUNTIME == 120){
//at the end of the program
                      System.out.println("The total amount of customers that visited the bank for that 2 minutes: " + (customerA + customerB+ customerC
                      + customerD + customerE + 5 + bankQueue.size()) + " customers.");
                      System.out.println("The amount of customers that each teller helped was: ");
                      System.out.println("Teller 1: " + (customerA + 1));
                      System.out.println("Teller 2: " + (customerB + 1));
                      System.out.println("Teller 3: " + (customerC + 1));
                      System.out.println("Teller 4: " + (customerD + 1));
                      System.out.println("Teller 5: " + (customerE + 1));
                      System.out.println("The total amount of time that each teller was occupied: ");
                      System.out.println("Teller 1: " + (ServerT1+(rand.nextInt(4)+2))+" Seconds");
                      System.out.println("Teller 2: " + (ServerT2+(rand.nextInt(4)+2))+" Seconds");
                      System.out.println("Teller 3: " + (ServerT3+(rand.nextInt(4)+2))+" Seconds");
                      System.out.println("Teller 4: " + (ServerT4+(rand.nextInt(4)+2))+" Seconds");
                      System.out.println("Teller 5: " + (ServerT5+(rand.nextInt(4)+2))+" Seconds");
                      System.out.println("The total amount of customers that did not get to see a teller: " + bankQueue.size() + " customers");
                      System.out.println("");
                      System.out.println("Simulation Ended.");
                      System.exit(-1);
                  }
        			
//add customer time to the array 
        		else{
                   if((rand.nextInt(9)+2) < 6){
//every 2-6 seconds add one customer to queue             
                       int addCustomerT = (rand.nextInt(5) + 2);
                       bankQueue.add(addCustomerT);
                   } while(t1 == 1){   
//checks tellers time with customers  
                	   tt1 = RUNTIME;
                       t1 = 0;
                   }
                   if ((RUNTIME - tt1) >= TellerOccupiedTime[0]) {
                	   tellerArray[0] = true;
                       if (tellerArray[0] == true && bankQueue.isEmpty() == false){
                    	   ServerT1 += TellerOccupiedTime[0];
                    	   TellerOccupiedTime[0] = bankQueue.poll();
                           t1 = 1;
                           customerA++;
                       }
//checks tellers availability
                   } while(t2 == 1){
                	   tt2 = RUNTIME;
                       t2 = 0;
                   }
                   if ((RUNTIME - tt2) >= TellerOccupiedTime[1]){
                	   tellerArray[1] = true;
                       if (tellerArray[1] == true && bankQueue.isEmpty() == false){
                    	   ServerT2 += TellerOccupiedTime[1];
                    	   TellerOccupiedTime[1] = bankQueue.poll();
                           t2 = 1;
                           customerB++;
                       }
                   }while(t3 == 1){
                	   tt3 = RUNTIME;
                       t3 = 0;
                   }
                   if ((RUNTIME - tt3) >= TellerOccupiedTime[2]){
                	   tellerArray[2] = true;
                       if (tellerArray[2] == true && bankQueue.isEmpty() == false){
                    	   ServerT3 += TellerOccupiedTime[2];
                    	   TellerOccupiedTime[2] = bankQueue.poll();
                           t3 = 1;
                           customerC++;
                       }
                   }while(t4 == 1){
                	   tt4 = RUNTIME;
                       t4 = 0;
                   }
                   if ((RUNTIME - tt4) >= TellerOccupiedTime[3]){
                	   tellerArray[3] = true;
                       if (tellerArray[3] == true && bankQueue.isEmpty() == false){
                    	   ServerT4 += TellerOccupiedTime[3];
                    	   TellerOccupiedTime[3] = bankQueue.poll();
                           t4 = 1;
                           customerD++;
                       }
                   }while(t5 == 1) {
                	   tt5 = RUNTIME;
                       t5 = 0;
                   }
                   if ((RUNTIME - tt5) >= TellerOccupiedTime[4]){
                	   tellerArray[4] = true;
                       if (tellerArray[4] == true && bankQueue.isEmpty() == false){
                    	   ServerT5 += TellerOccupiedTime[4];
                    	   TellerOccupiedTime[4] = bankQueue.poll();
                           t5 = 1;
                           customerE++;
                       }
                   }
                   RUNTIME++;
//tracking running time and queue status                 
                   System.out.println("Number of Customer in the Queue: "+bankQueue.size());
                   System.out.println("There are " + (120 - RUNTIME) + " seconds left in the simulation."); 
                   System.out.println("__________________________________________________________________");
               }
           }
       };
//display every sec
       ScheduledExecutorService bankS = Executors.newScheduledThreadPool(1);
       bankS.scheduleAtFixedRate(Runnable, 0, 1, TimeUnit.SECONDS);
       		}
       }
   }
}