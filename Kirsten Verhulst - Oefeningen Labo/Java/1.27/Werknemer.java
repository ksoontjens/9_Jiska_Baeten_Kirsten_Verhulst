public class Werknemer implements Betaalbaar {
    public String voornaam;
    public String achternaam;
    public int werknemerNummer;
    protected float salaris;
    private float RSZpercentage;
    
    public Werknemer(String voornaam, String achternaam, int wNummer,float salaris)
    {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        werknemerNummer = wNummer;
        this.salaris = salaris;
        RSZpercentage = 33.0f;
    }
    
    public void salarisVerhogen (int perc)
    {
        salaris+=salaris*(perc/100.0);
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
        System.out.println("Betaal het salaris van " + salaris + " aan de werknemer " + voornaam);
    }
}