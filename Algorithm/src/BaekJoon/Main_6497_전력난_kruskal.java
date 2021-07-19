package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_6497_전력난_kruskal {

	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
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
	static ArrayList<Edge> EdgeList;
	
	static void make() {
		for(int i=0;i<N;i++) {
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
		
		
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			if(N==0 && M==0) break;
			
			EdgeList=new ArrayList<>();
			parents=new int[N];
			long sum=0;
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());

				sum+=c;
				EdgeList.add(new Edge(a,b,c));
			}
			make();
			
			Collections.sort(EdgeList);
			long result=0;
			int count=0;
			
			for(int i=0;i<EdgeList.size();i++) {
				if(union(EdgeList.get(i).from,EdgeList.get(i).to)) {
					result+=EdgeList.get(i).weight;
					if(++count==N-1) break;
				}
			}
			
			System.out.println(sum-result);
			
		}
		
		
	}

}
