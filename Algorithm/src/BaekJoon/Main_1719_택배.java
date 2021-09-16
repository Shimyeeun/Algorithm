package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1719_택배 {


	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int INF=Integer.MAX_VALUE;
		int[][] arr=new int[n+1][n+1];
		int[][] ans=new int[n+1][n+1];
		
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j) {
					arr[i][j]=0;
				}
				else {
					arr[i][j]=INF;
				}
			}
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			arr[a][b]=c;
			arr[b][a]=c;
			
			ans[a][b]=b;
			ans[b][a]=a;
			
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(arr[i][k]!=INF && arr[k][j]!=INF) {
						if(arr[i][j]>arr[i][k]+arr[k][j]) {
							arr[i][j]=arr[i][k]+arr[k][j];
							ans[i][j]=ans[i][k];
						}
						
					}
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j) {
					sb.append("- ");
				}
				else {
					sb.append(ans[i][j]+" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
