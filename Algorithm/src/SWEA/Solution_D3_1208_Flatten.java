package SWEA;
import java.util.*;
import java.io.*;

public class Solution_D3_1208_Flatten {
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_1208.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++)
		{
			int max=0,min=101,res=10;
			int maxi=0,mini=0;
			int dump=Integer.parseInt(br.readLine());
			int[] arr=new int[100];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<100;i++)
			{
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			while(dump>=0)
			{
				max=0;
				min=101;
				for(int i=0;i<100;i++)
				{					
					if(arr[i]>=max)
					{
						max=arr[i];
						maxi=i;
					}
					if(arr[i]<=min)
					{
						min=arr[i];
						mini=i;
					}
					
				}
				
				arr[maxi]=arr[maxi]-1;
				arr[mini]=arr[mini]+1;
				
				res=max-min;
				
				if(res<=1)
				{
					break;
				}
				
				dump--;						
				
			}
			
			
			System.out.println("#"+t+" "+res);
		}
		
	

	}

}
