package BaekJoon;
import java.util.*;
import java.io.*;

//class Edge implements Comparable<Edge>{
//	int end;
//	int weight;
//	
//	Edge(int end,int weight){
//		this.end=end;
//		this.weight=weight;
//	}
//	
//	@Override
//	public int compareTo(Edge o) {
//		return this.weight-o.weight;
//	}
//}

public class Main_1916_최소비용구하기{
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int INF=Integer.MAX_VALUE;
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		int[] dist=new int[n+1];
		ArrayList<Edge>[] list=(ArrayList<Edge>[]) new ArrayList[n+1];
		
		for(int i=1;i<=n;i++) {
			dist[i]=INF;
			list[i]=new ArrayList<Edge>();
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			list[a].add(new Edge(b,w));
		}
		
		st=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		
		dist[start]=0;
		
		PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
		pq.offer(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge now=pq.poll();
			for(int i=0;i<list[now.end].size();i++) {
				Edge next=list[now.end].get(i);
				if(dist[next.end]>dist[now.end]+next.weight) {
					dist[next.end]=dist[now.end]+next.weight;
					pq.offer(new Edge(next.end,dist[next.end]));
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			if(i==end) {
				System.out.println(dist[i]);
			}
		}
		
	}

}
