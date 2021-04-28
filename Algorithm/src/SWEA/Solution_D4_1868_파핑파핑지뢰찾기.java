package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D4_1868_파핑파핑지뢰찾기 {

	static int N,ans;
	static char[][] arr;
	static int[][] v;
	static int[] dr= {-1,-1,-1,0,0,1,1,1}, dc= {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			arr=new char[N][N];
			v=new int[N][N];
			ans=0;

			for(int i=0;i<N;i++) {
				String s=br.readLine();
				for(int j=0;j<N;j++) {
					arr[i][j]=s.charAt(j);
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]=='.') {
						count(i,j);
					}
					else {
						v[i][j]=-1;
					}		
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(v[i][j]==0) {
						ans++;
						bfs(i,j);
					}
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(v[i][j]!=-1) {
						ans++;
					}
				}
			}
			
			System.out.println("#"+t+" "+ans);
		}
		
	}
	
	public static void count(int r,int c) {
		
		int cnt=0;
		for(int i=0;i<8;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(nr>=0 && nr<N &&nc>=0 && nc<N && arr[nr][nc]=='*') {
				cnt++;
			}
				
		}
		
		v[r][c]=cnt;	
	}
			
	public static void bfs(int r,int c) {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {r,c});
		v[r][c]=-1;
		
		while(!q.isEmpty()) {
			
			int[] curr=q.poll();
			for(int i=0;i<8;i++) {
				int nr=curr[0]+dr[i];
				int nc=curr[1]+dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && v[nr][nc]!=-1) {
					if(v[nr][nc]==0) {
						q.offer(new int[] {nr,nc});
					}
					v[nr][nc]=-1;
				}
			}
		}
	}	

}
