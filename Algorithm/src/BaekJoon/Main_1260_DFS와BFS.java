package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1260_DFS와BFS {
	static int N,M,V;
	static int[][] arr;
	static boolean[] v;
	static StringBuilder sb;
	
	public static void dfs(int i) {
		if(v[i]==true) return;
		else {
			v[i]=true;
			sb.append(i+" ");
			for(int j=1;j<=N;j++) {
				if(arr[i][j]==1) {
					dfs(j);
				}
			}
			
		}
	}
	
	public static void bfs(int i) {
		Queue<Integer> qu=new LinkedList<>();
		qu.offer(i);
		v[i]=true;
		while(!qu.isEmpty()) {
			int k=qu.poll();
			sb.append(k+" ");
			
			for(int j=1;j<=N;j++) {
				if(arr[k][j]==1&&v[j]==false) {
					qu.offer(j);
					v[j]=true;
				}
			}

		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		sb=new StringBuilder();
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		V=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1][N+1];
		v=new boolean[N+1];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			arr[a][b]=1;
			arr[b][a]=1;
		}
		
		dfs(V);
		sb.append("\n");
		v=new boolean[N+1];
		bfs(V);
		System.out.println(sb.toString());
	}

}
