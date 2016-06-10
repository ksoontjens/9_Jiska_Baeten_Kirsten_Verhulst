import java.lang.*;

	public class oef2
	{

		public static void main (String args[] )
		{
			//oef 2
			String dagen[] ={"zon","maan","dins","woens","donder","vrij","zater"};
		
			int weekdag = 0;
			for(int dag=1;dag<29;dag++)
			{
			System.out.println(dagen[weekdag] +"dag " + dag + " februari 2009");
			weekdag++;
			if (weekdag>6) weekdag=0;
			}

		}
	}