package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_15863_감시 {

	static int N,M,min=Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[][] v;
	static int[] dr= {-1,0,1,0},dc= {0,1,0,-1};
	static ArrayList<int[]> list;
	static int[] sel;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		list=new ArrayList<>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]>=1&&arr[i][j]<6) {
					list.add(new int[] {i,j});
				}
			}
		}
		
		sel=new int[list.size()];
		cctv(0);
		System.out.println(min);
		
	}
	
	public static void copy(int[][] arr1, int[][] arr2) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr1[i][j]=arr2[i][j];
			}
		}
	}
	
	public static void cal(int[][] arr) {
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0) {
					cnt++;
				}
			}
		}
		
		min=Math.min(cnt, min);
		
	}
	
	public static void cctv(int cnt) {
		
		if(cnt==list.size()) {
			int[][] cp=new int[N][M];
			copy(cp,arr);
			for(int i=0;i<list.size();i++) {
				int type=cp[list.get(i)[0]][list.get(i)[1]];
				
				switch(type) {
				case 1:
					cctv1(list.get(i)[0],list.get(i)[1],sel[i],cp);
					break;
				case 2:
					cctv2(list.get(i)[0],list.get(i)[1],sel[i],cp);
					break;
				case 3:
					cctv3(list.get(i)[0],list.get(i)[1],sel[i],cp);
					break;
				case 4:
					cctv4(list.get(i)[0],list.get(i)[1],sel[i],cp);
					break;
				case 5:
					cctv5(list.get(i)[0],list.get(i)[1],sel[i],cp);
					break;
				}
			}
			cal(cp);
			return;
		}
		
		for(int i=0;i<4;i++) {
			sel[cnt]=i;
			cctv(cnt+1);
		}

	}
	
	public static void check(int r, int c, int d, int[][] arr) {
		
		int nr=r+dr[d];
		int nc=c+dc[d];
		
		while(nr>=0 && nr<N && nc>=0 && nc<M && arr[nr][nc]!=6) {
			if(arr[nr][nc]>=1 && arr[nr][nc]<=5) {
				nr+=dr[d];
				nc+=dc[d];
				continue;
			}
			arr[nr][nc]=-1;
			nr+=dr[d];
			nc+=dc[d];
		}
	}
	
	public static void cctv1(int r,int c,int type,int[][] arr) {
		int d=0;
		if(type==0) d=1;
		else if(type==1) d=2;
		else if(type==2) d=3;
		else if(type==3) d=0;
		
		check(r,c,d,arr);
	}
	public static void cctv2(int r,int c,int type,int[][] arr) {
		
		if(type==0||type==2) {
			check(r,c,1,arr);
			check(r,c,3,arr);
		}
		else if(type==1||type==3) { 
			check(r,c,0,arr);
			check(r,c,2,arr);
		}
		
	}
	public static void cctv3(int r,int c,int type,int[][] arr) {
		
		if(type==0) {
			check(r,c,0,arr);
			check(r,c,1,arr);
		}
		else if(type==1) {
			check(r,c,1,arr);
			check(r,c,2,arr);
		}
		else if(type==2) {
			check(r,c,2,arr);
			check(r,c,3,arr);
		}
		else if(type==3) {
			check(r,c,3,arr);
			check(r,c,0,arr);
		}
		
	}
	public static void cctv4(int r,int c,int type,int[][] arr) {
		
		if(type==0) {
			check(r,c,0,arr);
			check(r,c,1,arr);
			check(r,c,3,arr);
		}
		else if(type==1) {
			check(r,c,0,arr);
			check(r,c,1,arr);
			check(r,c,2,arr);
		}
		else if(type==2) {
			check(r,c,1,arr);
			check(r,c,2,arr);
			check(r,c,3,arr);
		}
		else if(type==3) {
			check(r,c,0,arr);
			check(r,c,2,arr);
			check(r,c,3,arr);
		}
		
	}
	
	public static void cctv5(int r,int c,int type,int[][] arr) {
		
		for(int i=0;i<4;i++) {
			check(r,c,i,arr);
		}
		
	}
	
	

}
