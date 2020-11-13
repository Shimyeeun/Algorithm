package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D4_7733_CheeseThief {
	public static int n,day,cnt,max;
	public static int[] di= {-1,1,0,0},dj= {0,0,-1,1};
	public static int[][] arr,v;
	public static void dfs(int i, int j) {
		v[i][j]=1;
		
		for(int k=0;k<4;k++) {
			int ni=i+di[k];
			int nj=j+dj[k];
			
			if(ni>=0 && nj>=0 && ni<n && nj<n && arr[ni][nj]!=0 && v[ni][nj]==0) {
				dfs(ni,nj);
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			max=0;
			n=Integer.parseInt(br.readLine());
			arr=new int[n][n];
			for(int i=0;i<n;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
				
			}
			day=0;
			
			while(day<=100) {
				cnt=0;
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(arr[i][j]==day) {
							arr[i][j]=0;
						}
					}
				}
				v=new int[n][n];
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(arr[i][j]!=0 && v[i][j]==0) {
							cnt++;
							dfs(i,j);
						}
					}
				}
				if(cnt>=max) {
					max=cnt;
				}
				day++;
			}
			
			System.out.println("#"+t+" "+max);
			
			
		}
		

	}

}
