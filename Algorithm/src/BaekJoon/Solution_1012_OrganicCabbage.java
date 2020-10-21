package BaekJoon;
import java.util.*;
import java.io.*;
public class Solution_1012_OrganicCabbage {
	static int worm=0,n,m;
	static int[] di= {-1,1,0,0};
	static int[] dj= {0,0,-1,1};
	public static void dfs(int i, int j, int[][] arr) {
		arr[i][j]=0;
		
		for(int k=0;k<4;k++) {
			int ni=i+di[k];
			int nj=j+dj[k];
			if(ni>=0&&nj>=0&&ni<n&&nj<m&&arr[ni][nj]==1) {
				dfs(ni,nj,arr);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			m=Integer.parseInt(st.nextToken());
			n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			int[][] arr=new int[n][m];
			worm=0;
			for(int j=0;j<k;j++) {
				StringTokenizer s=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(s.nextToken());
				int y=Integer.parseInt(s.nextToken());
				arr[y][x]=1;			
			}
			
			for(int j=0;j<n;j++) {
				for(int l=0;l<m;l++) {
					if(arr[j][l]==1) {
						worm++;
						dfs(j,l,arr);
					}
				}
			}
			
			System.out.println(worm);
			
		}

	}
}
