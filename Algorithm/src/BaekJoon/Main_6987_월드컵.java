package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_6987_월드컵 {

	static int[] team1= {0,0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int[] team2= {0,1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static int[][] arr;
	static boolean possible;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		arr=new int[4][19];
		
		
		for(int i=0;i<4;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=1;j<=18;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<4;i++) {
			int check=0;
			possible=false;
			for(int j=1;j<=16;j+=3) {
				if(arr[i][j]+arr[i][j+1]+arr[i][j+2]>5) {
					check=1;
					break;
				}
			}
			if(check==1) {
				sb.append(0+" ");
				continue;
			}
			else {
				play(i,1);
				if(possible) {
					sb.append(1+" ");
				}
				else {
					sb.append(0+" ");
				}
			}
		}
		System.out.println(sb.toString());
		
		
	}
	
	public static void play(int r,int gamecnt) {
		if(gamecnt==16) {
			possible=true;
			return;
		}
		int t1=3*team1[gamecnt]+1;
		int t2=3*team2[gamecnt]+1;
		
		if(arr[r][t1]>0&&arr[r][t2+2]>0) {
			arr[r][t1]--;
			arr[r][t2+2]--;
			play(r,gamecnt+1);
			arr[r][t1]++;
			arr[r][t2+2]++;
		}
		
		if(arr[r][t1+1]>0&&arr[r][t2+1]>0) {
			arr[r][t1+1]--;
			arr[r][t2+1]--;
			play(r,gamecnt+1);
			arr[r][t1+1]++;
			arr[r][t2+1]++;
		}
		
		if(arr[r][t1+2]>0&&arr[r][t2]>0) {
			arr[r][t1+2]--;
			arr[r][t2]--;
			play(r,gamecnt+1);
			arr[r][t1+2]++;
			arr[r][t2]++;
		}
		
		
	}
}
