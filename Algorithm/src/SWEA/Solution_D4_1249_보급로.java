package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D4_1249_보급로 {
	
	static int N,min,cnt;
	static int[][] arr;
	static int[][] v;
	static int[] dr= {-1,1,0,0,}, dc= {0,0,-1,1};
	

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			arr=new int[N][N];
			v=new int[N][N];
			cnt=0;
			min=Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				String s=br.readLine();
				for(int j=0;j<N;j++) {
					arr[i][j]=s.charAt(j)-'0';
					v[i][j]=-1;
				}
			}
			bfs();
			
			sb.append("#"+t+" "+v[N-1][N-1]+"\n");
			
		}
		System.out.println(sb.toString());
	}
	
	public static void bfs() {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {0,0});
		v[0][0]=0;
		
		while(!q.isEmpty()) {
			int[] curr=q.poll();
			
			for(int i=0;i<4;i++) {
				int nr=curr[0]+dr[i];
				int nc=curr[1]+dc[i];
				
				
				if(nr==N-1 && nc ==N-1) {
					min=v[nr][nc];
				}
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && v[nr][nc]==-1) {
					v[nr][nc]=v[curr[0]][curr[1]]+arr[nr][nc];
					q.offer(new int[] {nr,nc});
				}
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && v[nr][nc]!=-1 && v[curr[0]][curr[1]]+arr[nr][nc]<v[nr][nc] ) {
					v[nr][nc]=v[curr[0]][curr[1]]+arr[nr][nc];
					q.offer(new int[] {nr,nc});						
				}
			}
		}
	}
	

}
