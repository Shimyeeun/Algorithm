package BaekJoon;
import java.io.*;
public class Main_1992_쿼드트리 {
	static int N;
	static int[][] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		sb=new StringBuilder();
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j]=s.charAt(j)-'0';
			}
		}
		
		int flag=arr[0][0];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]!=flag) {
					flag=-1;
					break;
				}
			}
		}
		
		if(flag==-1) {
			quadtree(N/2,0,0);
			System.out.println(sb.toString());
		}
		else {
			System.out.println(flag);
		}
			

	}
	
	public static void quadtree(int n,int r,int c) {
		if(n==1) {
			sb.append("("+arr[r][c]);
			sb.append(arr[r][c+n]);
			sb.append(arr[r+n][c]);
			sb.append(arr[r+n][c+n]+")");
			return;
		}
		
		sb.append("(");
		
		int flag1=arr[r][c];
		L1:for(int i=r;i<r+n;i++) {
			for(int j=c;j<c+n;j++) {
				if(arr[i][j]!=flag1) {
					quadtree(n/2,r,c);
					flag1=-1;
					break L1;
				}
				
			}
		}
		
		if(flag1>=0) sb.append(flag1);
		
		int flag2=arr[r][c+n];
		L2:for(int i=r;i<r+n;i++) {
			for(int j=c+n;j<c+2*n;j++) {
				if(arr[i][j]!=flag2) {
					quadtree(n/2,r,c+n);
					flag2=-1;
					break L2;
				}
			}
		}
		
		if(flag2>=0) sb.append(flag2);
		
		int flag3=arr[r+n][c];
		L3:for(int i=r+n;i<r+2*n;i++) {
			for(int j=c;j<c+n;j++) {
				if(arr[i][j]!=flag3) {
					quadtree(n/2,r+n,c);
					flag3=-1;
					break L3;
				}
			}
		}
		
		if(flag3>=0) sb.append(flag3);
		
		int flag4=arr[r+n][c+n];
		L4:for(int i=r+n;i<r+2*n;i++) {
			for(int j=c+n;j<c+2*n;j++) {
				if(arr[i][j]!=flag4) {
					quadtree(n/2,r+n,c+n);
					flag4=-1;
					break L4;
				}
			}
		}
		
		if(flag4>=0) sb.append(flag4);
		sb.append(")");
		
		
	}
	
	

}
