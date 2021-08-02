package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_2644_촌수계산 {

	static int n;
	static int[][] arr;
	static int[] ans;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		
		int m=Integer.parseInt(br.readLine());
		arr=new int[n+1][n+1];
		v=new boolean[n+1];
		ans=new int[n+1];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			arr[a][b]=1;
			arr[b][a]=1;
		}
		
		bfs(x);
		if(ans[y]==0) System.out.println("-1");
		else System.out.println(ans[y]);
	}

	public static void bfs(int x) {
		Queue<Integer> q=new LinkedList<>();
		v[x]=true;
		q.offer(x);
		while(!q.isEmpty()) {
			int curr=q.poll();
			for(int i=1;i<=n;i++) {
				if(arr[curr][i]==1&&!v[i]) {
					v[i]=true;
					ans[i]=ans[curr]+1;
					q.offer(i);
				}
			}
		}
	}
	
	
}
