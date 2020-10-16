package BaekJoon;
import java.io.*;
import java.util.*;

public class Solution_15655_NAndM6 {
	public static int n,m,d[],a[];
	public static boolean[] v;
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
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		v=new boolean[n];
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
