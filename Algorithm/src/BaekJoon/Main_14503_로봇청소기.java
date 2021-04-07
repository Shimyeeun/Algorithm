package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_14503_로봇청소기 {

	static int N,M,cnt;
	static int[][] arr;
	static boolean[][] v;
	static int[] dr= {-1,0,1,0},dc= {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N][M];
		v=new boolean[N][M];
		st=new StringTokenizer(br.readLine());
		int startr=Integer.parseInt(st.nextToken());
		int startc=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(startr,startc,d); //로봇청소기가 있는 칸부터 시작
		System.out.println(cnt);
		

	}
	
	
	public static void dfs(int r,int c,int d) {
		if(arr[r][c]==0) { // 현재위치가 0이면 청소
			cnt++; // 청소한 칸수 증가
			arr[r][c]=2; // 청소했다고 표시			
		}
		
		// 네 방향에 청소할 공간이 없거나 벽일 경우
		if(arr[r+1][c]!=0 && arr[r-1][c]!=0 && arr[r][c+1]!=0 && arr[r][c-1]!=0) {
			// 후진할 칸이 벽인지 아닌지 확인
			if(arr[r-dr[d]][c-dc[d]]==2) {
				dfs(r-dr[d],c-dc[d],d); // 벽이 아닐 경우 후진
			}
			else {
				return; // 벽일 경우 리턴
			}
		}
		// 네 방향에 청소할 공간이 있을 경우
		else {
			if(d!=0) { 
				if(arr[r+dr[d-1]][c+dc[d-1]]==0) { //왼쪽 방향이 청소가 안되어있을경우
					dfs(r+dr[d-1],c+dc[d-1],d-1); // 회전하고 전진
				} 
				else { //청소가 되어 있을 경우
					dfs(r,c,d-1); // 회전만
				}
			}
			else { //북쪽을 향할때만 따로 봐줌
				if(arr[r+dr[3]][c+dc[3]]==0) { // 왼쪽방향이 청소가 안되어있을경우
					dfs(r+dr[3],c+dc[3],3); // 회전하고 전진
				}
				else { //청소가 되어 있을 경우
					dfs(r,c,3); //회전만
				}
			}
		}
		
	}


}
