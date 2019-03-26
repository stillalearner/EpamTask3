import java.util.*;
public class HelpOutTheIndianArmy {
	
    public static void main(String args[]) {
       	
    	Scanner sc = new Scanner(System.in);
		
    	int n  =sc.nextInt();
		int s = sc.nextInt();
		int e = sc.nextInt();
		
		TreeMap<Integer,Integer> t1= new TreeMap<Integer,Integer>();
				
		for(int i=0; i<n; i++)  
		{
			int x = sc.nextInt();
			int p = sc.nextInt();
			t1.put(x-p,x+p);
		}
		
		TreeMap<Integer,Integer> t2= new TreeMap<Integer,Integer>();
		
		List<Integer> l1= new ArrayList<Integer>(t1.keySet());
		List<Integer> l2= new ArrayList<Integer>(t1.values());
    	int k = l1.get(0);
    	
		int v = l2.get(0);
		
		for(int i=1;i<t1.size();i++)
		{
			if(l1.get(i)<=v)
				v = Math.max(v,l2.get(i));
			else
			{
				t2.put(k,v);
				k = l1.get(i);
				v = l2.get(i);
			}			
		}
		
		t2.put(k,v);
	 	int i,res=0;
	 	//Calculating result now
	 	l1= new ArrayList<Integer>(t2.keySet());
	 	l2= new ArrayList<Integer>(t2.values());
	 	
		for(i=0;i<l1.size();i++)
		{
			if(s>=e)
			{
				s=e;
				break;
			}
			
			if(l1.get(i)<=s && s<=l2.get(i))
				s=l2.get(i);
			else if(s<=l1.get(i) && e>=l2.get(i))
			{
				res+=l1.get(i)-s;
				s=l2.get(i);
				
			}
			else if(s<=l1.get(i) && e>=l1.get(i) &&  e<=l2.get(i))
			{
				res+=l1.get(i)-s;
				s=e;
			}
			else if(s<=l1.get(i) && e<=l1.get(i))
			{
				res+=e-s;
				s=e;
			}
		}
		
		if(s<e)
			res+=e-s;
		System.out.println(res);
	}
}























/*
 import java.io.*;
 
import java.util.*;

public class HelpOutTheIndianArmy {
	
	 
    public static void main(String args[]) throws Exception {
 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int e = sc.nextInt();
        int result=0;
        
        int x,p;
        
        HashMap<Integer,Integer> t= new HashMap<>();
        
        for(int i=0; i<n; i++)
        {
          x= sc.nextInt();
          p= sc. nextInt();
          int a= x-p;
          int b= x+p;
          if(a < s && b>=s)
          {
        	  a=s;
          }
          if(b>e && a<=e)
          {
        	  b=e;
          }
          t.put(a, b);
        }
       
       for(Map.Entry<Integer, Integer> entry: t.entrySet())
       {
    	 Map.Entry<Integer,Integer> nxt= t.higherEntry(entry.getKey());
    	 Map.Entry<Integer,Integer> prev= t.lowerEntry(entry.getKey());
    	 if(prev!=null)
    	 {
    		 if(entry.getKey()>=prev.getKey() && entry.getValue()<=prev.getValue())
    			 continue;
    	 }
    		 if(nxt!=null)
    		 {
    			 if(nxt.getKey()>=entry.getKey() && nxt.getValue()<=entry.getValue())
        		 {
        			 result= result+ (entry.getValue()-entry.getKey()+1);
        			 continue;
        		 }
    			 if(nxt.getKey()<=entry.getValue() && nxt.getValue()>entry.getValue())
        		 {
        			 result= result+ (nxt.getValue()-entry.getKey()+1);
        			 
        		 }
        		 if(nxt.getKey()>entry.getValue())
        		 {
        			 result= result+(entry.getValue()-entry.getKey()+1);
        		 }
    		 }
    		 
    	 }
    	
    	  
    	   
    			   
       
       
      for(Map.Entry<Integer, Integer> entry: t.entrySet())
       {
    	   System.out.println(entry);
    			   
       }
       
      result= e-s+1 -result;
      System.out.println(result);
       
    }
}
*/
