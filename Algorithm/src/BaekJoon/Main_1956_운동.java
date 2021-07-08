package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1956_운동 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		int INF=Integer.MAX_VALUE;
		int[][] arr=new int[V+1][V+1];
		
		for(int i=1;i<=V;i++) {
			for(int j=1;j<=V;j++) {
				arr[i][j]=INF;
			}
		}
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			arr[a][b]=c;
			
		}
		
		for(int k=1;k<=V;k++) {
			for(int i=1;i<=V;i++) {
				for(int j=1;j<=V;j++) {
					if(arr[i][k]!=INF && arr[k][j]!=INF) {
						arr[i][j]=Math.min(arr[i][k]+arr[k][j], arr[i][j]);
					}
				}
			}
		}
		
		int min=INF;
		for(int i=1;i<=V;i++) {
			for(int j=1;j<=V;j++) {
				if(i==j) {
					if(arr[i][j]<min) {
						min=arr[i][j];
					}
				}
			}
		}
		
		if(Math.abs(min)==INF) {
			System.out.println("-1");
		}
		else {
			System.out.println(min);			
		}
		
//		for(int i=1;i<=V;i++) {
//			for(int j=1;j<=V;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
		
	}

}
