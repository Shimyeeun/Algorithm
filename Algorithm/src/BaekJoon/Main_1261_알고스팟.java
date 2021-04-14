package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1261_알고스팟 {

	static int N,M,min=Integer.MAX_VALUE;
	static int[][] arr,v;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1][M+1];
		v=new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			String s=br.readLine();
			for(int j=1;j<=M;j++) {
				arr[i][j]=s.charAt(j-1)-'0';
				v[i][j]=-1;
			}
		}
		
		bfs();
	
		System.out.println(v[N][M]);
	}
	
	public static void bfs() {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {1,1});
		v[1][1]=0;
		
		while(!q.isEmpty()) {
			int[] curr=q.poll();
			
			for(int i=0;i<4;i++) {
				int nr=curr[0]+dr[i];
				int nc=curr[1]+dc[i];
				
				
				if(nr>0 && nr<=N && nc>0 && nc<=M && v[nr][nc]==-1 ) {
					v[nr][nc]=v[curr[0]][curr[1]]+arr[nr][nc];
					q.offer(new int[] {nr,nc});
				}
				else if(nr>0 && nr<=N && nc>0 && nc<=M && v[nr][nc]!=-1 && arr[nr][nc]+v[curr[0]][curr[1]]<v[nr][nc]) {
					v[nr][nc]=v[curr[0]][curr[1]]+arr[nr][nc];
					q.offer(new int[] {nr,nc});
				}
			}
		}
	}

}
