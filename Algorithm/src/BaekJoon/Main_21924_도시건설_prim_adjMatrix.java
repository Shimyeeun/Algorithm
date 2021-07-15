package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_21924_도시건설_prim_adjMatrix {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		boolean[] visited=new boolean[N+1];
		int[] minEdge=new int[N+1];
		int[][] arr=new int[N+1][N+1];
		long sum=0;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			sum+=c;
			arr[a][b]=c;
			arr[b][a]=c;
		}
		
		for(int i=1;i<=N;i++) {
			minEdge[i]=Integer.MAX_VALUE;
		}
				
		long result=0;
		int cnt=0;
		minEdge[1]=0;
		for(int i=1;i<=N;i++) {
			int min=Integer.MAX_VALUE;
			int minV=1;
			
			for(int j=1;j<=N;j++) {
				if(!visited[j]&&minEdge[j]<min) {
					min=minEdge[j];
					minV=j;
				}
			}
			
			result+=min;
			visited[minV]=true;
			cnt++;
			
			for(int j=1;j<=N;j++) {
				if(!visited[j]&&arr[minV][j]!=0 && minEdge[j]>arr[minV][j]) {
					minEdge[j]=arr[minV][j];
				}
			}
		}
		if(result>Integer.MAX_VALUE) {
			System.out.println("-1");
		}
		else {
			System.out.println(sum-result);
		}

		
	}

}
