package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1504_특정한최단경로 {

	static class Edge implements Comparable<Edge>{
		int to,weight;
		
		public Edge(int to,int weight) {
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int N,E,INF;
	static int[] dist;
	static boolean[] check;
	static ArrayList<Edge>[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		INF=Integer.MAX_VALUE;
		
		list=new ArrayList[N+1];
		dist=new int[N+1];
		check=new boolean[N+1];
		
		for(int i=0;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b,c));
			list[b].add(new Edge(a,c));
		}
		
		st=new StringTokenizer(br.readLine());
		int v1=Integer.parseInt(st.nextToken());
		int v2=Integer.parseInt(st.nextToken());
		
		int oneTov1=dijkstra(1,v1);
		int v1Tov2=dijkstra(v1,v2);
		int v2ToN=dijkstra(v2,N);
		int oneTov2=dijkstra(1,v2);
		int v2Tov1=dijkstra(v2,v1);
		int v1ToN=dijkstra(v1,N);
		
		int res1=0;
		int res2=0;
		if(oneTov1==INF||v1Tov2==INF||v2ToN==INF) {
			res1=INF;
		} else {
			res1=oneTov1+v1Tov2+v2ToN;
		}
		
		if(oneTov2==INF||v2Tov1==INF||v1ToN==INF) {
			res2=INF;
		} else {
			res2=oneTov2+v2Tov1+v1ToN;
		}
		
		if(res1==INF && res2==INF) {
			System.out.println("-1");
		}
		else {
			System.out.println(Math.min(res1, res2));			
		}
		
		
		
	}
	
	public static int dijkstra(int start,int end) {
		
		for(int i=0;i<=N;i++) {
			dist[i]=INF;
		}
		
		check=new boolean[N+1];
		
		PriorityQueue<Edge> pq=new PriorityQueue<>();
		dist[start]=0;
		pq.offer(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge now=pq.poll();
			if(!check[now.to]) {
				check[now.to]=true;
				for(int i=0;i<list[now.to].size();i++){
					Edge next=list[now.to].get(i);
					if(!check[next.to]&&dist[next.to]>dist[now.to]+next.weight) {
						dist[next.to]=dist[now.to]+next.weight;
						pq.offer(new Edge(next.to,dist[next.to]));
					}
				}
			}
		}
		
		return dist[end];
		
	}

}
