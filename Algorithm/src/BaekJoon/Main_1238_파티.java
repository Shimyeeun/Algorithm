package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1238_파티 {
	
	static int N,M,X,INF=Integer.MAX_VALUE;
	static ArrayList<Edge>[] list;
	static boolean[] check;
	static int[] dist;
	static int max=0;
	static class Edge implements Comparable<Edge>{
		int to,weight;
		
		public Edge(int to,int weight) {
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight,o.weight);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
	
		list=new ArrayList[N+1];
		int[] dist1=new int[N+1];
		int[] dist2=new int[N+1];
		int[] res=new int[N+1];
		for(int i=0;i<=N;i++) {
			list[i]=new ArrayList<>();
			dist1[i]=INF;
			dist2[i]=INF;
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b,c));
		}
		
		for(int i=1;i<=N;i++) {
			dist1[i]=dijkstra(i)[X];
		}
		
		dist2=dijkstra(X);
		
		for(int i=1;i<=N;i++) {
			res[i]=dist1[i]+dist2[i];
			max=Math.max(res[i], max);
		}
		
		System.out.println(max);
		
	}
	
	public static int[] dijkstra(int start) {
		check=new boolean[N+1];
		dist=new int[N+1];
		Arrays.fill(dist, INF);
		PriorityQueue<Edge> pq=new PriorityQueue<>();
		dist[start]=0;
		pq.offer(new Edge(start,0));
		while(!pq.isEmpty()) {
			Edge now=pq.poll();
			if(!check[now.to]) {
				check[now.to]=true;
				for(int i=0;i<list[now.to].size();i++) {
					Edge next=list[now.to].get(i);
					if(!check[next.to]&&dist[next.to]>dist[now.to]+next.weight) {
						dist[next.to]=dist[now.to]+next.weight;
						pq.offer(new Edge(next.to,dist[next.to]));
					}
				}
			}
		}
		return dist;
	}

}
