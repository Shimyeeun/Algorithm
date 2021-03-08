package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_11559_PuyoPuyo {
	
	static char[][] arr;
	static boolean[][] v;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	static int area,cnt;
	static ArrayList<int[]> poppuyo;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		arr=new char[12][6];
		poppuyo=new ArrayList<>();
		for(int i=0;i<12;i++) {
			String s=br.readLine();
			for(int j=0;j<6;j++) {
				arr[i][j]=s.charAt(j);
			}
		}
		
		check();
		System.out.println(cnt);

	}
	
	public static void check() {
		v=new boolean[12][6];
		int flag=0;
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				area=1;
				poppuyo.clear();
				if(arr[i][j]!='.'&&!v[i][j]) {
					
					dfs(i,j);
					if(area>=4) {
						flag=1;
						pop();
					}
				}
			}
		}
		if(flag==1) {
			cnt++;
			down();
			check();
		}
	}
	
	public static void pop() {
		for(int i=0;i<poppuyo.size();i++) {
			arr[poppuyo.get(i)[0]][poppuyo.get(i)[1]]='.';
		}
	}
	public static void down() {
	
		for(int j=0;j<6;j++) {
			L: for(int i=11;i>=1;i--) {
				int k=i;
				while(k>=0&&arr[k][j]=='.') {
					if(k==0) break L;
					k--;
				}
				
				arr[i][j]=arr[k][j];
				if(i!=k) arr[k][j]='.';
				
			}
		}
		
		
	}
	public static void dfs(int r,int c) {
		v[r][c]=true;
		poppuyo.add(new int[] {r,c});
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(nr>=0 && nr<12 && nc>=0 && nc<6 && !v[nr][nc] && arr[nr][nc]==arr[r][c]) {
				area++;
				dfs(nr,nc);
			}
		}
	}

}
