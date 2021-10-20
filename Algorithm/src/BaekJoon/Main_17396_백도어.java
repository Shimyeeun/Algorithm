package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_17396_백도어 {

	
	static class Edge implements Comparable<Edge>{
		int to;
		long weight;
		
		public Edge(int to, long weight) {
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		long INF=Long.MAX_VALUE;
		int[] arr=new int[N];
		boolean[] check=new boolean[N];
		ArrayList<Edge>[] list=new ArrayList[N];
		long[] dist=new long[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			list[i]=new ArrayList<>();
			dist[i]=INF;
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b,c));
			list[b].add(new Edge(a,c));
		}
		
		PriorityQueue<Edge> pq=new PriorityQueue<>();
		dist[0]=0;
		pq.offer(new Edge(0,0));
		while(!pq.isEmpty()) {
			Edge now=pq.poll();
			if(!check[now.to]) {
				check[now.to]=true;
				for(int i=0;i<list[now.to].size();i++) {
					Edge next=list[now.to].get(i);
					if(!check[next.to]&&dist[next.to]>dist[now.to]+next.weight) {
						if(arr[next.to]==0 || next.to==N-1) {
							dist[next.to]=dist[now.to]+next.weight;
							pq.offer(new Edge(next.to,dist[next.to]));							
						}
					}
				}
			}
			
		}
		
		if(dist[N-1]==INF) {
			System.out.println("-1");
		}
		else {
			System.out.println(dist[N-1]);			
		}
		
	}

}
