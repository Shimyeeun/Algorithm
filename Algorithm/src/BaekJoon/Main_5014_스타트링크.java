package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_5014_스타트링크 {
	
	static int F,S,G,U,D;
	static boolean[] v;
	static int[] cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		F=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		G=Integer.parseInt(st.nextToken());
		U=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		v=new boolean[F+1];
		cnt=new int[F+1];
		int[] move= {U,-D};
		if(S==G) {
			System.out.println("0");
			return;
		}
		bfs(S,move);
		if(cnt[G]==0) System.out.println("use the stairs");
		else System.out.println(cnt[G]);
	}

	public static void bfs(int n,int[] move) {
		Queue<Integer> q=new LinkedList<>();
		v[n]=true;
		q.offer(n);
		while(!q.isEmpty()) {
			int curr=q.poll();
			for(int i=0;i<2;i++) {
				int nidx=curr+move[i];
				
				if(nidx>=1 && nidx<=F && !v[nidx]) {
					v[nidx]=true;
					cnt[nidx]=cnt[curr]+1;
					q.offer(nidx);
				}
			}
			
		}
	}
}
