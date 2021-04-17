package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D4_7699_수지의수지맞는여행 {
	
	static int R,C,cnt,max;
	static char[][] arr;
	static boolean[] alphabet;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	static String visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			
			arr=new char[R][C];
			visited="";
			cnt=1;
			max=1;
			alphabet=new boolean[26];
			for(int i=0;i<R;i++) {
				String s=br.readLine();
				for(int j=0;j<C;j++) {
					arr[i][j]=s.charAt(j);
				}
			}

			dfs(0,0);
			System.out.println("#"+t+" "+max);
		}
		
		
	}
	
	public static void dfs(int r,int c) {
		alphabet[arr[r][c]-'A']=true;
		max=Math.max(max, cnt);
		
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(nr>=0 && nr<R && nc>=0 && nc<C && !alphabet[arr[nr][nc]-'A']) {
				cnt++;
				dfs(nr,nc);
				cnt--;
				alphabet[arr[nr][nc]-'A']=false;
			}
				
		}
	}

}
