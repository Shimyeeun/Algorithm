package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_18126_너구리구구 {

	static int N;
	static int[][] arr;
	static boolean[] v;
	static long[] dist;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N+1][N+1];
		v=new boolean[N+1];
		dist=new long[N+1];
		for(int i=0;i<N-1;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			arr[a][b]=c;
			arr[b][a]=c;
		}
		
		dfs(1);
		long ans=0;
		for(int i=1;i<dist.length;i++) {
			if(ans<dist[i]) {
				ans=dist[i];
			}
		}
		System.out.println(ans);
		
 	}
	
	public static void dfs(int i) {
		if(v[i]) {
			return;
		}
		else {
			v[i]=true;
			
			for(int j=1;j<=N;j++) {
				if(!v[j]&&arr[i][j]!=0) {
					dist[j]=dist[i]+arr[i][j];
					dfs(j);
				}
			}
			
		}
	}

}
