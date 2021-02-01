package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1260_DFSAndBFS {
	public static int n;
	public static boolean[] visit;
	public static void dfs(int i, int[][] arr) {
		visit[i]=true;
		for(int j=0;j<n;j++) {
			if(visit[j]==false) {
				if(arr[i][j]==1) {
					visit[j]=true;
					System.out.print(j+1+" ");
					dfs(j,arr);
				}				
			}
		}
	}
	
	public static void bfs(int i,int[][] arr) {
		visit[i]=true;
		Queue<Integer> q=new LinkedList<>();	
		q.offer(i+1);
	
		while(!q.isEmpty()) {
			
			int v=q.poll();
			System.out.print(v+" ");
			for(int j=0;j<n;j++) {
				if(arr[v-1][j]==1&&visit[j]==false) {
					q.offer(j+1);
					visit[j]=true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int v=Integer.parseInt(st.nextToken());
		int[][] arr=new int[n][n];
		visit=new boolean[n];
		for(int i=0;i<m;i++) {
			st= new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[a-1][b-1]=1;
			arr[b-1][a-1]=1;
		}
		System.out.print(v+" ");
		dfs(v-1,arr);
		System.out.println();
		visit=new boolean[n];
		bfs(v-1,arr);
		
	}

}
