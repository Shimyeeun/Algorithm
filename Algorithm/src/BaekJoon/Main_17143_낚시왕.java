package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_17143_낚시왕 {
	
	static class shark{
		int r,c,s,d,z;
		
		shark(){};
		shark(int r,int c,int s,int d,int z){
			this.r=r;
			this.c=c;
			this.s=s;
			this.d=d;
			this.z=z;
		}
		
	}
	
	static int R,C,M,ans;
	static int[][] arr;
	static ArrayList<shark> sharks;
	static int[] dr= {0,-1,1,0,0},dc= {0,0,0,1,-1};

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		ans=0;
		arr=new int[R+1][C+1];
		
		sharks=new ArrayList<>();
		
		for(int i=1;i<=M;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int z=Integer.parseInt(st.nextToken());
			
			sharks.add(new shark(r,c,s,d,z));
			arr[r][c]=i;
		}
		
		int fisher=1;
		while(fisher<=C) {
			
			for(int i=1;i<=R;i++) {
				if(arr[i][fisher]!=0) {
//					System.out.println(sharks.get(arr[i][fisher]-1).z);
					ans+=sharks.get(arr[i][fisher]-1).z;
					arr[i][fisher]=0;
					break;
				}
			}
			
			move();
			fisher++;	
		}
		
		System.out.println(ans);
		

	}
	
	public static void copy(int[][] arr1, int[][] arr2) {
		for(int i=0;i<R+1;i++) {
			for(int j=0;j<C+1;j++) {
				arr1[i][j]=arr2[i][j];
			}
		}
	}
	
	
	public static void move() {
		int[][] cparr=new int[R+1][C+1];
		
		for(int i=1;i<=R;i++) {
			for(int j=1;j<=C;j++) {
				if(arr[i][j]!=0) {
					shark sh=sharks.get(arr[i][j]-1);
					int nr=i;
					int nc=j;
					int sd=0;
					if(sh.d==1||sh.d==2) {
						sd=sh.s%((R-1)*2);
												
						for(int k=0;k<sd;k++) {
							nr=nr+dr[sh.d];
							if(nr>=R) {
								sh.d=1;
								if(nr>R) {
									nr-=2;
								}
							}
							else if(nr<=1) {
								sh.d=2;
								if(nr<1) {
									nr+=2;
								}
							}
						}
						
						if(cparr[nr][j]==0) {
							cparr[nr][j]=arr[i][j];		
						}
						else {
							if(sharks.get(cparr[nr][j]-1).z<sh.z) {
								cparr[nr][j]=arr[i][j];
							}
						}
						
					}
					else if(sh.d==3||sh.d==4) {
						sd=sh.s%((C-1)*2);
						
						for(int k=0;k<sd;k++) {
							nc=nc+dc[sh.d];
							if(nc>=C) {
								sh.d=4;
								if(nc>C) {
									nc-=2;
								}
							}
							else if(nc<=1) {
								sh.d=3;
								if(nc<1) {
									nc+=2;
								}
							}
						}
						
						if(cparr[i][nc]==0) {
							cparr[i][nc]=arr[i][j];		
						}
						else {
							if(sharks.get(cparr[i][nc]-1).z<sh.z) {
								cparr[i][nc]=arr[i][j];
							}
						}
					}
				}
			}
		}
		
		copy(arr,cparr);
	}

}
