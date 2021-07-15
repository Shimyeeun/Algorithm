package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_11404_플로이드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		int[][] arr=new int[n+1][n+1];
		int INF=Integer.MAX_VALUE;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				arr[i][j]=INF;
				if(i==j) {
					arr[i][j]=0;
				}
			}
		}
		
		for(int i=0;i<m;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			if(arr[a][b]!=0) {
				arr[a][b]=Math.min(arr[a][b], c);
			}
			else {
				arr[a][b]=c;
			}
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(arr[i][k]!=INF && arr[k][j]!=INF ) {
						arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
					}
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(arr[i][j]==INF) {
					System.out.print("0 ");
				}
				else {
					System.out.print(arr[i][j]+" ");					
				}
			}
			System.out.println();
		}
	}

}
