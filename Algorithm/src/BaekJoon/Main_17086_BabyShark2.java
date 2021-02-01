package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_17086_BabyShark2 {
	public static int n,m,max=0;
	public static int[][] arr;
	public static boolean[][] v;
	public static int[] di= {-1,1,0,0,-1,-1,1,1},dj= {0,0,-1,1,-1,1,1,-1};
	public static Queue<int[]> q;
	public static void bfs(int i, int j) {
		
		v[i][j]=true;
		while(!q.isEmpty()) {
			int curr[]=q.poll();
			
			for(int k=0;k<8;k++) {
				int ni=curr[0]+di[k];
				int nj=curr[1]+dj[k];
				
				if(ni>=0 && nj>=0 & ni<n && nj<m && arr[ni][nj]==0 && v[ni][nj]==false) {
					q.offer(new int[] {ni,nj});
					arr[ni][nj]=arr[curr[0]][curr[1]]+1;
					v[ni][nj]=true;
					if(arr[ni][nj]>=max) {
						max=arr[ni][nj];
					}
				}
				
				
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		q=new LinkedList<>();
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr=new int[n][m];
		v=new boolean[n][m];
		int starti=0;
		int startj=0;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					q.offer(new int[] {i,j});
					starti=i;
					startj=j;
				}
			}
			
		}
		
		bfs(starti,startj);
		System.out.println(max-1);

	}

}
