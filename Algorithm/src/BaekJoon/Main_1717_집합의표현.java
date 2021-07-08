package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1717_집합의표현 {

	static int N,M;
	static int[] parents;
	
	static void make() {
		for(int i=0;i<=N;i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		return parents[a]=find(parents[a]);
	}
	
	static void union(int a,int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		parents[bRoot]=aRoot;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		parents=new int[N+1];
		
		make();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			if(a==0) {
				union(b,c);
			}
			else {
				if(find(b)==find(c)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
			
		}
	}

}
