package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_10163_색종이 {

	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		int[][] arr=new int[102][102];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			int h=Integer.parseInt(st.nextToken());
			
			for(int j=r;j<r+w;j++) {
				for(int k=c;k<c+h;k++) {
					arr[j][k]=i;
				}
			}
		}
		
		int num=1;
		while(num<=N) {
			int ncnt=0;
			for(int i=0;i<=101;i++) {
				for(int j=0;j<=101;j++) {
					if(arr[i][j]==num) {
						ncnt++;
					}
				}
			}
			num++;
			sb.append(ncnt+"\n");
		}
		
		
		System.out.println(sb.toString());	

	}

}
