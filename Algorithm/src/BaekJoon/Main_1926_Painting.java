package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1926_Painting {
	public static int n,m,count,size=1,max=0;
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	
	public static void dfs(int[][] arr,int i,int j) {
		arr[i][j]=0;
		
		for(int k=0;k<4;k++) {
			int ni=i+di[k];
			int nj=j+dj[k];
			
			if(ni>=0 && nj>=0 && ni<n && nj<m && arr[ni][nj]==1) {
				size++;
				dfs(arr,ni,nj);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		int[][] arr=new int[n][m];
		
		for(int i=0;i<n;i++) {
			StringTokenizer s= new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(s.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				size=1;
				if(arr[i][j]!=0) {
					count++;
					dfs(arr,i,j);
					
					if(size>=max) {
						max=size;
					}
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);

	}

}
