package BaekJoon;
import java.util.*;
import java.io.*;

public class Solution_15657_NAndM8 {
	public static int n,m,d[],a[];
	public static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void permcomb(int start,int count) throws Exception {
		if(count==m)
		{
			for(int i=0;i<m;i++)
			{
				bw.write(a[i]+" ");
			}
			bw.newLine();
			return;
		}
		
		for(int i=start;i<n;i++)
		{
			a[count]=d[i];
			permcomb(i,count+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		d=new int[n];
		a=new int[m];
		
		StringTokenizer s=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++)
		{
			d[i]=Integer.parseInt(s.nextToken());
		}
		
		Arrays.sort(d);
		permcomb(0,0);
		bw.flush();	

	}

}
