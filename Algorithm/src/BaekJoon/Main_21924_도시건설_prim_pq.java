package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_21924_도시건설_prim_pq {

	static class Node implements Comparable<Node>{
		int to,weight;
		
		public Node(int to,int weight) {
			super();
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
		ArrayList<Node>[] adj=new ArrayList[N+1];
		long sum=0;
		for(int i=1;i<=N;i++) {
			adj[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			sum+=c;
			adj[a].add(new Node(b,c));
			adj[b].add(new Node(a,c));
		}
		boolean[] visited=new boolean[N+1];
		PriorityQueue<Node> pq=new PriorityQueue<>();	
		pq.add(new Node(1,0));
		
		long result=0;
		int count=0;
		
		while(!pq.isEmpty()) {
			Node edge=pq.poll();
			
			if(visited[edge.to]) continue;
			
			result+=edge.weight;
			visited[edge.to]=true;
			
			
			if(++count==N) break;
			
			for(int i=0;i<adj[edge.to].size();i++) {
				Node next=adj[edge.to].get(i);
				if(visited[next.to]) continue;
				
				pq.add(next);
			}
		}
		
		if(count!=N) {
			System.out.println("-1");
		}
		else System.out.println(sum-result);
	
		
	}

}
