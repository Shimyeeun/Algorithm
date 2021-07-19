package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_6497_전력난_prim {

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
		
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			
			if(N==0 && M==0) break;
			ArrayList<Node>[] adj=new ArrayList[N];
			
			long sum=0;
			
			for(int i=0;i<N;i++) {
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
			boolean[] visited=new boolean[N];
			PriorityQueue<Node> pq=new PriorityQueue<>();
			pq.add(new Node(0,0));
			
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
			System.out.println(sum-result);
		}
		
	}

}
