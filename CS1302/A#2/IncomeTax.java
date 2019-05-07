/*Student Name: Yang Li			Data:06/20/2017			Title:IncomeTax Program
 * Description:
 * Write a program named IncomeTax.java. generate random number of people in range
 * of 1 to 15. ask the user to input income for each person, and then displays the 
 * tax due. and also, display the people with max value of taxes on the screen. */
import java.util.Random;
import java.util.Scanner;

public class IncomeTax {

	public static void main(String[] args) {
		//random number of people
		Random rand = new Random();
		int NumberofPeople =rand.nextInt(15)+1;
		System.out.println("Number of people been selected: "+NumberofPeople);
		//array to store income
		Scanner console= new Scanner(System.in);
		
		double[] income = new double[NumberofPeople];
		Double[] maxValueTax = new Double[NumberofPeople];
		//store tax value into array
		//repeatly console income and print out tax due. 
		for (int i = 0; i < NumberofPeople; i++) {    
            System.out.print("Person number " + (i + 1) + "'s income: ");
            income[i] = console.nextDouble();            
		}

		int count = 0;   
		double tax;
        for (int i = 0; i < NumberofPeople; i++) {
            if (income[i] < 750.00) {
            	tax=income[i]*0.01;
            	System.out.println("Person number "+(i+1)+"'s tax due is $"+tax);           
                
            	}
               else if (income[i]<2500.00){
                   	tax=income[i]*0.02+7.5;
                   	System.out.println("Person number "+(i+1)+"'s tax due is $"+tax);           
                       
                }
               else if (income[i]<5000.00){
            	    tax=income[i]*0.04+82.5;
            	   
                  	System.out.println("Person number "+(i+1)+"'s tax due is $"+tax);                                 
               }
               else if (income[i]<8000.00){
            	    tax=income[i]*0.05+142.5;
                 	System.out.println("Person number "+(i+1)+"'s tax due is $"+tax);                              
               }
               else{
            	    tax=income[i]*0.06+230.00;
                	System.out.println("Person number "+(i+1)+"'s tax due is $"+tax);           
                	count++; 
       
                   }      
            maxValueTax[i]=tax;
            }     
        //find the max value tax payer
        double max=maxValueTax[0];
        for(int i=1;i<maxValueTax.length;i++){
        	if(maxValueTax[i]>max){
        		max=maxValueTax[i];      		
        	}
        }
    //find the person who paid max tax
        int index=0;
        double largest = Integer.MIN_VALUE;
        for(int j=0;j<maxValueTax.length;j++){
        	if(maxValueTax[j]>largest){
        		largest=maxValueTax[j];
        		index=j;	
        	}  
        }
        index=index+1;
        System.out.println("\nPerson number "+index+" is paying the max value of taxes. Tax Amount of: $"+max);
	}
	
}


