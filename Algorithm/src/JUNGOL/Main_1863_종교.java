package JUNGOL;
import java.util.*;
import java.io.*;

public class Main_1863_종교 {
	
	static int[] parents;
	static int N;

	static void make() {
		for(int i=1;i<=N;i++) {
			parents[i]=i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a]==a) return a;
		return parents[a]=findSet(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aRoot=findSet(a);
		int bRoot=findSet(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot]=aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		parents=new int[N+1];
		make();
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		int cnt=0;
		for(int i=1;i<=N;i++) {
			if(parents[i]==i) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
