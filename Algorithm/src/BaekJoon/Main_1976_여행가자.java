package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1976_여행가자 {

	static int N,M;
	static int[][] arr;
	static int[] parents;
	
	static void make() {
		for(int i=1;i<=N;i++) {
			parents[i]=i;
		}
	}
	
	static int findset(int a) {
		if(parents[a]==a) return a;
		return parents[a]=findset(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aRoot=findset(a);
		int bRoot=findset(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot]=aRoot;
		return true;	
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		parents=new int[N+1];
		make();
		for(int i=1;i<=N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int a=Integer.parseInt(st.nextToken());
				if(a==1) {
					union(i,j);
				}
			}
		}
		
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] plan=new int[M+1];
		for(int i=1;i<=M;i++) {
			plan[i]=Integer.parseInt(st.nextToken());
		}
		
		String ans="YES";
		for(int i=1;i<M;i++) {
			if(findset(plan[i])==findset(plan[i+1])){
				continue;
			}
			else {
				ans="NO";
				break;
			}
		}
		
		System.out.println(ans);
		
	}

}
