import java.lang.*;

	public class eersteProg
	{
		public static void main (String args[] )
		{
        Werknemer jan;
        jan = new Werknemer("Jan","Janssens",1,35.0f);
        Werknemer herman = new Werknemer("Herman","Hermans",2,35.0f);
        Werknemer staf = new Werknemer("Staf","Stevensen",3,35.0f);
        Werknemer piet = new Werknemer("Piet","Pieters",3,35.0f);
                
        jan.salarisVerhogen(10);
        herman.salarisVerhogen(10);
            
        System.out.println( "Jan verdient " + jan.salaris);
        System.out.println( "Herman verdient " + herman.salaris);
        System.out.println( "Staf verdient " + staf.salaris);
        System.out.println( "Piet verdient " + piet.salaris);
            
            
        PartTimeWerknemer jef = new PartTimeWerknemer("Jef","Jefke",1,35.0f,24);
        PartTimeWerknemer jul = new PartTimeWerknemer("Jul","Julien",1,35.0f,26);
            
        jef.salarisVerhogen(10);
            
        System.out.println( "Jef verdient " + jef.salaris);
        System.out.println( "Jul verdient " + jul.salaris);
        
        System.out.println( "RSZ Jan: "+ jan.getRSZ());
        jan.setRSZ(22);
        System.out.println( "RSZ Jan: "+ jan.getRSZ());
        
        System.out.println( "RSZ Jef: "+ jef.getRSZ());
        jef.setRSZ(25);
        System.out.println( "RSZ Jef: "+ jef.getRSZ());
        
        StudentWerknemer kim = new StudentWerknemer("Kim","Kimmel",1,25.0f,20);
        System.out.println( "RSZ Kim: "+ kim.getRSZ());

            
        Betaalbaar betDingen[] = new Betaalbaar[4];
            betDingen[0]=jan;
            betDingen[1]=jef;
            betDingen[2]=kim;
            betDingen[3]= new Factuur(1,1025.10f);
            
            for(int i = 0; i <betDingen.length; i++)
            {
                betDingen[i].betaal();
            }
            
		}
	}