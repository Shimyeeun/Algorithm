package BaekJoon;
import java.util.*;
import java.io.*;

public class Main_15649_NAndM1 {
	public static int n,m,d[],a[];
	public static boolean[] v;
	public static void permcomb(int start,int count) {
		if(count==m)
		{
			for(int i=0;i<m;i++)
			{
				System.out.print(a[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<n;i++)
		{
			if(v[i]==false)
			{
				v[i]=true;
				a[count]=d[i];
				permcomb(i,count+1);
				v[i]=false;				
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		v=new boolean[n];
		d=new int[n];
		for(int i=0;i<n;i++)
		{
			d[i]=i+1;
		}
		a=new int[m];
		permcomb(0,0);
		
		
		
		
	}

}
