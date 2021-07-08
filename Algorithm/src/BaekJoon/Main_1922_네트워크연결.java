package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1922_네트워크연결 {

	static class Edge implements Comparable<Edge>{
		int from,to,weight;
		
		public Edge(int from,int to,int weight) {
			super();
			this.from=from;
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight); 
		}
	}
	static int N,M;
	static int[] parents;
	static Edge[] EdgeList;
	
	static void make() {
		for(int i=0;i<=N;i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a]=find(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot==bRoot) return false;
		
		parents[bRoot]=aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		
		parents=new int[N+1];
		EdgeList=new Edge[M];
		
		for(int i=0;i<M;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			EdgeList[i]=new Edge(a,b,c);
		}
		
		Arrays.sort(EdgeList);
		make();
		
		int result=0;
		int count=0;
		for(Edge edge:EdgeList) {
			if(union(edge.from, edge.to)) {
				result+=edge.weight;
				if(++count==N-1) break;
			}
		}
		
		System.out.println(result);
		
	}

}
