package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1932_정수삼각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		int[][] arr=new int[n][n];
		
		
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=n-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(arr[i][j]>arr[i][j+1]) {
					arr[i-1][j]=arr[i-1][j]+arr[i][j];					
				}
				else {
					arr[i-1][j]=arr[i-1][j]+arr[i][j+1];
				}
			}
		}
		
		System.out.println(arr[0][0]);	
		
		
		
	}
	

}
