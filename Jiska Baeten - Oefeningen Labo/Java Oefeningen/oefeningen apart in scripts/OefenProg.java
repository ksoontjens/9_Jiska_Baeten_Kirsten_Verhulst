import java.lang.*;

/**
*	@author	Jiska Baeten
*	Oef 9	pagina 31 - methodes testen
*/
public class OefenProg
{

	public static void main(String args[])
	{	
        Werknemer Jef = new Werknemer("Jef", "Biek",1, 10000);
        Werknemer Mik = new Werknemer("Mik", "No",2, 10000);
        Werknemer Kiko = new Werknemer("Kiko", "Mop",3, 10000);
        Werknemer Laure = new Werknemer("Laure", "Leirs",5, 100000);
        PartTimeWerknemer Ben = new PartTimeWerknemer("Ben", "Biek",10, 10000, 24);
        PartTimeWerknemer Pop = new PartTimeWerknemer("Pop", "Po",15, 10000, 77);
        StudentWerknemer Miho = new StudentWerknemer("Miho", "Azuki", 55, 10000, 50);
        Faktuur twintig = new Faktuur(20, 500.50f);
        Faktuur dertig = new Faktuur(30, 10.10f);
        
        Jef.salarisVerhogen(10);
        Mik.salarisVerhogen(10);
        Ben.salarisVerhogen(10);
        
        System.out.println("Jef verdient " + Jef.salaris);
        System.out.println("Mik verdient " + Mik.salaris);
        System.out.println("Kiko verdient " + Kiko.salaris);
        System.out.println("Laure verdient " + Laure.salaris);
        System.out.println();
           
        
        System.out.println("Ben verdient " + Ben.salaris);
        System.out.println("Pop verdient " + Pop.salaris);
        System.out.println();
        
        Jef.setRSZ(33);
        Ben.setRSZ(50);

        System.out.println("Jef (werknemer) RSZ: " +  Jef.getRSZ());
        System.out.println("Ben (parttimewerknemer) RSZ: " +  Ben.getRSZ());
        System.out.println("Miho (Studentwerknemer) RSZ: " +  Miho.getRSZ());
        System.out.println();
        
        Betaalbaar arrBetalen[] = {Jef, Ben, Miho, twintig, dertig};
        
        for (int i=0; i< arrBetalen.length;i++)
        {
            arrBetalen[i].betaal();
        }    
	}
} 