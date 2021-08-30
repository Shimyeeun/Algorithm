package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_14621_나만안되는연애 {

	static int N,M;
	static int[] parents;
	static char[] school;
	static Edge[] list;
	static class Edge implements Comparable<Edge>{
		int from,to,weight;
		public Edge(int from,int to, int weight) {
			this.from=from;
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void make() {
		for(int i=1;i<=N;i++) {
			parents[i]=i;
		}
	}
	
	public static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		return parents[a]=find(parents[a]);
	}
	
	public static boolean union(int a,int b) {
		if(school[a]==school[b]) return false;
		int aRoot=find(a);
		int bRoot=find(b);
				
		if(aRoot==bRoot) {
			return false;
		}
		parents[bRoot]=aRoot;
		return true;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		school=new char[N+1];
		parents=new int[N+1];
		list=new Edge[M];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			school[i]=st.nextToken().charAt(0);
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			list[i]=new Edge(a,b,c);
		}
		make();
		int res=0;
		int cnt=0;
		Arrays.sort(list);
		for(Edge edge:list) {
			if(union(edge.from,edge.to)) {
				res+=edge.weight;
				if(++cnt==N-1) {
					break;
				}
			}
		}
		
		if(cnt!=N-1) {
			System.out.println("-1");
		}
		else {
			System.out.println(res);
		}
	}

}
