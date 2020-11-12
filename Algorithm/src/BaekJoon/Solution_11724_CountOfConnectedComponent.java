package BaekJoon;
import java.util.*;
import java.io.*;
public class Solution_11724_CountOfConnectedComponent {
	public static int n;
	public static boolean[] v;
	public static void dfs(int i, int[][] arr) {
		v[i]=true;
		
		for(int j=0;j<n;j++) {
			if(arr[i][j]==1&&v[j]==false) {
				v[i]=true;
				dfs(j,arr);
			}
		}
	}
	public static void bfs(int i, int[][] arr) {
		v[i]=true;
		Queue<Integer> q=new LinkedList<>();
		q.offer(i+1);
		
		while(!q.isEmpty()) {
			
			int now=q.poll();
			
			for(int j=0;j<n;j++) {
				if(arr[now-1][j]==1 && v[j]==false) {
					v[j]=true;
					q.offer(j+1);
				}
			}
		}		
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[][] arr=new int[n][n];
		v=new boolean[n];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			arr[a-1][b-1]=1;
			arr[b-1][a-1]=1;
		}
		int cnt=0;
		for(int i=0;i<n;i++) {
			if(v[i]==false) {
				cnt++;
				dfs(i,arr);
				//bfs(i,arr);
			}
		}
		
		System.out.println(cnt);

	}

}
