package com.ubuy.checkout;

public class Test 
{
	public static void main(String[] args)
	{
		int[] a = new int[20];
		int[] desc = new int[20];
		int no = 19756248;
		int cNo = 19756248;
		for(int i=0;cNo%10!=cNo;i++)
		{
			a[i] =  cNo % 10;
			cNo = cNo / 10;
		}
		
//		for(int i=0;i<desc.length;i++)
//		{
//			System.out.println(a[i]);
//		}
		int lN = a[0];
		for(int i=0;i<a.length;i++)
		{
			int p=0;
			for(int j=0;j<a.length;j++)
			{
				if(lN<a[j])
				{
					lN = a[j];
					p=j;
				}
			}
			a[p] = 0;
			desc[i] = lN;
		}
		for(int i=0;i<desc.length;i++)
		{
			System.out.println(desc[i]);
		}
	}
}
