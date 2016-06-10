import java.lang.*;

	public class oef6
	{
		public static void main (String args[] )
		{
            //oef 6
            int a[]= {12,34,56,78,123,234,99,88};
            int l = 0;
            
            
            for(int i=0; i<a.length; i++)
            {
                if(a[i] >= l)
                {
                    l = a[i];
                }
            }
            
            System.out.println(l);
		}
	}