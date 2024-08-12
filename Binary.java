package binarysearch;

import java.util.Arrays;
import java.util.TreeSet;

public class Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	Arrays arr = {50,80,30,10,20};/*	TreeSet<Arrays> t=new TreeSet<Arrays>();
		t.add(arr);
	//	Arrays.sort(arr);
		System.out.println("the array is:" +arr);
	////	int len=arr.length;
	//	int diff=arr[len-1]-arr[0];
		//System.out.println(diff);
*/
		/*int n =61;
		int count = 0;
		for(int i=2;i<n;i++)
		{
			if(n%i==0)
			{
				count++;
			}}
			if(count>0)
				System.out.println("the nmuber is not prime no:"+n);
			else {
				System.out.println("the nmuber is  a prime no:"+n);
			
				
		}*/
		int fact = 1;
		int n=2;
		for (int i=1;i<=n;i++)
		{
			fact=fact*i;
		}
		System.out.println( "the fact of number is:"+fact );
		
		
	}

}