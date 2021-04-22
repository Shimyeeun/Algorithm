package SWEA;
import java.util.*;
import java.io.*;
public class Solution_4013_특이한자석 {

	static int[][] magnet;
	static int[][] turn;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int K=Integer.parseInt(br.readLine());
			magnet=new int[4][8];
			turn= new int[K][2];
//			v=new boolean[4];
			for(int i=0;i<4;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++) {
					magnet[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<K;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				turn[i][0]=Integer.parseInt(st.nextToken());
				turn[i][1]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<K;i++) {
				v=new boolean[4];
				turn(turn[i][0],turn[i][1]);
			}
			int ans=magnet[0][0]+magnet[1][0]*2+magnet[2][0]*4+magnet[3][0]*8;
			System.out.println("#"+t+" "+ans);
		}
		
		
	}
	
	public static void turn(int num,int d) {
		if(num==1) {
			v[0]=true;
			if(magnet[0][2]!=magnet[1][6]) {
				if(!v[1]) {
					turn(2,d*(-1));
				}
				
			}
		}
		else if(num==2) {
			v[1]=true;
			if(magnet[1][2]!=magnet[2][6]) {
				if(!v[2]) {
					turn(3,d*(-1));
				}
				
			}
			if(magnet[0][2]!=magnet[1][6]) {
				if(!v[0]) {
					turn(1,d*(-1));
				}
			}
		}
		else if(num==3) {
			v[2]=true;
			if(magnet[2][2]!=magnet[3][6]) {
				if(!v[3]) {
					turn(4,d*(-1));
				}
			}
			if(magnet[1][2]!=magnet[2][6]) {
				if(!v[1]) {
					turn(2,d*(-1));
				}
			}
		}
		
		else if(num==4) {
			v[3]=true;
			if(magnet[3][6]!=magnet[2][2]) {
				if(!v[2]) {
					turn(3,d*(-1));
				}
			}
		}
		
		if(d==1) clockwise(magnet[num-1]);
		else counterClockwise(magnet[num-1]);
	}
	
	public static void clockwise(int[] arr) {

		int temp=arr[7];
		
		for(int i=7;i>0;i--) {
			arr[i]=arr[i-1];
		}
		arr[0]=temp;
	}
	
	public static void counterClockwise(int[] arr) {
		int temp=arr[0];
		
		for(int i=0;i<7;i++) {
			arr[i]=arr[i+1];
		}
		arr[7]=temp;
	}

}
