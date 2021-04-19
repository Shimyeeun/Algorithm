package SWEA;
import java.util.*;
import java.io.*;
public class Solution_1949_등산로조성 {

	static int N,K,max,cnt,flag,ans;
	static int[][] arr;
	static boolean[][] v;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			arr=new int[N][N];
			v=new boolean[N][N];
			ans=0;
			flag=0;
			max=0;
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					if(arr[i][j]>=max) {
						max=arr[i][j];
					}
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]==max) {
						cnt=1;
						v[i][j]=true;
						dfs(i,j);
						v[i][j]=false;
					}
				}
			}
			
			System.out.println("#"+t+" "+ans);
			
		}
		
	}
	
	public static void dfs(int r,int c) {
		
		ans=Math.max(ans, cnt);
		
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && !v[nr][nc]) {
				if(arr[nr][nc]<arr[r][c]) {
					v[nr][nc]=true;
					cnt++;
					dfs(nr,nc);
					cnt--;
					v[nr][nc]=false;
				}
				else {
					if(flag==0) {
						for(int k=1;k<=K;k++) {
							arr[nr][nc]-=k;
							flag++;
							
							if(arr[nr][nc]<arr[r][c]) {
								v[nr][nc]=true;
								cnt++;
								dfs(nr,nc);
								cnt--;
								v[nr][nc]=false;								
							}
							flag--;
							arr[nr][nc]+=k;
						}
					}
				}
			}
			
		}
	}

}
