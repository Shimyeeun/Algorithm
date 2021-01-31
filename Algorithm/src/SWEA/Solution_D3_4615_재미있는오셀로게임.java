package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D3_4615_재미있는오셀로게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[] dr= {-1,-1,-1,0,1,1,1,0},dc= {-1,0,1,1,1,0,-1,-1};
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			
			char[][] arr=new char[N][N];
			arr[N/2-1][N/2-1]='W';
			arr[N/2-1][N/2]='B';
			arr[N/2][N/2-1]='B';
			arr[N/2][N/2]='W';

			for(int i=0;i<M;i++) {
				StringTokenizer s=new StringTokenizer(br.readLine());
				int r=Integer.parseInt(s.nextToken());
				int c=Integer.parseInt(s.nextToken());
				int stone=Integer.parseInt(s.nextToken());
				int cnt=0;
				
				for(int j=0;j<N;j++) {
					for(int k=0;k<N;k++) {
						if(arr[j][k]=='W'||arr[j][k]=='B') {
							cnt++;
						}
					}
				}
				
				if(cnt==N*N) break;
				
				if(stone==1) {
					arr[r-1][c-1]='B';
					for(int j=0;j<8;j++) {
						int nr=r-1+dr[j];
						int nc=c-1+dc[j];
						
						if(nr>=0 && nc>=0 && nr<N && nc<N && arr[nr][nc]=='W') {
							int loop=1;
							int nnr=nr+dr[j];
							int nnc=nc+dc[j];
							for(int k=0;k<N;k++) {
								if(nnr>=0&&nnc>=0&&nnr<N&&nnc<N&&arr[nnr][nnc]=='W') {
									loop++;
									nnr=nnr+dr[j];
									nnc=nnc+dc[j];
								}
								else if(nnr>=0&&nnc>=0&&nnr<N&&nnc<N&&arr[nnr][nnc]=='B') {
									while(loop>0) {
										arr[nnr-dr[j]][nnc-dc[j]]='B';
										nnr=nnr-dr[j];
										nnc=nnc-dc[j];
										loop--;
									}
									break;
								}
								else {
									break;
								}
								
							}
						}
					}
				}
				else {
					arr[r-1][c-1]='W';
					for(int j=0;j<8;j++) {
						int nr=r-1+dr[j];
						int nc=c-1+dc[j];
						
						if(nr>=0 && nc>=0 && nr<N && nc<N && arr[nr][nc]=='B') {
							int loop=1;
							int nnr=nr+dr[j];
							int nnc=nc+dc[j];
							for(int k=0;k<N;k++) {
								if(nnr>=0&&nnc>=0&&nnr<N&&nnc<N&&arr[nnr][nnc]=='B') {
									loop++;
									nnr=nnr+dr[j];
									nnc=nnc+dc[j];
								}
								else if(nnr>=0&&nnc>=0&&nnr<N&&nnc<N&&arr[nnr][nnc]=='W') {
									while(loop>0) {
										arr[nnr-dr[j]][nnc-dc[j]]='W';
										nnr=nnr-dr[j];
										nnc=nnc-dc[j];
										loop--;
									}
									break;
								}
								else {
									break;
								}
								
							}
						}
					}
				}
				
				
				
			}
			
			
			int bcnt=0;
			int wcnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]=='W') {
						wcnt++;
					} else if(arr[i][j]=='B') {
						bcnt++;
					}
				}
			}
			
			System.out.println("#"+t+" "+bcnt+" "+wcnt);
			
		}
		

	}

}
