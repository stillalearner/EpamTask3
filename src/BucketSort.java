import java.util.*;
import java.io.*;
class BucketSort{
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
            list.add(sc.nextInt());
        List<List<Integer> > bucket=new ArrayList<>();
        for(int i=0;i<k;i++)
            bucket.add(new ArrayList<>());
       for(int i=0;i<n;i++)
       {
           int bucket_no=list.get(i)%k;
           List<Integer> bucket_list=bucket.get(bucket_no);
           bucket_list.add(list.get(i));
           bucket.set(bucket_no,bucket_list);
       }
       for(int i=0;i<k;i++)
       {
          Collections.sort(bucket.get(i)); 
       }
       for(int i=k-1;i>=0;i--)
       {
           if(bucket.size()>0)
           {
             for(int j:bucket.get(i))
                 System.out.print(j+" ");
           }
       }
        System.out.println();
    }
    }