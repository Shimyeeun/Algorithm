package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_21610_마법사상어와비바라기 {

	static int N,M;
	static int[][] arr, move,cloud;
	static int[] dr= {0,0,-1,-1,-1,0,1,1,1},dc= {0,-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N+1][N+1];
		move=new int[M][2];
		cloud=new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			move[i][0]=Integer.parseInt(st.nextToken());
			move[i][1]=Integer.parseInt(st.nextToken());
		}
		
		// 초기 구름 설정		
		cloud[N][1]=1;
		cloud[N][2]=1;
		cloud[N-1][1]=1;
		cloud[N-1][2]=1;
		
		for(int i=0;i<M;i++) {
			cloudMove(move[i][0],move[i][1]); // 구름이동			 
			rain(); // 비내리기
			for(int k=1;k<=N;k++) {
				for(int j=1;j<=N;j++) {
					if(cloud[k][j]==-1) { // 구름이 있던 곳에
						watercopy(k,j); //물복사버그마법
					}
				}
			}
			addcloud(); // 구름생성, 물의 양 2씩 줄어듦
		}
		System.out.println(watercnt());
		
		
	}
	public static void copy(int[][] arr1, int[][] arr2) {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr1[i][j]=arr2[i][j];
			}
		}
	}
	
//	구름이동
	public static void cloudMove(int d,int s) {
		int[][] cloudtemp=new int[N+1][N+1]; // 구름이 이동할 때 원래 구름이 있던 자리로 해야되기 때문에 copy
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(cloud[i][j]==1) {
					int nr=i+(s*dr[d])%N; // 나머지를 이용해서 이동거리 구해줌
					int nc=j+(s*dc[d])%N; 
					
					// 경우에 따라서 구름 이동
					if(nr<=0) {
						if(nc<=0) {
							cloudtemp[N+nr][N+nc]=1;
						}
						else if(nc>=N+1) {
							cloudtemp[N+nr][nc-N]=1;
						}
						else {
							cloudtemp[nr+N][nc]=1;
						}
					}
					else if(nc<=0) {
						if(nr>=N+1) {
							cloudtemp[nr-N][N+nc]=1;
						}
						else {
							cloudtemp[nr][N+nc]=1;							
						}
					}
					else if(nr>=N+1) {
						if(nc>=N+1) {
							cloudtemp[nr-N][nc-N]=1;
						}
						else {
							cloudtemp[nr-N][nc]=1;								
						}
					}
					else if(nc>=N+1) {
						cloudtemp[nr][nc-N]=1;
					} 
					else {
						cloudtemp[nr][nc]=1;
					}
					
				}
			}
		}
		
		copy(cloud,cloudtemp); // 모두 이동 후 원래 구름배열로 copy
	}
	
// 비내리기
	public static void rain() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(cloud[i][j]==1) { //구름이 있는 곳에 비가 내려
					arr[i][j]++; // 물의 양 1증가
					cloud[i][j]=-1; // 구름이 있던 곳 표시
				}
			}
		}
	}
	
//	물복사버그 마법
	public static void watercopy(int r,int c) {
		int cnt=0;
		for(int i=2;i<=8;i+=2) { // 대각선 방향만 확인하기 위해 i를 2씩 증가시켜줌
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(nr>0 && nr<=N && nc>0 && nc<=N && arr[nr][nc]>0) {
				cnt++; // 대각선방향으로 물이 있는 바구니 수 카운트
			}
		}
		arr[r][c]+=cnt; // 구름있던 자리에 물의 양을 물이 있는 바구니 수만큼 증가
	}
	
//	구름 생성 및 물의 양 2씩 감소
	public static void addcloud() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(arr[i][j]>=2 && cloud[i][j]!=-1) { //물의 양이 2이상이고 구름이 없었던 자리에
					cloud[i][j]=1; // 구름 생성
					arr[i][j]-=2; // 물의 양 2 감소
				}
				else if(cloud[i][j]==-1) {
					cloud[i][j]=0; // 원래 있었던 구름을 0으로 초기화
				}
			}
		}
	}
	
//	물의양 세기
	public static int watercnt() {
		int sum=0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(arr[i][j]>0) {
					sum+=arr[i][j];
				}
			}
		}
		return sum;
	}
}
