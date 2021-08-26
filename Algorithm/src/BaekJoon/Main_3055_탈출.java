package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_3055_탈출 {

	static int R,C,cnt;
	static char[][] arr;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	static Queue<int[]> water,move;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr=new char[R][C];
		water=new LinkedList<>();
		move=new LinkedList<>();
		for(int i=0;i<R;i++) {
			String s=br.readLine();
			for(int j=0;j<C;j++) {
				arr[i][j]=s.charAt(j);
				if(arr[i][j]=='*') {
					water.offer(new int[] {i,j});
				}
				else if(arr[i][j]=='S') {
					move.offer(new int[] {i,j});
				}
				
			}
		}
		
		bfs();
		if(cnt==0) System.out.println("KAKTUS");
		else System.out.println(cnt);
		
	}
	
	
	public static void bfs() {
		L:while(true) {
			cnt++;
			int waterSize=water.size();
			for(int k=0;k<waterSize;k++) {
				int[] curr1=water.poll();
				
				for(int i=0;i<4;i++) {
					int nr=curr1[0]+dr[i];
					int nc=curr1[1]+dc[i];
					
					if(nr>=0 && nc>=0 && nr<R && nc<C && arr[nr][nc]=='.') {
						water.offer(new int[] {nr,nc});
						arr[nr][nc]='*';
					}
				
				}
			}
			
			int moveSize=move.size();
			if(moveSize==0) {
				cnt=0;
				break L;
			}
				
		
			for(int k=0;k<moveSize;k++) {
				int[] curr2=move.poll();
		
				for(int i=0;i<4;i++) {
					int nr=curr2[0]+dr[i];
					int nc=curr2[1]+dc[i];
					
					
					if(nr>=0 && nc>=0 && nr<R && nc<C && (arr[nr][nc]=='.'||arr[nr][nc]=='D')) {
						if(arr[nr][nc]=='D') {
							break L;
						}
						arr[nr][nc]='S';
						move.offer(new int[] {nr,nc});
					}
				}
			}
			
		}
	}	

}
