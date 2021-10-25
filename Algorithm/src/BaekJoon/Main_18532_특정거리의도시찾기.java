package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_18532_특정거리의도시찾기 {

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
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		int INF=Integer.MAX_VALUE;
		
		ArrayList<Edge>[] list=new ArrayList[N+1];
		int[] dist=new int[N+1];
		boolean[] check=new boolean[N+1];
		
		for(int i=0;i<=N;i++) {
			list[i]=new ArrayList<>();
			dist[i]=INF;
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b,1));
		}
		
		PriorityQueue<Edge> pq=new PriorityQueue<>();
		dist[X]=0;
		pq.offer(new Edge(X,0));
		
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
		int cnt=0;
		for(int i=1;i<=N;i++) {
			if(dist[i]==K) {
				System.out.println(i);
				cnt++;
			}
		}
		
		if(cnt==0) {
			System.out.println("-1");
		}
		
	}

}
