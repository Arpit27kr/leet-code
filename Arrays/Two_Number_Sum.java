/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.




*/
import java.util.*;
public class Two_Number_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int temp=input.nextInt();
		int y=input.nextInt();
		int[] nums=new int[y];
		for(int i=0;i<nums.length;i++)
		{
			 nums[i]=input.nextInt();
			 
		}
		 twosum(nums,temp);
		

	}

	private static void twosum(int nums[],int temp)
	{
		int n=nums.length;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(nums[i]+nums[j]==temp)
				{
					System.out.print(i+ ",");
					System.out.print(j);
				}
			}
		}
		
	}
	
}
