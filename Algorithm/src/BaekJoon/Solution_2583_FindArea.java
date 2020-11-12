package BaekJoon;
import java.util.*;
import java.io.*;
public class Solution_2583_FindArea {
	public static int m,n,area,cnt;
	public static ArrayList<Integer> cntlist;
	public static int[] di= {-1,1,0,0},dj= {0,0,-1,1};
	public static void dfs(int i, int j,int[][] arr) {
		cnt++;
		arr[i][j]=1;
		
		for(int k=0;k<4;k++) {
			int ni=i+di[k];
			int nj=j+dj[k];
			
			if(ni>=0 && nj>=0 && ni<m && nj<n && arr[ni][nj]==0 ) {
				dfs(ni,nj,arr);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		int[][] arr=new int[m][n];
		
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());
			int lX=Integer.parseInt(st.nextToken());
			int lY=Integer.parseInt(st.nextToken());
			int rX=Integer.parseInt(st.nextToken());
			int rY=Integer.parseInt(st.nextToken());
			
			for(int j=m-rY;j<m-lY;j++) {
				for(int l=lX;l<=(rX-1);l++) {
					arr[j][l]=1;
				}
			}
			
			
		}
		cntlist=new ArrayList<>();
		area=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				cnt=0;
				if(arr[i][j]==0) {
					area++;
					dfs(i,j,arr);
					cntlist.add(cnt);
				}
			}
		}
		
		Collections.sort(cntlist);
		System.out.println(area);
		for(int i=0;i<cntlist.size();i++) {
			System.out.print(cntlist.get(i)+" ");
		}
		
		

	}

}
