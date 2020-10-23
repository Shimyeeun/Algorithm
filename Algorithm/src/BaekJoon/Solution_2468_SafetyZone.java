package BaekJoon;
import java.util.*;
import java.io.*;
public class Solution_2468_SafetyZone {
	public static int[][] zone;
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	public static int N,cnt,max;
	
	public static void dfs(int[][] zone,int i, int j) {
		zone[i][j]=1;
		for(int k=0;k<4;k++) {
			int ni=i+di[k];
			int nj=j+dj[k];
			if(ni>=0 && nj>=0 && ni<N && nj<N && zone[ni][nj]==0) {
				dfs(zone,ni,nj);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		max=0;
		N=Integer.parseInt(br.readLine());
		int[][] arr=new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<=100;i++) {
			
			cnt=0;
			zone=new int[N][N];
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(arr[j][k]<=i) {
						zone[j][k]=1;
					}
				}
			}	
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(zone[j][k]==0) {
						cnt++;
						dfs(zone,j,k);
					}
				}
			}
			
			if(cnt>max) {
				max=cnt;
			}
		}
		
		System.out.println(max);

	}

}
