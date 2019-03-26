
import java.util.*;

class RodCuttingProblem {
    public static void main(String args[] ) throws Exception {
    	
    	//Initialising the Scanner object
        Scanner sc = new Scanner(System.in);
        //Taking input for number of test cases
        int t = sc.nextInt();             
    
        int count, f;
        for(int i=0;i<t;i++)
        {
        	
            int n= sc.nextInt();
            count=0;
            f=0;
            if(n!=1)
            {
            	while(n!=0)
            	{
                
            		if(n%2==0)
            			f=1;
                
            		if(n==1 && f==1)
            			count--;
                
            		n=n/2;
                
            		if(n!=1)
            			count++;
            	}
            }
            System.out.println(count);
        }
        sc.close();
    }
}
