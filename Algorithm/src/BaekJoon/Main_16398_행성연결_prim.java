package BaekJoon;
import java.util.*;
import java.io.*;

public class Main_16398_행성연결_prim {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		int[][] arr=new int[N+1][N+1];
		boolean[] visited=new boolean[N+1];
		
		int[] minEdge=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
			minEdge[i]=Integer.MAX_VALUE;
		}
		
		long result=0;
		minEdge[1]=0;
		
		for(int i=1;i<=N;i++) {
			int min=Integer.MAX_VALUE;
			int minV=0;
			
			for(int j=1;j<=N;j++) {
				if(!visited[j]&&minEdge[j]<min) {
					min=minEdge[j];
					minV=j;
				}
			}
			
			result+=min;
			visited[minV]=true;
			
			for(int j=1;j<=N;j++) {
				if(!visited[j]&& arr[minV][j]!=0 && minEdge[j]>arr[minV][j]) {
					minEdge[j]=arr[minV][j];
				}
			}
		}
		
		System.out.println(result);
		
	}

}
