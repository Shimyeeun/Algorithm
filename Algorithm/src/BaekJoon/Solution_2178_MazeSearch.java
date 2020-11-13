package BaekJoon;
import java.util.*;
import java.io.*;
public class Solution_2178_MazeSearch {
	public static int n,m;
	public static int[] di= {-1,1,0,0},dj= {0,0,-1,1};
	public static int[][] arr;
	public static boolean[][] v;
	public static void bfs(int i, int j) {
		v[i][j]=true;
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] curr= q.poll();
			
			for(int k=0;k<4;k++) {
				int ni=curr[0]+di[k];
				int nj=curr[1]+dj[k];
			
				if(ni>=0 && nj>=0 && ni<n && nj<m && v[ni][nj]==false && arr[ni][nj]!=0) {
					q.offer(new int[] {ni,nj});
					arr[ni][nj]=arr[curr[0]][curr[1]]+1;
					v[ni][nj]=true;
				}
				
			}
			
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int[n][m];
		v=new boolean[n][m];
		for(int i=0;i<n;i++) {
			char[] temp=new char[n];
			temp=br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				arr[i][j]=temp[j]-'0';
			}
		}
		
		bfs(0,0);
		System.out.println(arr[n-1][m-1]);
	}

}
