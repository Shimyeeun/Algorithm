package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1743_AvoidFood {
	public static int n,m,count;
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	
	public static void dfs(int i, int j, int[][] arr) {
		count++;
		arr[i][j]=0;
		
		for(int k=0;k<4;k++) {
			int ni=i+di[k];
			int nj=j+dj[k];
			
			if(ni>=0 && nj>=0 && ni<n && nj<m && arr[ni][nj]==1) {
				dfs(ni,nj,arr);

			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int[][] arr=new int[n][m];
		
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[a-1][b-1]=1;
		}		
	
		int max=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				count=0;
				if(arr[i][j]==1) {
					
					dfs(i,j,arr);
					
					if(count>=max) {
						max=count;
					}
				}
			}
		}
		
		System.out.println(max);
	}

}
