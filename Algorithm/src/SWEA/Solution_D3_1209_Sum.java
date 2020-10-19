package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D3_1209_Sum {
	public static int csum,rsum,dsum,cmax,rmax,dmax,arr[][];
	public static void csum()
	{
		cmax=0;
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<100;j++)
			{
				csum=csum+arr[i][j];
			}
			if(csum>=cmax)
				cmax=csum;
			csum=0;
		}
	}
	public static void rsum()
	{
		rmax=0;
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<100;j++)
			{
				rsum=rsum+arr[j][i];
			}
			if(rsum>=rmax)
				rmax=rsum;
			rsum=0;
		}
	}
	
	public static void dsum()
	{
		dmax=0;
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<100;j++)
			{
				if(i==j)
				{
					dsum+=arr[i][j];
				}
				
				else if(i+j==99)
				{
					dsum+=arr[i][j];
				}
			}
			if(dsum>=dmax)
				dmax=dsum;
			dsum=0;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1209.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++)
		{
			int n=Integer.parseInt(br.readLine());
			arr=new int[100][100];
			csum=0;
			rsum=0;
			dsum=0;
			
			for(int i=0;i<100;i++)
			{
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++)
				{
					arr[i][j]=Integer.parseInt(st.nextToken());					
				}
			}
			
			csum();
			rsum();
			dsum();
			
			if(cmax>=rmax&&cmax>=dmax)
			{
				System.out.println("#"+n+" "+cmax);
			}
			else if(rmax>=cmax&&rmax>=dmax)
			{
				System.out.println("#"+n+" "+rmax);
			}
			else if(dmax>=cmax&&dmax>=rmax)
			{
				System.out.println("#"+n+" "+dmax);
			}
			
			
		}
		
		

	}

}
