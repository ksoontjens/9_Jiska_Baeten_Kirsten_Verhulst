import java.lang.*;

	public class oef7
	{
		public static void main (String args[] )
		{
            //oef 7
            int a[]= {12,34,56,78,123,234,99,88};
            int b[] = new int[8];
            int l = 0;
            int p = 0;

            for(int i=0; i<a.length; i++)
            {
                for(int j=0; j<a.length; j++)
                {
                    if(a[j] >= l)
                    {
                        l = a[j];
                        p = j;
                    }
                }
                a[p] = 0;
                b[i] = l;
                l = 0;
            }
            
            for(int i=0; i<a.length; i++)
            {
                System.out.println(b[i]);
            }
		}
	}
