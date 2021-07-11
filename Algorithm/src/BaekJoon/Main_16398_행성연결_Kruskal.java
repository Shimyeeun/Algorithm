package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_16398_행성연결_Kruskal {

	static int N;
	static int[] parents;
	static Edge[] EdgeList;
	static int[][] arr;
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
	
	static void make() {
		for(int i=1;i<=N;i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		
		return parents[a]=find(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot==bRoot) {
			return false;
		}
		
		parents[bRoot]=aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		
		parents=new int[N+1];
		arr=new int[N+1][N+1];
		EdgeList=new Edge[N*(N-1)/2];
		make();
		for(int i=1;i<=N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}		
		}
		
		int cnt=0;
		for(int i=1;i<=N;i++) {
			for(int j=i+1;j<=N;j++) {
				EdgeList[cnt]=new Edge(i,j,arr[i][j]);
				cnt++;
			}
		}
		
		Arrays.sort(EdgeList);
		
		long result=0;
		long count=0;
		
		for(Edge edge:EdgeList) {
			if(union(edge.from,edge.to)) {
				result+=edge.weight;
				if(++count==N-1) {
					break;
				}
			}
		}
		
		System.out.println(result);
	}

}
