package BaekJoon;
import java.io.*;

public class Main_16113_시그널 {
	static int[][] arr;
	static int N,area;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	static boolean[][] v;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		sb=new StringBuilder();
		
		N=Integer.parseInt(br.readLine());
		String s=br.readLine();
		arr=new int[5][N/5];
		v=new boolean[5][N/5];
		int cnt=0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<N/5;j++) {
				if(s.charAt(cnt)=='#') {
					arr[i][j]=1;
				}else {
					arr[i][j]=0;
				}
				cnt++;
			}
		}
		
		for(int i=0;i<N/5;i++) {
			area=1;
			if(arr[0][i]==1) {
				dfs(0,i);
			}
			else continue;
			check(area,0,i);
			if(sb.length()>0&&sb.charAt(sb.length()-1)!='1') {
				i+=2;
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int r,int c) {
		v[r][c]=true;
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(nr>=0 && nr<5 && nc>=0 && nc<N/5 && !v[nr][nc] && arr[nr][nc]==1) {
				area++;
				dfs(nr,nc);
			}
		}
	}
	
	public static void check(int count,int r,int c) {
		if(count==5) sb.append(1);
		else if(count==9) sb.append(4);
		else if(count==7) sb.append(7);
		else if(count==13) sb.append(8);
		else if(count==12) {
			if(arr[r+2][c+1]==0) sb.append(0);
			else if(arr[r+1][c+2]==0) sb.append(6);
			else if(arr[r+3][c]==0) sb.append(9);
		}
		else if(count==11) {
			if(arr[r+3][c+2]==0) sb.append(2);
			else if(arr[r+1][c+2]==0) sb.append(5);
			else sb.append(3);
		}
	}

}
