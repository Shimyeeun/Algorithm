package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_5972_택배배송 {

	static class Node implements Comparable<Node>{
		int to, weight;
		
		public Node(int to, int weight) {
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
	
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int INF=Integer.MAX_VALUE;
		int[] dist=new int[N+1];
		boolean[] check=new boolean[N+1];
		ArrayList<Node>[] adj=new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			dist[i]=INF;
			adj[i]=new ArrayList<Node>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			adj[a].add(new Node(b,c));
			adj[b].add(new Node(a,c));
		}
		dist[1]=0;
		
		PriorityQueue<Node> pq=new PriorityQueue<>(); 
		pq.offer(new Node(1,0));
		
		while(!pq.isEmpty()) {
			Node curr=pq.poll();
			if(!check[curr.to]) {
				check[curr.to]=true;
				for(int i=0;i<adj[curr.to].size();i++) {
					Node next=adj[curr.to].get(i);
					if(!check[next.to]&&dist[next.to]>dist[curr.to]+next.weight) {
						dist[next.to]=dist[curr.to]+next.weight;
						pq.offer(new Node(next.to,dist[next.to]));
					}
				}
			}
		}
		
		System.out.println(dist[N]);
	}

}
