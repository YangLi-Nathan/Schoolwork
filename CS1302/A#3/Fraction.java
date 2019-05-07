import java.util.Scanner;
/*Student Name: Yang Li			Data:06/28/2017			Program Name:Fraction Scale
 * Description:
 * Add divide method to take another Fraction as the parameter and return 
 * a new Fraction that is the division of current Fraction and the Fraction 
 * in the parameter. (public Fraction divide(Fraction f)).*/
public class Fraction {
	  // Instance variables
	  private int numerator;    // Numerator of fraction
	  private int denominator;  // Denominator of fraction
	  private int scale;
	  private int ScaleFactor;
	  
	  // Constructors
	  public Fraction(int num, int denom) {
	    numerator = num;
	    denominator = denom;
	  }

	  // Instance methods
	  public int getNumerator() {
	    return numerator;
	  }

	  public int getDenominator() {
	    return denominator;
	  }

	  public Fraction add(Fraction f) {
	    int num = numerator * f.denominator + f.numerator * denominator;
	    int denom = denominator * f.denominator;
	    return new Fraction(num, denom);
	    
	    
	  }

	  public Fraction divide(Fraction ScaleFactor){
		  int num=numerator*ScaleFactor.denominator;
		  int den=denominator*ScaleFactor.numerator;
		  return new Fraction(num,den);
	  }
	  
	  public Fraction scaleup(Fraction frac,int ScaleFactor){
		  int num=ScaleFactor*frac.numerator;
		  int denom=frac.denominator;
		  return new Fraction(num, denom);
		  
	  }
	  public Fraction scaledown(Fraction frac,int ScaleFactor){
		  if(ScaleFactor==0){
			  System.out.println("Error: the scale factor is 0.");
		  return null;
		  }
		  else{
		  int num=frac.numerator;
		  int denom=ScaleFactor*frac.denominator;
		  return new Fraction(num, denom);
		  }
		  
	  }
	  
	  public Fraction scale(Fraction frac,int flag,int ScaleFactor){
		  if(ScaleFactor==0){
			  System.out.println("Error: the scale factor is 0.");
		  		 return null;
		  }
		  	else{
			  if(flag==1){
				  return frac.scaleup(frac, ScaleFactor);
			  }
			  if(flag==0){
				 return frac.scaledown(frac, ScaleFactor);
				   }
			  else{
				  return null;
			  }
		  }
	  }
	  void print(){
			System.out.println("Scaled fraction is:  "+numerator+" / "+denominator);
		}
	
	  }



