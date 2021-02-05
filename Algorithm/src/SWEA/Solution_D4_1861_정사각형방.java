package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D4_1861_정사각형방 {
	static int N,cnt;
	static int[][] arr;
	static boolean[][] v;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	public static void move(int r, int c) {
		
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && arr[nr][nc]==arr[r][c]+1) {
				cnt++;
				v[nr][nc]=true;
				move(nr,nc);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			arr=new int[N][N];
			v=new boolean[N][N];
			int roomnum=Integer.MAX_VALUE;
			int ans=Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]>=1&&!v[i][j]) {
						cnt=1;
						move(i,j);
						if(cnt!=1&&cnt>ans) {
							ans=cnt;
							roomnum=arr[i][j];
						} else if(cnt!=1&&cnt==ans) {
							if(roomnum>arr[i][j]) {
								roomnum=arr[i][j];
							}
						}
					}
				}
			}
			
			System.out.println("#"+t+" "+roomnum +" "+ ans);
		}
		
	

	}

}
