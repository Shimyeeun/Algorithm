package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1774_우주신과의교감 {

	static int N,M;
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
		if(aRoot==bRoot) return false; //사이클 있을 때
		
		parents[bRoot]=aRoot;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		node=new Node[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			node[i]=new Node(x,y); // 정점 만들기
		}
		
		
		ArrayList<Edge> adj=new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				double a=Math.pow((double)(node[i].x-node[j].x),2.0);
				double b=Math.pow((double)(node[i].y-node[j].y),2.0);
				double dist=Math.sqrt(a+b); // 두 좌표 사이의 거리 구하기
				adj.add(new Edge(i+1,j+1,dist)); //간선 만들기
			} 
		}
		
		
		parents=new int[N+1];
		make();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			union(x,y); // 이미 연결된 곳이면 union을 먼저 해준다
		}
		Collections.sort(adj); //가중치 오름차순 정렬
		double result=0.0;
		int count=0;
		
		for(int i=0;i<adj.size();i++) {
			if(union(adj.get(i).s,adj.get(i).e)) { // 사이클 없을때
				result+=adj.get(i).w;
				if(++count==N-1) break; // 간선개수가 N-1개가 되면 최소 스패닝 트리 완성
			}
		}
		
		System.out.println(String.format("%.2f", result)); //소수점 둘째자리까지 표현

	}

}
