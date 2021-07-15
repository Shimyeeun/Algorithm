package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_21924_도시건설_Kruskal {

	static class Edge implements Comparable<Edge>{
		int from,to,weight;
		
		public Edge(int from,int to,int weight) {
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
		for(int i=1;i<=N;i++) {
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
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		parents=new int[N+1];
		EdgeList=new Edge[M];
		make();
		long sum=0;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			sum+=c;
			EdgeList[i]=new Edge(a,b,c);			
		}
		
		long result=0;
		int count=0;
		Arrays.sort(EdgeList);
		for(Edge edge:EdgeList) {
			if(union(edge.from,edge.to)) {
				result+=edge.weight;
				if(++count==N-1) {
					break;
				}				
			}
		}
		
		if(count!=N-1) {
			System.out.println("-1");
		}
		else {
			System.out.println(sum-result);			
		}
	}

}
