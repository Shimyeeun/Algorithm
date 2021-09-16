package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_10282_해킹 {

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
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int INF=Integer.MAX_VALUE;
			ArrayList<Edge>[] list=new ArrayList[n+1];
			int[] dist=new int[n+1];
			boolean[] check=new boolean[n+1];
			
			for(int i=0;i<=n;i++) {
				list[i]=new ArrayList<>();
				dist[i]=INF;
			}
			
			for(int i=0;i<d;i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				int s=Integer.parseInt(st.nextToken());
				
				list[b].add(new Edge(a,s));
			}
			
			PriorityQueue<Edge> pq=new PriorityQueue<>();
			dist[c]=0;
			pq.offer(new Edge(c,0));
			
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
			int max=0;
			for(int i=1;i<=n;i++) {
				if(dist[i]!=INF) {
					cnt++;
					max=Math.max(max,dist[i]);
				}
			}
			System.out.println(cnt+" "+max);
		}
	}

}
