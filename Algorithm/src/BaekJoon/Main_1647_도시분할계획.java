package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1647_도시분할계획 {
	
	static int N,M,ans=Integer.MAX_VALUE;
	static int[] minEdge,parents;
	static ArrayList<Edge>[] adj;
	static boolean[] v;
	static Edge[] edgeList;
	
	//간선을 저장할 클래스
	static class Edge implements Comparable<Edge>{
		int s,e,w;

		public Edge(int s, int e, int w) {
			super(); 
			this.s = s; //시작 정점
			this.e = e; //끝 정점
			this.w = w; //가중치(유지비)
		} 
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w,o.w); // 정렬
		}
		
	}

	static void make() { // 크기가 1인 단위집합을 만든다.
		for(int i=1;i<N+1;i++) {
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
		if(aRoot==bRoot) return false; //사이클이 있는 경우
		
		parents[bRoot]=aRoot;
		return true;
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		parents=new int[N+1];
		
		//Kruskal 알고리즘 사용하여 최소 스패닝 트리 만들기
		//간선 저장
		edgeList=new Edge[M];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			edgeList[i]=new Edge(from,to,weight);
		}

		// 간선들의 가중치를 기준으로 오름차순 정렬
		Arrays.sort(edgeList);
		
		make();
		int result=0;
		int count=0;
		
		for(Edge edge:edgeList) {
			if(union(edge.s,edge.e)) { //사이클이 없으면
				result+=edge.w; //결과에 가중치 더해줌
				if(++count==N-2) break; // 도시를 2개로 나눠야 하기 때문에 마지막 간선은 빼준다
			}
			
		}
		System.out.println(result);
	}

}
