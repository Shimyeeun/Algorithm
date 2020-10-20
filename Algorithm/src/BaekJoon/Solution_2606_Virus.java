package BaekJoon;
import java.util.*;
import java.io.*;
public class Solution_2606_Virus {
	public static int com,cnt;
	public static boolean[] v;
	
	public static void dfs(int i,int[][] arr) {
		
		v[i]=true;
		for(int j=0;j<com;j++) {
			if(v[j]==false) {
				if(arr[i][j]==1) {
					v[j]=true;
					cnt++;
					dfs(j,arr);
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		com=Integer.parseInt(br.readLine());
		int t=Integer.parseInt(br.readLine());
		
		int[][] network=new int[com][com];
		v=new boolean[com];
		cnt=0;
		for(int i=0;i<t;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			network[x-1][y-1]=1;
			network[y-1][x-1]=1;
		
		}
	
		
		dfs(0,network);
		System.out.println(cnt);
		//test
	}

}
