package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1987_알파벳 {
	static int R,C,cnt=1;
	static char[][] arr;
	static boolean[] v;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	static int max=1;
	public static void dfs(int r,int c) {
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(nr>=0 && nr<R && nc>=0 && nc<C && !v[arr[nr][nc]-65]) {
				v[arr[nr][nc]-65]=true;
				cnt++;
				dfs(nr,nc);
				max=Math.max(max, cnt);
				cnt--;
				v[arr[nr][nc]-65]=false;
			}
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr=new char[R][C];
		v=new boolean[26];
		
		for(int i=0;i<R;i++) {
			String s=br.readLine();
			for(int j=0;j<C;j++) {
				arr[i][j]=s.charAt(j);
			}
		}
		
		v[arr[0][0]-65]=true;
		dfs(0,0);
		System.out.println(max);

	}

}
