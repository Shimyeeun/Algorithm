package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_17406_배열돌리기4 {

	static int N,M,ans;
	static int[][] arr,res,original;
	static boolean[] v;
	static int[] sel;
	static rotate[] ro;
	
	static class rotate {
		int r,c,s;
		rotate(int r, int c,int s){
			this.r=r;
			this.c=c;
			this.s=s;
		}
		
	}
	public static void copy(int[][] a, int[][] b) {
		for(int i=0;i<N+1;i++) {
			for(int j=0;j<M+1;j++) {
				b[i][j]=a[i][j];
			}
		}
	}
	
	public static void left(int r,int c,int s) {
		for(int i=c-s;i<c+s;i++) {
			res[r+s][i]=arr[r+s][i+1];
		}
	}
	
	public static void down(int r,int c,int s) {
		for(int i=r-s;i<r+s;i++) {
			res[i+1][c+s]=arr[i][c+s];
		}
	}
	
	public static void right(int r,int c,int s) {
		for(int i=c-s;i<c+s;i++) {
			res[r-s][i+1]=arr[r-s][i];
		}
	}
	
	public static void up(int r,int c, int s) {
		for(int i=r-s;i<r+s;i++) {
			res[i][c-s]=arr[i+1][c-s];
		}
	}
	
	public static void permutation(int cnt) {
		if(cnt==sel.length) {
			copy(original,arr);
			copy(original,res);
			for(int i=0;i<sel.length;i++) {
				int r=ro[sel[i]].r;
				int c=ro[sel[i]].c;
				int s=ro[sel[i]].s;
				
				for(int k=0;k<s;k++) {
					right(r,c,s-k);
					down(r,c,s-k);
					left(r,c,s-k);
					up(r,c,s-k);
				}
				
				copy(res,arr);
				
			}
			for(int j=1;j<=N;j++) {
				int sum=0;
				for(int k=1;k<=M;k++) {
					sum+=res[j][k];
				}
				ans=Math.min(ans, sum);
			}
			return;
		}
		
		for(int i=0;i<ro.length;i++) {
			if(v[i]==false) {
				v[i]=true;
				sel[cnt]=i;
				permutation(cnt+1);
				v[i]=false;
			}
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		ans=Integer.MAX_VALUE;
		original=new int[N+1][M+1];
		arr=new int[N+1][M+1];
		res=new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				int a=Integer.parseInt(st.nextToken());
				arr[i][j]=a;
				original[i][j]=a;
				res[i][j]=a;
			}
		}
		
		ro=new rotate[K];
		sel=new int[K];
		v=new boolean[K];
		for(int t=0;t<K;t++) {
			
			StringTokenizer st2=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st2.nextToken());
			int c=Integer.parseInt(st2.nextToken());
			int s=Integer.parseInt(st2.nextToken());
		
			ro[t]=new rotate(r,c,s);
			
		}
		
		permutation(0);
		
		System.out.println(ans);
	}

}
