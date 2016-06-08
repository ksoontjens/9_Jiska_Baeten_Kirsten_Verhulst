import java.lang.*;

/*
* 	De klasse TweedeProg is een Java applicatie.
*	@author	Jiska Baeten
*	@version 1.00
*/
public class TweedeProg
{
	/*
	*	Hieronder staat de main functie die de start van je programma is.
	*	@param 	args	Dit is een array van string waarmee parameters kunnen meeggegeven worden van de commandline.
	*/
	public static void main(String args[])
	{	
		drukaf(100);
	}

	private static void drukaf(int m)
	{
	//	@param	m	Dit is het aantal keer dat de lus moet uitgevoerd worden.
		int a;
		for(a =0; a < m; a++)
		{
			System.out.println(a);
		}
	}
} 