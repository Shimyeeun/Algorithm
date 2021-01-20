package BaekJoon;
import java.util.*;
import java.io.*;
public class Solution_7562_나이트의이동 {
	public static int n,starti,startj,endi,endj;
	public static int[][] arr,v;
	public static int[] di= {-2,-2,-1,1,2,2,1,-1}, dj= {-1,1,2,2,1,-1,-2,-2};
	public static void bfs(int i, int j) {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {i,j});
		v[i][j]=1;
		while(!q.isEmpty()) {
			int[] curr=q.poll();
			
			for(int k=0;k<8;k++) {
				int ni=curr[0]+di[k];
				int nj=curr[1]+dj[k];
				
				if(ni>=0 && nj>=0 && ni<n && nj<n && v[ni][nj]==0) {
					arr[ni][nj]=arr[curr[0]][curr[1]]+1;
					q.offer(new int[] {ni,nj});
					v[ni][nj]=1;
					if(ni==endi&&nj==endj) {
						q.clear();
						break;
					}
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			n=Integer.parseInt(br.readLine());
			arr=new int[n][n];
			v=new int[n][n];
			StringTokenizer st= new StringTokenizer(br.readLine());
			starti=Integer.parseInt(st.nextToken());
			startj=Integer.parseInt(st.nextToken());
			StringTokenizer s= new StringTokenizer(br.readLine());
			endi=Integer.parseInt(s.nextToken());
			endj=Integer.parseInt(s.nextToken());
			bfs(starti,startj);
			System.out.println(arr[endi][endj]);
		}

	}

}
