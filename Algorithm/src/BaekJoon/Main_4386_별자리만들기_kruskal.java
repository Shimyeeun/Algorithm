package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_4386_별자리만들기_kruskal {

	static class Node{
		double x,y;
		
		public Node(double x,double y) {
			super();
			this.x=x;
			this.y=y;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		double from,to,weight;
		
		public Edge(int from,int to,double weight) {
			super();
			this.from=from;
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	static int N;
	static Node[] NodeList;
	static int[] parents;
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
		
		N=Integer.parseInt(br.readLine());
		NodeList=new Node[N];
		parents=new int[N];
		ArrayList<Edge> EdgeList=new ArrayList<>();
		make();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			double x=Double.parseDouble(st.nextToken());
			double y=Double.parseDouble(st.nextToken());
			NodeList[i]=new Node(x,y);
		}
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				double a=Math.pow(NodeList[i].x-NodeList[j].x,2.0);
				double b=Math.pow(NodeList[i].y-NodeList[j].y,2.0);
				double dist=Math.sqrt(a+b);
				
				EdgeList.add(new Edge(i,j,dist));
			}
		}
		
		Collections.sort(EdgeList);
		double result=0;
		int count=0;
		
		for(int i=0;i<EdgeList.size();i++) {
			if(union((int)EdgeList.get(i).from,(int)EdgeList.get(i).to)) {
				result+=EdgeList.get(i).weight;
				if(++count==N-1) break;
			}
		}
		
		System.out.println(String.format("%.2f",result));
	}

}
