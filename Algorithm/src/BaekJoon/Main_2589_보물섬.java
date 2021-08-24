package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_2589_보물섬 {

	static int N,M;
	static char[][] arr;
	static boolean[][] v;
	static int cnt,min;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new char[N][M];
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j]=s.charAt(j);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]=='L') {
					bfs(i,j);
					min=Math.max(min, cnt);
				}
			}
		}
		
		
		System.out.println(min);
		
	}
	
	public static void bfs(int r,int c) {
		cnt=0;
		Queue<int[]> q=new LinkedList<>();
		v=new boolean[N][M];
		v[r][c]=true;
		q.offer(new int[] {r,c,0});
		while(!q.isEmpty()) {
			int[] curr=q.poll();
			
			for(int i=0;i<4;i++) {
				int nr=curr[0]+dr[i];
				int nc=curr[1]+dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && !v[nr][nc] && arr[nr][nc]=='L') {
					q.offer(new int[] {nr,nc,curr[2]+1});
					v[nr][nc]=true;
					cnt=Math.max(cnt, curr[2]+1);
				}
			}
		}
		
		
	}

}
