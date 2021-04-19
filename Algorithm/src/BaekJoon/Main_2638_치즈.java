package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_2638_치즈 {

	static int N,M,time;
	static int[][] arr;
	static int[] dr= {-1,1,0,0}, dc= {0,0,-1,1};
	static int[][] v;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N][M];
		v=new int[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		while(isCheese()) {
			checkAir(0,0);
			checkCheese();
			melt();
		}
		
		System.out.println(time);
	}
	
	// 치즈 내부 공간은 외부공기와 접촉X, 공기를 기준으로 dfs
	public static void checkAir(int r,int c) {
		v[r][c]=-1; // 외부공기이면 v배열을 -1로 
		
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M && v[nr][nc]!=-1 && arr[nr][nc]==0) {
				checkAir(nr,nc);
			}
		}
	}
		
	// 녹일 치즈 찾기
	public static void checkCheese() { 
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1) { // 치즈인 부분만 확인
					for(int k=0;k<4;k++) {
						int nr=i+dr[k];
						int nc=j+dc[k];
						
						if(nr>=0 && nr<N && nc>=0 && nc<M && v[nr][nc]==-1) { 
							v[i][j]++; // 외부공기와 닿아있으면 v배열을 하나씩 증가
						}
					}
				}
			}
		}
		
		
	}
	
	// 치즈를 녹임
	public static void melt() {
		time++; // 치즈 녹일때마다 시간 증가
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1 && v[i][j]>=2) { // 외부공기가 닿은 부분이 2면 이상일때
					arr[i][j]=0; // 치즈를 녹인다
				}
			}
		}
		v=new int[N][M]; // 여기서 방문배열을 초기화시켜준다(치즈가 남아있을 경우 또 사용해야함)
	}
	
	// 치즈가 남아있나 확인
	public static boolean isCheese() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1) return true;
			}
		}
		
		return false;
	}

}
