//pagina 31
public class Werknemer implements Betaalbaar //moet je in ander programma oproepen in main methode
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
        if (RSZ > 100) 
        {
            System.out.println("RSZ te hoog.");
            RSZpercentage = 0;
        }
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