package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_13549_숨바꼭질3 {

	static int N,K,min=Integer.MAX_VALUE;
	static boolean[] v;
	
	static class Point{
		int X,time;
		
		public Point(int X,int time) {
			this.X=X;
			this.time=time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		v=new boolean[100001];
		bfs(N);
		System.out.println(min);
	}
	
	public static void bfs(int x) {
		Queue<Point> q=new LinkedList<>();
		q.offer(new Point(x,0));
		
		while(!q.isEmpty()) {
			Point curr=q.poll();
			v[curr.X]=true;
			
			if(curr.X==K) {
				min=Math.min(min, curr.time);
			}
			
			if(curr.X*2<=100000 && !v[curr.X*2]) {
				q.offer(new Point(curr.X*2,curr.time));
			}
			
			if(curr.X+1<=100000 && !v[curr.X+1]) {
				q.offer(new Point(curr.X+1,curr.time+1));
			}
			
			if(curr.X-1>=0 && !v[curr.X-1]) {
				q.offer(new Point(curr.X-1,curr.time+1));
			}
			
			
			
		}
	}
	

}
