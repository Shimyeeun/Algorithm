package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_16926_배열돌리기1 {
	static int N,M,temp;
	static int[][] arr,res;
	public static void left(int r,int c) {
		for(int i=r;i<c-1;i++) {
			res[r][i]=arr[r][i+1];
		}
	}
	
	public static void down(int r,int c) {
		for(int i=c;i<r-1;i++) {
			res[i+1][c]=arr[i][c];
		}
	}
	
	public static void right(int r,int c) {
		for(int i=r;i<c-1;i++) {
			res[N-1-r][i+1]=arr[N-1-r][i];
		}
	}
	
	public static void up(int r,int c) {
		for(int i=c;i<r-1;i++) {
			res[i][M-1-c]=arr[i+1][M-1-c];
		}
	}
	
	public static void copy(int[][] a, int[][] b) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				b[i][j]=a[i][j];
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		res=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		copy(arr,res);
		for(int t=0;t<R;t++) {
			int cnt=Math.min(N/2, M/2);
			
			for(int i=0;i<cnt;i++) {
				left(i,M-i);
				down(N-i,i);
				right(i,M-i);
				up(N-i,i);
			
			}
			copy(res,arr);
			
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(res[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}

}
