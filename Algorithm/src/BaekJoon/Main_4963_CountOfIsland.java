package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_4963_CountOfIsland {
	public static int w,h;
	public static int land;
	public static int[] dx= {-1,1,0,0,1,1,-1,-1};
	public static int[] dy= {0,0,-1,1,1,-1,1,-1};
	public static void dfs(int i, int j, int[][] arr) {
		arr[i][j]=0;
		
		for(int k=0;k<8;k++) {
			int nx=i+dx[k];
			int ny=j+dy[k];
			
			if(nx>=0 && ny>=0 && nx<h && ny<w && arr[nx][ny]==1) {
				dfs(nx,ny,arr);
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		while(true) {

			w=sc.nextInt();
			h=sc.nextInt();
			if(w==0||h==0) {
				break;
			}
			land=0;
			int[][] arr=new int[h][w];
			for(int i=0;i<h;i++) {
				
				for(int j=0;j<w;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(arr[i][j]==1) {
						land++;
						dfs(i,j,arr);
					}
				}
			}
			
			System.out.println(land);
		}
		

	}
}
