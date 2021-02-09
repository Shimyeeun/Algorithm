package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_2563_색종이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[][] arr=new int[101][101];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			for(int j=x;j<x+10;j++) {
				for(int k=y;k<y+10;k++) {
					arr[j][k]=1;
				}
			}
		}
		int cnt=0;
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(arr[i][j]==1) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);	

	}

}
