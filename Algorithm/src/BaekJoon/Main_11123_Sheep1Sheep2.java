package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_11123_Sheep1Sheep2 {
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	public static int H,W,cnt;
	
	public static void dfs(int i, int j, char[][] arr) {
		arr[i][j]='.';
		
		for(int k=0;k<4;k++) {
			int ni=i+di[k];
			int nj=j+dj[k];
			
			if(ni>=0 && nj>=0 && ni<H && nj<W && arr[ni][nj]=='#') {
				dfs(ni,nj,arr);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			H=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			char[][] arr=new char[H][W];
			
			for(int j=0;j<H;j++) {
		         char[] temp=new char[H];
		         temp=br.readLine().toCharArray();
		         for(int k=0;k<W;k++) {
		            arr[j][k]=temp[k];	            
		         }
			}
			cnt=0;
			for(int j=0;j<H;j++) {
				for(int k=0;k<W;k++) {
					if(arr[j][k]=='#') {
						cnt++;
						dfs(j,k,arr);
					}
				}
			}
			
			System.out.println(cnt);
			
		     
		}
		
		

	}

}
