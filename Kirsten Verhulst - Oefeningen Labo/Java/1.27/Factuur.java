public class Factuur implements Betaalbaar
{
    public int factuurNr;
    public float factuurBedrag;
    
    public Factuur(int fctnr, float fbd)
    {
        factuurNr= fctnr;
        factuurBedrag = fbd;
    }
    
    public void betaal()
    {
        System.out.println("Betaal het faktuur " + factuurNr + " voor het bedrag van " + factuurBedrag);
    }

}