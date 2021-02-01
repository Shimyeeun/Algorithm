package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_7576_Tomato {
	public static int n,m,fi,fj,max=0;
	public static int[] di= {-1,1,0,0},dj= {0,0,-1,1};
	public static int[][] arr;
	public static boolean[][] v;
	public static Queue<int[]> q;
	public static void bfs(int i, int j) {
		v[i][j]=true;

		while(!q.isEmpty()) {
			int[] curr=q.poll();
			for(int k=0;k<4;k++) {
				int ni=curr[0]+di[k];
				int nj=curr[1]+dj[k];
				
				if(ni>=0 && nj>=0 && ni<n && nj<m && v[ni][nj]==false && arr[ni][nj]==0 ) {
					q.offer(new int[] {ni,nj});
					v[ni][nj]=true;
					arr[ni][nj]=arr[curr[0]][curr[1]]+1;		
					if(arr[ni][nj]>=max) {
						max=arr[ni][nj];
					}
				}		
			}			
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int ti=0,tj=0;
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		arr=new int[n][m];
		v=new boolean[n][m];
		q=new LinkedList<>();
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					ti=i;
					tj=j;
					q.offer(new int[] {i,j});
				}
			
			}
		}
		bfs(ti,tj);		
		
		int check=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					check=-1;
				}
			}
		}
		
		if(check==-1) {
			System.out.println(check);
		}
		else {
			if(max==0) {
				System.out.println(max);
			}
			else {
				System.out.println(max-1);
			}
		}
	}
}
