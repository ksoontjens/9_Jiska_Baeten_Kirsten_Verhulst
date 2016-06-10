import java.lang.*;

public class OefenProg
{

	public static void main(String args[])
	{	
        //oef 5
		Boolean isPrime; 

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
