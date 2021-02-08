package BaekJoon;
import java.util.*;
import java.io.*;

public class Main_2564_경비원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int c=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int num=Integer.parseInt(st.nextToken());
		
		int[][] arr=new int[num+1][2];
		
		for(int i=1;i<=num;i++) {
			st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		arr[0][0]=Integer.parseInt(st.nextToken());
		arr[0][1]=Integer.parseInt(st.nextToken());
		
		int[] d=new int[num+1];
		for(int i=0;i<=num;i++) {
			switch(arr[i][0]) {
			case 1:
				d[i]=arr[i][1];
				break;
			case 2:
				d[i]=c+r+c-arr[i][1];
				break;
			case 3:
				d[i]=c+r+c+r-arr[i][1];
				break;
			case 4:
				d[i]=c+arr[i][1];
				break;
			}
		}
		
		int sum=0;
		for(int i=1;i<=num;i++) {
			if(Math.abs(d[0]-d[i])<=r+c) {
				sum+=Math.abs(d[0]-d[i]);
			}
			else {
				sum+=(2*(r+c)-Math.abs(d[0]-d[i]));
			}
		}
		
		System.out.println(sum);
	}

}
