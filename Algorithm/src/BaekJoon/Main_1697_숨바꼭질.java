package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1697_숨바꼭질 {
	
	static boolean[] v;
	static int N,K,ans;
	
	public static void bfs(int n) {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {n,0});
		v[n]=true;
		
		while(!q.isEmpty()) {
			int[] curr=q.poll();
			
			if(curr[0]==K) {
				ans=curr[1];
				break;
			}
			
			else {
				if(curr[0]+1>=0&& curr[0]+1<=100000 && !v[curr[0]+1]) {
					q.offer(new int[] {curr[0]+1,curr[1]+1});
					v[curr[0]+1]=true;
				}
				if(curr[0]-1>=0 && curr[0]-1<=100000 && !v[curr[0]-1]) {
					q.offer(new int[] {curr[0]-1,curr[1]+1});
					v[curr[0]-1]=true;
				}
				if(curr[0]*2>=0 && curr[0]*2<=100000 && !v[curr[0]*2]) {
					q.offer(new int[] {curr[0]*2,curr[1]+1});
					v[curr[0]*2]=true;
				}
			}
			
			
			
		}
	}
	
	

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		v=new boolean[100001];
		
		bfs(N);
		
		System.out.println(ans);
	}

}
