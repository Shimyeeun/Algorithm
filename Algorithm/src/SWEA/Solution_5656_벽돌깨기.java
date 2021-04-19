package SWEA;
import java.util.*;
import java.io.*;
public class Solution_5656_벽돌깨기 {
	
	static int N,W,H,min;
	static int[][] arr;
	static int[] dr= {-1,1,0,0}, dc= {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			arr=new int[H][W];
			min=Integer.MAX_VALUE;
			for(int i=0;i<H;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			bead(0,arr);
			
			if(min==Integer.MAX_VALUE) min=0;
			System.out.println("#"+t+" "+min);
		}
	}
	
	public static void copy(int[][] arr1,int[][] arr2) {
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				arr2[i][j]=arr1[i][j];
			}
		}
	}
	public static void bead(int cnt,int[][] arr) {
		
		if(cnt==N) {
			int brick=0;
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(arr[i][j]!=0) brick++;
				}
			}
			
			min=Math.min(brick, min);
			
			return;
		}
		
		for(int i=0;i<W;i++) {
			int j=0;
			
			while(j<H) {
				if(arr[j][i]!=0) break;
				j++;
			}
			
			if(j==H) continue;
			
			int[][] copy=new int[H][W];
			copy(arr,copy);
			crush(j,i,copy);
			down(copy);
			bead(cnt+1,copy);
		}
	}
	
	public static void crush(int r,int c,int[][] arr) {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {r,c,arr[r][c]});
		arr[r][c]=0;
		
		while(!q.isEmpty()) {
			int[] curr=q.poll();
			
			for(int i=0;i<4;i++) {		
				int nr=curr[0];
				int nc=curr[1];
				for(int j=0;j<curr[2]-1;j++) {
					nr+=dr[i];
					nc+=dc[i];
					
					if(nr>=0 && nr<H && nc>=0 && nc<W && arr[nr][nc]>0) {
						
						if(arr[nr][nc]>1) {
							q.offer(new int[] {nr,nc,arr[nr][nc]});			
						}
						arr[nr][nc]=0;							
					}
				}
				
			}
		}
	}
	
	public static void down(int[][] arr) {
		for(int j=0;j<W;j++) {
			L: for(int i=H-1;i>0;i--) {
				int k=i;
				while(k>=0 && arr[k][j]==0) {
					if(k==0) break L;
					k--;
				}
				arr[i][j]=arr[k][j];
				if(i!=k) arr[k][j]=0;
			}
		}
	}

}
