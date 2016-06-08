import java.lang.*;

/**
*	@author	Jiska Baeten
*	Oef 1 + 2 + 3 + 4 + 6 +10	pagina 31
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


//oef 5 + 9 pagina 31
public class Werknemer implements Betaalbaar  //moet je in ander programma oproepen in main methode
{
    public String voornaam;
    public String achternaam;
    public int werknemerNummer;
    protected float salaris;
    private float RSZpercentage = 33f;
    
    public Werknemer(String voornaam, String achternaam, int wNummer, float salaris) //door dit maakt java zelf geen constructor
    {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        werknemerNummer = wNummer;
        this.salaris = salaris;
    }

    public void salarisVerhogen(int percentage)
    {
        float verhogingsfactor = (float)percentage/100;
        salaris += salaris * verhogingsfactor;
    }
    
    public float getSalaris()
    {
        return salaris;
    }
    
    public void setRSZ(float RSZ)
    {
        RSZpercentage = RSZ;
    }
    
    public float getRSZ()
    {
        return RSZpercentage;
    }
    
    public void betaal()
    {
        System.out.println("Betaal het salaris van " + salaris + " aan " + voornaam);
    }
}

//oef 7 pagina 31 - pas RSZ aan voor student
public class StudentWerknemer  extends PartTimeWerknemer
{
    
    public StudentWerknemer(String voornaam, String achternaam, int nr, float sal, int urengw)
    {
        super(voornaam, achternaam, nr, sal, urengw); //moet op de eerste regel van contructor staan
        setRSZ(5);
    }
}

//oef 8 pagina 31
public interface Betaalbaar{ //==> is interface ==> kan je geen objecten van maken
    public abstract void betaal();
}