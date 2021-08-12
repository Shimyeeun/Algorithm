package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_14594_동방프로젝트_small {
	static int N,M;
	static int[] parent;
	static void make() {
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
	}
	static int find(int a) {
		if(parent[a]==a) {
			return a;
		}
		
		return parent[a]=find(parent[a]);
		
	}
	static boolean union(int a,int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot==bRoot) {
			return false;
		}
		parent[aRoot]=bRoot;
		return true;
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		parent=new int[N+1];
		make();
		int cnt=N;
		for(int i=0;i<M;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			while(find(a)!=find(b)) {
				cnt--;
				int next=find(a)+1;
				union(a,b);
				a=next;
			}
		}
		

		System.out.println(cnt);
		
	}
}
