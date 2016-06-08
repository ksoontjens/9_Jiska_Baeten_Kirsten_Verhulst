//oef 10 pagina 31
public class Faktuur implements Betaalbaar
{
    public int faktuurNr;
    public float faktuurBedrag;
    
    public Faktuur(int nr, float bedrag) //door dit maakt java zelf geen constructor
    {
        this.faktuurNr = nr;
        this.faktuurBedrag = bedrag;
    }
    
    public void betaal()
    {
        System.out.println("Betaal de faktuur " + faktuurNr + " voor een bedrag van " + faktuurBedrag);
    }

}