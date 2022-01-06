package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_14442_벽부수고이동하기2 {

	static class Point{
		int r,c,dist,crush;
		
		public Point(int r,int c,int dist,int crush) {
			this.r=r;
			this.c=c;
			this.dist=dist;
			this.crush=crush;
		}
	}
	
	static int N,M,K,ans=-1;
	static int[][] arr;
	static boolean[][][] v;
	static int[] dr= {-1,1,0,0}, dc= {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		arr=new int[N][M];
		v=new boolean[K+1][N][M];
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j]=s.charAt(j)-'0';
			}
		}
		
		bfs(0,0);
		System.out.println(ans);
	}
	
	public static void bfs(int r,int c) {
		Queue<Point> q=new LinkedList<>();
		q.offer(new Point(r,c,1,0));
		while(!q.isEmpty()) {
			Point curr=q.poll();
			if(curr.r==N-1 && curr.c==M-1) {
				ans=curr.dist;
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nr=curr.r+dr[i];
				int nc=curr.c+dc[i];
				
				if(nr>=0 && nc>=0 && nr<N && nc<M) {
					if(curr.crush<K) {
						if(arr[nr][nc]==0) {
							if(!v[curr.crush][nr][nc]) {
								v[curr.crush][nr][nc]=true;
								q.offer(new Point(nr,nc,curr.dist+1,curr.crush));
							}
						}
						else {
							if(!v[curr.crush+1][nr][nc]) {
								v[curr.crush+1][nr][nc]=true;
								q.offer(new Point(nr,nc,curr.dist+1,curr.crush+1));
							}
						}
					}
					else {
						if(!v[curr.crush][nr][nc]&&arr[nr][nc]==0) {
							v[curr.crush][nr][nc]=true;
							q.offer(new Point(nr,nc,curr.dist+1,curr.crush));
						}
					}
				}
			}
		}
	}

}
