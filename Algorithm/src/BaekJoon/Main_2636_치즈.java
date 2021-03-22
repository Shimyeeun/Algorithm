package BaekJoon;
import java.util.*;
import java.io.*;

public class Main_2636_치즈 {

	static int R,C,cheese,cnt;
	static int[][] arr;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	static boolean[][] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr=new int[R][C];
		int time=0;
		
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				int status=Integer.parseInt(st.nextToken());
				arr[i][j]=status;
				if(status==1) {
					cheese++;
				}
			}
		}
				
		while(cheese>0) {
			time++;
			v=new boolean[R][C];
			checkAir(0,0);
			melt();
		}
		
		System.out.println(time);
		System.out.println(cnt);
	}
	
	public static void melt() {
		cnt=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j]==2) {
					arr[i][j]=3;
					cnt++;
				}
			}
		}
		
		cheese-=cnt;
		
	}
	public static void checkAir(int r,int c) {
		
		
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(nr>=0 && nc>=0 && nr<R && nc<C && !v[nr][nc]) {
				v[nr][nc]=true;
				if(arr[nr][nc]==0 || arr[nr][nc]==3) {
					arr[nr][nc]=3;
					checkAir(nr,nc);
				}
				else if(arr[nr][nc]==1){
					arr[nr][nc]=2;
				}
			}
		
		}
		
	}

}
