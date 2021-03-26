package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_9205_맥주마시면서걸어가기 {
	
	static class point{
		int x,y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "point [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static int n;
	static boolean[] v;
	static point[] store;
	static ArrayList<Integer>[] adjList;
	

	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			n=Integer.parseInt(br.readLine());
			store=new point[n+2];
			v=new boolean[n+2];
			adjList=new ArrayList[n+2];
			
			for(int i=0;i<n+2;i++) {
				adjList[i]=new ArrayList<Integer>();
			}
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			int homeX=Integer.parseInt(st.nextToken());
			int homeY=Integer.parseInt(st.nextToken());
			store[0]=new point(homeX,homeY);
			for(int i=1;i<=n;i++) {
				st=new StringTokenizer(br.readLine());
				int storeX=Integer.parseInt(st.nextToken());
				int storeY=Integer.parseInt(st.nextToken());
				
				store[i]=new point(storeX,storeY);
			}
			
			st=new StringTokenizer(br.readLine());
			int festX=Integer.parseInt(st.nextToken());
			int festY=Integer.parseInt(st.nextToken());
			
			store[n+1]=new point(festX,festY);
			int dist=Math.abs(homeX-festX)+Math.abs(homeY-festY);
			if(dist<=1000) {
				sb.append("happy"+"\n");
			}
			else {
				for(int i=0;i<n+2;i++) {
					for(int j=i+1;j<n+2;j++) {
						int d=Math.abs(store[i].x-store[j].x)+Math.abs(store[i].y-store[j].y);
						if(d<=1000) {
							adjList[i].add(j);
							adjList[j].add(i);
						}
					}
				}
				
				bfs(0);
				if(v[n+1]) {
					sb.append("happy"+"\n");
				}
				else {
					sb.append("sad"+"\n");
				}
			}
			
		}
		
		
		System.out.println(sb.toString());

	}
	
	public static void bfs(int start) {
		Queue<Integer> q=new LinkedList<>();
		q.offer(start);
		v[start]=true;
		
		while(!q.isEmpty()) {
			int curr=q.poll();
			for(int temp:adjList[curr]) {
				if(!v[temp]) {
					q.offer(temp);
					v[temp]=true;
				}
			}
			
			
		}
	}

}
