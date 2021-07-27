package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_4485_녹색옷입은애가젤다지 {

	static class Edge implements Comparable<Edge>{
		int from,to,weight;
		
		public Edge(int from,int to,int weight) {
			this.from=from;
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int N;
	static int[][] arr;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cnt=1;
		while(true) {
			N=Integer.parseInt(br.readLine());
			arr=new int[N][N];
			int INF=Integer.MAX_VALUE;
			int[][] dist=new int[N][N];
			if(N==0) break;
			for(int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					dist[i][j]=INF;
				}
			}
			
			dist[0][0]=arr[0][0];
			PriorityQueue<Edge> pq=new PriorityQueue<>();
			pq.offer(new Edge(0,0,arr[0][0]));
			
			while(!pq.isEmpty()) {
				Edge edge=pq.poll();
				
				for(int i=0;i<4;i++) {
					int nr=edge.from+dr[i];
					int nc=edge.to+dc[i];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N) {
						if(dist[nr][nc]>dist[edge.from][edge.to]+arr[nr][nc]) {
							dist[nr][nc]=dist[edge.from][edge.to]+arr[nr][nc];
							pq.offer(new Edge(nr,nc,dist[nr][nc]));
						}
					}
				}
			}
			
			System.out.println("Problem "+cnt+": "+dist[N-1][N-1]);
			cnt++;
		}
		
	}

}
