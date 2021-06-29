package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_2573_빙산 {

	static int N,M,cnt,year;
	static boolean[][] v;
	static int[][] arr,ocean;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N][M];
				
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		while(true) {
			if(meltcheck()) {
				System.out.println("0");
				break;
			}
			if(count()>=2) {
				System.out.println(year);
				break;
			}
			year++;
			ocean();
			melt();			
		}
		
	}
	
	public static boolean meltcheck() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]>0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void melt() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=0) {
					arr[i][j]-=ocean[i][j];
					if(arr[i][j]<0) {
						arr[i][j]=0;
					}
				}
			}
		}
	}
	
	public static void ocean() {
		ocean=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=0) {
					for(int k=0;k<4;k++) {
						int nr=i+dr[k];
						int nc=j+dc[k];
						
						if(arr[nr][nc]==0) {
							ocean[i][j]++;
						}
					}
				}
			}
		}
	}
	

	public static int count() {
		int cnt=0;
		v=new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=0 && !v[i][j]) {
					cnt++;
					dfs(i,j);
				}
			}
		}
		return cnt;
	}

	public static void dfs(int r,int c) {
		v[r][c]=true;
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(nr>=0 && nc>=0 && nr<N && nc<M && arr[nr][nc]>0 && !v[nr][nc]) {
				dfs(nr,nc);
			}
		}
	}
}
