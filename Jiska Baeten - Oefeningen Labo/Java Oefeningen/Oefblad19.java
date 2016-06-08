import java.lang.*;

/**
*	@author	Jiska Baeten
*	Oef 1 	pagina 19 - Tafel van negen
*/
public class OefenProg
{

	public static void main(String args[])
	{	
		for(int x=0;x<=9;x++)
		{
			for(int y=0;y<=9;y++)
			{
				System.out.println(x + "x" + y + "=" + x*y);
			}
		}
	}

} 

import java.lang.*;

/**
*	@author	Jiska Baeten
*	Oef 2 	pagina 19 - Dagen februari 2009
*/
public class OefenProg
{

	public static void main(String args[])
	{	
		int weekdag = 0;

		for(int dag=1;dag<=29;dag++)
		{
			if(weekdag == 0) System.out.print("zon");
			if(weekdag == 1) System.out.print("maan");	
			if(weekdag == 2) System.out.print("dins");
			if(weekdag == 3) System.out.print("woens");
			if(weekdag == 4) System.out.print("donder");
			if(weekdag == 5) System.out.print("vrij");
			if(weekdag == 6) System.out.print("zater");
			weekdag++;
			if(weekdag >6) weekdag = 0;
			System.out.println("dag " + dag + " februari 2009");
		}
			
	}

} 

import java.lang.*;

/**
* 	De klasse TweedeProg is een Java applicatie.
*	@author	Jiska Baeten
*	Oef 3 	pagina 19 - Bereken PI
*/
public class OefenProg
{

	public static void main(String args[])
	{	
		double pi= 0.0;

	        for (int i =1; i<=100000;i++)
		{
			double num = (Math.pow(-1.0,i+1.0) / ((i * 2.0) - 1.0));
			pi= pi+ num;
	        }
		System.out.println(4*pi);
			
	}

} 

import java.lang.*;

/**
*	@author	Jiska Baeten
*	Oef 4 	pagina 19 - Negatief getal zonder min-operator
*/
public class OefenProg
{

	public static void main(String args[])
	{	
		int getal = 4302;
		getal = ~getal + 00000001;
		System.out.println(getal);
	}

}

import java.lang.*;

/**
*	@author	Jiska Baeten
*	Oef 5 	pagina 19 - Priemgetallen
*/
public class OefenProg
{

	public static void main(String args[])
	{	
		Boolean isPrime; //checkt of het getal een priemgetal is
	
		System.out.println("2 is een priemgetal.");

		for(int getal = 3; getal <= 100; getal++)
		{
			isPrime = true;
			for(int deler = 2; deler < getal; deler++)
			{
				if(getal%deler == 0) 
				{
					isPrime = false;
				}
				
			}
			checkPrime(isPrime, getal);
		}
	}

	private static void checkPrime(Boolean testIsPrime, int testGetal)
	{
		if(testIsPrime == true)
		{
			System.out.println(testGetal + " is een priemgetal.");
		}
	}


} 

import java.lang.*;

/**
*	@author	Jiska Baeten
*	Oef 6 	pagina 19 - Grootste getal
*/
public class OefenProg
{

	public static void main(String args[])
	{	
		int a[]={12,34,56,78,123,234,99,88};

	        int largest = 0;
	         
	      	for(int i = 0;i < a.length;i++) 
		{
			if(a[i] > largest) largest = a[i];
	        }
		System.out.println("Largest number in array is : " + largest);
	}

}  

import java.lang.*;
/**
*	@author	Jiska Baeten
*	Oef 7 	pagina 19 - sorteren met arrays
*/
	public class oef7
	{
		public static void main (String args[] )
		{
            //oef 7
            int a[]= {12,34,56,78,123,234,99,88};
            int b[] = new int[8];
            int l = 0;
            int p = 0;

            for(int i=0; i<a.length; i++)
            {
                for(int j=0; j<a.length; j++)
                {
                    if(a[j] >= l)
                    {
                        l = a[j];
                        p = j;
                    }
                }
                a[p] = 0;
                b[i] = l;
                l = 0;

            }
            
            for(int i=0; i<a.length; i++)
            {
                System.out.println(b[i]);
            }
		}
	}