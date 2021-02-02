package SWEA;
import java.io.*;
public class Solution_D2_1954_달팽이숫자 {
	
	static int[][] arr;
	static int N,d,cnt;
	
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	public static void snail(int r,int c) {
		if(arr[r][c]!=0) return;
		
		arr[r][c]=cnt;
		
		if(d==3&& c<N){
			if(c+1==N) d=1;
			else {
				if(arr[r][c+1]!=0) d=1;
			}
		} else if(d==1 && r<N) {
			if(r+1==N) d=2;
			else {
				if(arr[r+1][c]!=0) d=2;
			}
		} else if(d==2 && c>=0) {
			if(c==0) d=0;
			else {
				if(arr[r][c-1]!=0) d=0;
			}
		} else if(d==0 && r>=0) {
			if(r==0) d=3;
			else {
				if(arr[r-1][c]!=0) d=3;
			}
		}
		
		int nr=r+dr[d];
		int nc=c+dc[d];
		
		if(nr>=0 && nc>=0 && nr<N && nc< N) {
			cnt++;
			snail(nr,nc);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			
			arr=new int[N][N];
			cnt=1;
			d=3;
			snail(0,0);
			
			System.out.println("#"+t);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}

}
