package BaekJoon;
import java.io.*;
import java.util.*;

public class Main_15652_NAndM4 {
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
		
		for(int i=0;i<n;i++)
		{
			d[i]=i+1;
		}
		
		permcomb(0,0);
		
		bw.flush();
	}

}
