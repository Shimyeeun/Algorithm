package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_2665_미로만들기 {

	static int n;
	static int[][] arr;
	static int[][] v;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		arr=new int[n][n];
		v=new int[n][n];
		for(int i=0;i<n;i++) {
			String s=br.readLine();
			for(int j=0;j<n;j++) {
				arr[i][j]=s.charAt(j)-'0';
				v[i][j]=Integer.MAX_VALUE;
			}
		}
		
		bfs(0,0);
		System.out.println(v[n-1][n-1]);
	}
	
	public static void bfs(int r,int c) {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {r,c});
		v[r][c]=0;
		while(!q.isEmpty()) {
			int[] curr=q.poll();
			
			for(int i=0;i<4;i++) {
				int nr=curr[0]+dr[i];
				int nc=curr[1]+dc[i];
				
				if(nr>=0 && nc>=0 && nr<n && nc<n) {
					if(arr[nr][nc]==0) {
						if(v[nr][nc]>v[curr[0]][curr[1]]+1) {
							v[nr][nc]=v[curr[0]][curr[1]]+1;
							q.offer(new int[] {nr,nc});
						}
					}
					else {
						if(v[nr][nc]>v[curr[0]][curr[1]]) {
							v[nr][nc]=v[curr[0]][curr[1]];
							q.offer(new int[] {nr,nc});
						}
					}
				}
			}
		}
	}

}
