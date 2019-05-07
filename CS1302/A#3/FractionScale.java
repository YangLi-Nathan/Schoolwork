import java.util.Scanner;
import java.util.regex.Pattern;

/*Student Name: Yang Li			Data:06/28/2017			Program Name:Fraction Scale
 * Description:
 * Add divide method to take another Fraction as the parameter and return 
 * a new Fraction that is the division of current Fraction and the Fraction 
 * in the parameter. (public Fraction divide(Fraction f)).*/

public class FractionScale {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This program performs the scaling operations on a fraction.");
		System.out.println("");
		
		Scanner console=new Scanner(System.in);
		/*System.out.println("Enter a numerator: ");
		String numerator=console.nextLine();
		System.out.println("Enter a denominator: ");
		String denominator=console.nextLine();*/
		
		System.out.println("Enter a fraction: ");
		String input=console.nextLine();
		
		
		if(input.length()<3){
			
			System.out.println("This is not a fraction.This Program is ended");
			
		}
		else if(input.length()==3){
			input=input.trim();//removes spaces
			String[] inputarr=input.split("/");
			String top=inputarr[0];
			String bot=inputarr[1];
			int num=Integer.parseInt(top);
			int don=Integer.parseInt(bot);
			Fraction fraction=new Fraction(num,don);
			
			System.out.println("Scale up or down (1:up, 0:down): ");
			int scale=console.nextInt();

			System.out.println("Enter a scale factor: ");
			int scaleFactor=console.nextInt();
			
			Fraction newfraction=(fraction.scale(fraction, scale, scaleFactor));
			
			
			newfraction.print();
		}
		
		else if(input.length()>3){
		input=input.trim();//removes spaces
		Pattern splitString=Pattern.compile("\\s+");//removes spaces
		String[] inputarr=input.split("\\s+"+splitString+"\\s+"+"/"+"\\s+"+splitString+"\\s+");

		String top=inputarr[0];
		String bot=inputarr[1];

		
		
		
		int num=Integer.parseInt(top);
		int don=Integer.parseInt(bot);
		
		
		Fraction fraction=new Fraction(num,don);
		
		System.out.println("Scale up or down (1:up, 0:down): ");
		int scale=console.nextInt();

		System.out.println("Enter a scale factor: ");
		int scaleFactor=console.nextInt();
		
		Fraction newfraction=(fraction.scale(fraction, scale, scaleFactor));
		
		
		newfraction.print();
	
		
	}
		

}
}