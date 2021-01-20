package BaekJoon;
import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
	int end;
	int weight;
	
	Edge(int end,int weight){
		this.end=end;
		this.weight=weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.weight-o.weight;
	}
	
}
public class Solution_1753_최단경로 {
	public static int INF=Integer.MAX_VALUE,v,e,k;
	public static int[] dist;
	public static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		v=Integer.parseInt(st.nextToken());
		e=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(br.readLine());
		
		dist=new int[v+1];//�ִܰŸ� ���� �迭
		
		ArrayList<Edge>[] list=(ArrayList<Edge>[]) new ArrayList[v+1];
		for(int i=1;i<=v;i++) {
			dist[i]=INF;
			list[i]=new ArrayList<Edge>();
		}
		
		dist[k]=0;
		
		
		for(int i=0;i<e;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			list[a].add(new Edge(b,w));
			
		}
		
		PriorityQueue<Edge> pq=new PriorityQueue<Edge>();//�ּҰ��� �������� ���� �켱���� ť
		pq.offer(new Edge(k,0));
		
		while(!pq.isEmpty()) {
			Edge now=pq.poll();

			for(int i=0;i<list[now.end].size();i++){
				Edge next=list[now.end].get(i);
				if(dist[next.end]>dist[now.end]+next.weight) {
					dist[next.end]=dist[now.end]+next.weight;
					pq.offer(new Edge(next.end,dist[next.end]));

				}
			}
			
		}
		
		for(int i=1;i<=v;i++) {
			if(dist[i]==INF) {
				System.out.println("INF");
			}
			else {
				System.out.println(dist[i]);
			}
		}

	}

}
