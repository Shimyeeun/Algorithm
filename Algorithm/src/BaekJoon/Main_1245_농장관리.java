package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1245_농장관리 {

	static int N,M;
	static int[][] arr;
	static boolean[][] v;
	static boolean pick;
	
	static int[] dr={-1,-1,-1,0,1,1,1,0},dc={-1,0,1,1,1,0,-1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N][M];
		v=new boolean[N][M];
		pick=false;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!v[i][j]) {
					v[i][j]=true;
					pick=true;
					dfs(i,j);
					if(pick) cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void dfs(int r,int c) {
		
		for(int i=0;i<8;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(nr>=0 && nc>=0 && nr<N && nc<M && arr[nr][nc]>arr[r][c]) pick=false;
			if(nr>=0 && nc>=0 && nr<N && nc<M && !v[nr][nc] && arr[nr][nc]==arr[r][c]) {
				v[nr][nc]=true;
				dfs(nr,nc);
			}
		}
		
	}

}
