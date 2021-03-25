package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D4_1251_하나로 {
	static int N,E;
	static int parents[];
	static Node[] node;
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public Node(int x) {
			super();
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		double w;
		Edge(int s,int e,double w){
			this.s=s;
			this.e=e;
			this.w=w;
		}
		@Override
		public String toString() {
			return "Edge [e=" + e + ", w=" + w + "]";
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.w, o.w);
		}
	}
	
	static void make() { // 크기가 1인 단위집합을 만든다.
		for(int i=0;i<N;i++) {
			parents[i]=i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a]==a) return a;
//		return findSet(parents[a]); // path compression 전
		return parents[a]=findSet(parents[a]); // path compression 후
 	}
	
	static boolean union(int a,int b) {
		int aRoot=findSet(a);
		int bRoot=findSet(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot]=aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			node=new Node[N];
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int x=Integer.parseInt(st.nextToken());
				node[i]=new Node(0,0);
				node[i].x=x;
			}
			
			
			 st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int y=Integer.parseInt(st.nextToken());
				node[i].y=y;
			}
			
			double E=Double.parseDouble(br.readLine());
			parents=new int[N+1];
			ArrayList<Edge> adj=new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					double a=Math.pow((double)(node[i].x-node[j].x),2.0);
					double b=Math.pow((double)(node[i].y-node[j].y),2.0);
					
					adj.add(new Edge(i,j,a+b));
				}
			}
			Collections.sort(adj);
			make();
			long result=0;
			int count=0;
			
			for(int i=0;i<adj.size();i++) {
				if(union(adj.get(i).s,adj.get(i).e)) {
					result+=adj.get(i).w;
					if(++count==N-1) break;
				}
			}
			sb.append("#"+t+" "+Math.round(result*E)+"\n");
						
		}
		
		System.out.println(sb.toString());
		

	}
}


